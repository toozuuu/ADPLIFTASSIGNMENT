package Elevator.model;

import java.io.Serializable;

public class Light implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean lightStatus;

	public boolean isLightStatus() {
		return lightStatus;
	}

	public void setLightStatus(boolean lightStatus) {
		this.lightStatus = lightStatus;
	}

}
