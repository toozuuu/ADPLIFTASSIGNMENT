package Elevator.model;

import java.io.Serializable;

/**
 * Elevator Model Class
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public class Elevator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String currentFloorLocation;
	private String destinationFloorLocation;
	private boolean isBellRing = false;
	private boolean isDoorOpen = false;
	private boolean isMove = false;

	public String getCurrentFloorLocation() {
		return currentFloorLocation;
	}

	public void setCurrentFloorLocation(String currentFloorLocation) {
		this.currentFloorLocation = currentFloorLocation;
	}

	public String getDestinationFloorLocation() {
		return destinationFloorLocation;
	}

	public void setDestinationFloorLocation(String destinationFloorLocation) {
		this.destinationFloorLocation = destinationFloorLocation;
	}

	public boolean isBellRing() {
		return isBellRing;
	}

	public void setBellRing(boolean isBellRing) {
		this.isBellRing = isBellRing;
	}

	public boolean isDoorOpen() {
		return isDoorOpen;
	}

	public void setDoorOpen(boolean isDoorOpen) {
		this.isDoorOpen = isDoorOpen;
	}

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

}
