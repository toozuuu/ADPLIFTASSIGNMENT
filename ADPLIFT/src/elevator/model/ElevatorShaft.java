package elevator.model;

import java.io.Serializable;
import java.util.*;

import elevator.event.*;

public class ElevatorShaft implements ElevatorMoveListener, LightListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Elevator elevator;

	private Button firstFloorButton;
	private Button secondFloorButton;

	private Door firstFloorDoor;
	private Door secondFloorDoor;

	private Light firstFloorLight;
	private Light secondFloorLight;

	private DoorListener doorListener;
	private ButtonListener buttonListener;
	private LightListener lightListener;
	private Set<ElevatorMoveListener> elevatorMoveListeners;

	public ElevatorShaft(Floor firstFloor, Floor secondFloor) {

		elevatorMoveListeners = new HashSet<>(1);

		ButtonListener floorButtonListener = new ButtonListener() {

			public void buttonPressed(ButtonEvent buttonEvent) {

				Location location = buttonEvent.getLocation();
				buttonListener.buttonPressed(buttonEvent);
				elevator.requestElevator(location);
			}

			public void buttonReset(ButtonEvent buttonEvent) {
				buttonListener.buttonReset(buttonEvent);
			}
		};

		firstFloorButton = new Button();
		secondFloorButton = new Button();

		firstFloorButton.setButtonListener(floorButtonListener);
		secondFloorButton.setButtonListener(floorButtonListener);

		addElevatorMoveListener(firstFloorButton);
		addElevatorMoveListener(secondFloorButton);

		DoorListener floorDoorListener = new DoorListener() {

			public void doorOpened(DoorEvent doorEvent) {

				doorListener.doorOpened(doorEvent);
			}

			public void doorClosed(DoorEvent doorEvent) {

				doorListener.doorClosed(doorEvent);
			}
		};

		firstFloorDoor = new Door();
		secondFloorDoor = new Door();

		firstFloorDoor.addDoorListener(floorDoorListener);
		secondFloorDoor.addDoorListener(floorDoorListener);

		firstFloorLight = new Light();
		addElevatorMoveListener(firstFloorLight);
		firstFloorLight.setLightListener(this);

		secondFloorLight = new Light();
		addElevatorMoveListener(secondFloorLight);
		secondFloorLight.setLightListener(this);

		elevator = new Elevator(firstFloor, secondFloor);

		elevator.addElevatorMoveListener(this);

		elevator.setButtonListener(new ButtonListener() {

			public void buttonPressed(ButtonEvent buttonEvent) {

				buttonListener.buttonPressed(buttonEvent);
			}

			public void buttonReset(ButtonEvent buttonEvent) {

				buttonListener.buttonReset(new ButtonEvent(this, elevator));
			}
		});

		elevator.setDoorListener(new DoorListener() {

			public void doorOpened(DoorEvent doorEvent) {

				doorListener.doorOpened(doorEvent);
			}

			public void doorClosed(DoorEvent doorEvent) {

				doorListener.doorClosed(doorEvent);
			}
		});

		elevator.start();

	}

	public Elevator getElevator() {
		return elevator;
	}

	public Door getFirstFloorDoor() {
		return firstFloorDoor;
	}

	public Door getSecondFloorDoor() {
		return secondFloorDoor;
	}

	public Button getFirstFloorButton() {
		return firstFloorButton;
	}

	public Button getSecondFloorButton() {
		return secondFloorButton;
	}

	public Light getFirstFloorLight() {
		return firstFloorLight;
	}

	public Light getSecondFloorLight() {
		return secondFloorLight;
	}

	public void lightTurnedOn(LightEvent lightEvent) {
		lightListener.lightTurnedOn(lightEvent);
	}

	public void lightTurnedOff(LightEvent lightEvent) {
		lightListener.lightTurnedOff(lightEvent);
	}

	public void elevatorDeparted(ElevatorMoveEvent moveEvent) {
		Iterator<ElevatorMoveListener> iterator = elevatorMoveListeners.iterator();

		while (iterator.hasNext()) {

			ElevatorMoveListener listener = (ElevatorMoveListener) iterator.next();

			listener.elevatorDeparted(moveEvent);
		}
	}

	public void elevatorArrived(ElevatorMoveEvent moveEvent) {

		Iterator<ElevatorMoveListener> iterator = elevatorMoveListeners.iterator();

		while (iterator.hasNext()) {

			ElevatorMoveListener listener = (ElevatorMoveListener) iterator.next();

			listener.elevatorArrived(moveEvent);

		}
	}

	public void setDoorListener(DoorListener listener) {
		doorListener = listener;
	}

	public void setButtonListener(ButtonListener listener) {
		buttonListener = listener;
	}

	public void addElevatorMoveListener(ElevatorMoveListener listener) {
		elevatorMoveListeners.add(listener);
	}

	public void setLightListener(LightListener listener) {
		lightListener = listener;
	}

}
