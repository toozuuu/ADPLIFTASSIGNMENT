package Elevator.model;

import java.io.Serializable;

public class Door implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isOpen = false;

	private Location doorLocation;

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Location getDoorLocation() {
		return doorLocation;
	}

	public void setDoorLocation(Location doorLocation) {
		this.doorLocation = doorLocation;
	}

}
