package elevator.model;

import java.io.Serializable;
import java.util.*;

import elevator.ElevatorGlobalValues;
import elevator.event.*;

public class Elevator extends Location implements Runnable, BellListener, ElevatorGlobalValues, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean elevatorRunning = false;

	private boolean moving = false;

	private Location currentFloorLocation;

	private Location destinationFloorLocation;

	private boolean summoned;

	private Set<ElevatorMoveListener> elevatorMoveListeners;
	private BellListener bellListener;
	private ButtonListener elevatorButtonListener;
	private DoorListener elevatorDoorListener;

	private ElevatorDoor elevatorDoor;
	private Button elevatorButton;
	private Bell bell;

	public static final int ONE_SECOND = 1000;

	private static final int TRAVEL_TIME = 5 * ONE_SECOND;

	private Thread thread;

	public Elevator(Floor firstFloor, Floor secondFloor) {
		setLocationName(ELEVATOR_NAME);

		elevatorDoor = new ElevatorDoor();
		elevatorButton = new Button();
		bell = new Bell();

		bell.setBellListener(this);

		elevatorMoveListeners = new HashSet<ElevatorMoveListener>(1);

		currentFloorLocation = firstFloor;
		destinationFloorLocation = secondFloor;

		addElevatorMoveListener(elevatorButton);

		addElevatorMoveListener(elevatorDoor);

		addElevatorMoveListener(bell);

		elevatorButton.setButtonListener(new ButtonListener() {

			public void buttonPressed(ButtonEvent buttonEvent) {

				elevatorButtonListener.buttonPressed(buttonEvent);

				setMoving(true);
			}

			public void buttonReset(ButtonEvent buttonEvent) {

				elevatorButtonListener.buttonReset(buttonEvent);
			}
		});

		elevatorDoor.addDoorListener(new DoorListener() {

			public void doorOpened(DoorEvent doorEvent) {

				elevatorDoorListener.doorOpened(new DoorEvent(doorEvent.getSource(), Elevator.this));
			}

			public void doorClosed(DoorEvent doorEvent) {

				elevatorDoorListener.doorClosed(new DoorEvent(doorEvent.getSource(), Elevator.this));
			}
		});
	}

	private void changeFloors() {
		Location location = currentFloorLocation;
		currentFloorLocation = destinationFloorLocation;
		destinationFloorLocation = location;
	}

	public void start() {
		if (thread == null)
			thread = new Thread(this);

		elevatorRunning = true;
		thread.start();
	}

	public void stopElevator() {
		elevatorRunning = false;
	}

	public void run() {
		while (isElevatorRunning()) {

			while (!isMoving())
				pauseThread(10);

			pauseThread(ONE_SECOND);

			getDoor().closeDoor(currentFloorLocation);

			pauseThread(ONE_SECOND);

			sendDepartureEvent(currentFloorLocation);

			pauseThread(TRAVEL_TIME);

			setMoving(false);

			changeFloors();

			sendArrivalEvent(currentFloorLocation);

		}

	}

	private void pauseThread(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}

		catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}

	public Button getButton() {
		return elevatorButton;
	}

	public Door getDoor() {
		return elevatorDoor;
	}

	private void setMoving(boolean elevatorMoving) {
		moving = elevatorMoving;
	}

	public boolean isMoving() {
		return moving;
	}

	private boolean isElevatorRunning() {
		return elevatorRunning;
	}

	public void addElevatorMoveListener(ElevatorMoveListener listener) {
		elevatorMoveListeners.add(listener);
	}

	public void setBellListener(BellListener listener) {
		bellListener = listener;
	}

	public void setButtonListener(ButtonListener listener) {
		elevatorButtonListener = listener;
	}

	public void setDoorListener(DoorListener listener) {
		elevatorDoorListener = listener;
	}

	private void sendArrivalEvent(Location location) {

		Iterator<ElevatorMoveListener> iterator = elevatorMoveListeners.iterator();

		while (iterator.hasNext()) {

			ElevatorMoveListener listener = (ElevatorMoveListener) iterator.next();

			listener.elevatorArrived(new ElevatorMoveEvent(this, location));

		}

		if (summoned) {
			setMoving(true);
		}

		summoned = false;

	}

	private void sendDepartureEvent(Location location) {

		Iterator<ElevatorMoveListener> iterator = elevatorMoveListeners.iterator();

		while (iterator.hasNext()) {

			ElevatorMoveListener listener = (ElevatorMoveListener) iterator.next();

			listener.elevatorDeparted(new ElevatorMoveEvent(this, currentFloorLocation));

		}
	}

	public void requestElevator(Location location) {

		if (!isMoving()) {

			if (location == currentFloorLocation)

				sendArrivalEvent(currentFloorLocation);

			else {
				setMoving(true);
			}
		} else

		if (location == currentFloorLocation)
			summoned = true;

	}

	public void bellRang(BellEvent bellEvent) {

		if (bellListener != null)
			bellListener.bellRang(bellEvent);
	}

	public Location getCurrentFloor() {
		return currentFloorLocation;
	}
}
