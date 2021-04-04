package elevator.model;

import java.io.Serializable;

public abstract class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	protected void setLocationName(String name) {
		this.name = name;
	}

	public String getLocationName() {
		return name;
	}

	public abstract Button getButton();

	public abstract Door getDoor();
}
