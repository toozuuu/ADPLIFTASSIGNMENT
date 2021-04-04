package elevator.event;

import elevator.model.*;

public class PersonMoveEvent extends ElevatorSimulationEvent {

	private int id;

	public PersonMoveEvent(Object source, Location location, long l) {
		super(source, location);
		id = (int) l;
	}

	public int getID() {
		return (id);
	}
}
