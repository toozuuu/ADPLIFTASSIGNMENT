package Elevator.model;

import java.io.Serializable;

import Elevator.GlobalVariables;

/**
 * ElevatorSimulation Model Class
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public class ElevatorSimulation extends GlobalVariables implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Floor firstFloor;
	private Floor secondFloor;

	private ElevatorShaft elevatorShaft;

	private int numberOfPeople = 0;

	public Floor getFirstFloor() {
		return firstFloor;
	}

	public void setFirstFloor(Floor firstFloor) {
		this.firstFloor = firstFloor;
	}

	public Floor getSecondFloor() {
		return secondFloor;
	}

	public void setSecondFloor(Floor secondFloor) {
		this.secondFloor = secondFloor;
	}

	public ElevatorShaft getElevatorShaft() {
		return elevatorShaft;
	}

	public void setElevatorShaft(ElevatorShaft elevatorShaft) {
		this.elevatorShaft = elevatorShaft;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}


}
