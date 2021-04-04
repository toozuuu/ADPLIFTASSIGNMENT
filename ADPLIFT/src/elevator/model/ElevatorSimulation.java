package elevator.model;

import java.io.Serializable;
import java.util.*;

import elevator.ElevatorGlobalValues;
import elevator.event.*;

public class ElevatorSimulation implements ElevatorSimulationListener, ElevatorGlobalValues, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Floor firstFloor;
	private Floor secondFloor;

	private ElevatorShaft elevatorShaft;

	private Set<PersonMoveListener> personMoveListeners;
	private DoorListener doorListener;
	private ButtonListener buttonListener;
	private LightListener lightListener;
	private ElevatorMoveListener elevatorMoveListener;

	private static int peopleCount = NUMBER_OF_PEOPLE;

	public ElevatorSimulation() {

		firstFloor = new Floor(FIRST_FLOOR_NAME);
		secondFloor = new Floor(SECOND_FLOOR_NAME);

		elevatorShaft = new ElevatorShaft(firstFloor, secondFloor);

		firstFloor.setElevatorShaft(elevatorShaft);
		secondFloor.setElevatorShaft(elevatorShaft);

		elevatorShaft.setDoorListener(this);
		elevatorShaft.setButtonListener(this);
		elevatorShaft.addElevatorMoveListener(this);
		elevatorShaft.setLightListener(this);

		personMoveListeners = new HashSet<>(1);

	}

	private Floor getFloor(String name) {
		if (name.equals(FIRST_FLOOR_NAME))
			return firstFloor;
		else

		if (name.equals(SECOND_FLOOR_NAME))
			return secondFloor;
		else
			return null;

	}

	public void addPerson(String floorName) {

		Person person = new Person(peopleCount, getFloor(floorName));
		person.setName(Integer.toString(peopleCount));

		person.setPersonMoveListener(this);

		person.start();

		peopleCount++;

	}

	public void elevatorDeparted(ElevatorMoveEvent moveEvent) {
		elevatorMoveListener.elevatorDeparted(moveEvent);
	}

	public void elevatorArrived(ElevatorMoveEvent moveEvent) {
		elevatorMoveListener.elevatorArrived(moveEvent);
	}

	private void sendPersonMoveEvent(int eventType, PersonMoveEvent event) {
		Iterator<PersonMoveListener> iterator = personMoveListeners.iterator();

		while (iterator.hasNext()) {

			PersonMoveListener listener = iterator.next();

			switch (eventType) {

			case PERSON_CREATED:
				listener.personCreated(event);
				break;

			case PERSON_ARRIVED:
				listener.personArrived(event);
				break;

			case PERSON_ENTERING_ELEVATOR:
				listener.personEntered(event);
				break;

			case PERSON_PRESSING_BUTTON:
				listener.personPressedButton(event);
				break;

			case PERSON_EXITING_ELEVATOR:
				listener.personDeparted(event);
				break;

			case PERSON_EXITED:
				listener.personExited(event);
				break;

			default:
				break;
			}
		}
	}

	public void personCreated(PersonMoveEvent moveEvent) {
		sendPersonMoveEvent(PERSON_CREATED, moveEvent);
	}

	public void personArrived(PersonMoveEvent moveEvent) {
		sendPersonMoveEvent(PERSON_ARRIVED, moveEvent);
	}

	public void personPressedButton(PersonMoveEvent moveEvent) {
		sendPersonMoveEvent(PERSON_PRESSING_BUTTON, moveEvent);
	}

	public void personEntered(PersonMoveEvent moveEvent) {
		sendPersonMoveEvent(PERSON_ENTERING_ELEVATOR, moveEvent);
	}

	public void personDeparted(PersonMoveEvent moveEvent) {
		sendPersonMoveEvent(PERSON_EXITING_ELEVATOR, moveEvent);
	}

	public void personExited(PersonMoveEvent moveEvent) {
		sendPersonMoveEvent(PERSON_EXITED, moveEvent);
	}

	public void doorOpened(DoorEvent doorEvent) {
		doorListener.doorOpened(doorEvent);
	}

	public void doorClosed(DoorEvent doorEvent) {
		doorListener.doorClosed(doorEvent);
	}

	public void buttonPressed(ButtonEvent buttonEvent) {
		buttonListener.buttonPressed(buttonEvent);
	}

	public void buttonReset(ButtonEvent buttonEvent) {
		buttonListener.buttonReset(buttonEvent);
	}

	public void lightTurnedOn(LightEvent lightEvent) {
		lightListener.lightTurnedOn(lightEvent);
	}

	public void lightTurnedOff(LightEvent lightEvent) {
		lightListener.lightTurnedOff(lightEvent);
	}

	public void setElevatorSimulationListener(ElevatorSimulationListener listener) {

		addPersonMoveListener(listener);
		setElevatorMoveListener(listener);
		setDoorListener(listener);
		setButtonListener(listener);
		setLightListener(listener);
	}

	public void addPersonMoveListener(PersonMoveListener listener) {
		personMoveListeners.add(listener);
	}

	public void setDoorListener(DoorListener listener) {
		doorListener = listener;
	}

	public void setButtonListener(ButtonListener listener) {
		buttonListener = listener;
	}

	public void setElevatorMoveListener(ElevatorMoveListener listener) {
		elevatorMoveListener = listener;
	}

	public void setLightListener(LightListener listener) {
		lightListener = listener;
	}

}
