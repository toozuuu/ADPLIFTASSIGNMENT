package elevator.model;

import java.io.Serializable;

import elevator.event.*;

public class ElevatorDoor extends Door implements ElevatorMoveListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public synchronized void openDoor(Location location) {
		location.getDoor().openDoor(location);
		super.openDoor(location);
	}

	@Override
	public synchronized void closeDoor(Location location) {
		location.getDoor().closeDoor(location);
		super.closeDoor(location);
	}

	public void elevatorArrived(ElevatorMoveEvent moveEvent) {
		openDoor(moveEvent.getLocation());
	}

	@Override
	public void elevatorDeparted(ElevatorMoveEvent moveEvent) {
		// TODO Auto-generated method stub

	}
}
