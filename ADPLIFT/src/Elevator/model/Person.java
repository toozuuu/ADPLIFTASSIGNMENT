package Elevator.model;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Location location;
	
	private boolean isMove = false;

	public static final int WAKK_TIME = 3000;
	public static final int PERSON_CREATED = 1;
	public static final int PERSON_ARRIVED = 2;
	public static final int PERSON_ENTERING_ELEVATOR = 3;
	public static final int PERSON_EXITING_ELEVATOR = 5;
	public static final int PERSON_EXITED = 6;
	public static final int PERSON_PRESSING_BUTTON = 4;

	
	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
