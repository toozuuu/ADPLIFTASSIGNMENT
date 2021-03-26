package Elevator.model;

import java.io.Serializable;

/**
 * Light Model Class
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

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
