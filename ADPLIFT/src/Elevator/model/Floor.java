package Elevator.model;

import java.io.Serializable;

/**
 * Floor Model Class
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public class Floor extends Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ElevatorShaft elevatorShaft;
	
	public ElevatorShaft getElevatorShaft() {
		return elevatorShaft;
	}
	public void setElevatorShaft(ElevatorShaft elevatorShaft) {
		this.elevatorShaft = elevatorShaft;
	}
	
}
