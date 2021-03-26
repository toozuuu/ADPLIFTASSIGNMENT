package Elevator.model;

import java.io.Serializable;

/**
 * Location Model Class
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public class Location implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String locationName;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
