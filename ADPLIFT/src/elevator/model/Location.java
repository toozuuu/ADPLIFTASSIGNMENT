package elevator.model;

import java.io.Serializable;

public abstract class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String locationName;

	protected void setLocationName(String name) {
		locationName = name;
	}

	public String getLocationName() {
		return locationName;
	}

	public abstract Button getButton();

	public abstract Door getDoor();
}
