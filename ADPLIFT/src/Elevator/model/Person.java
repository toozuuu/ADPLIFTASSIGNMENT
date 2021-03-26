package Elevator.model;

import java.io.Serializable;

import Elevator.GlobalVariables;

/**
 * Person Model Class
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public class Person extends GlobalVariables implements Serializable {

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
