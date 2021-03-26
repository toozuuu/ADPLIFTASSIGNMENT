package Elevator.model;

import java.io.Serializable;

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
