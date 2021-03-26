package Elevator.model;

import java.io.Serializable;

import Elevator.GlobalVariables;

public class Person implements Serializable, GlobalVariables {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Location location;

	private boolean isMove = false;

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
