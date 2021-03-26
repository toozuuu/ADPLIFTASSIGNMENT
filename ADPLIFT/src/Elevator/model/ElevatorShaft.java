package Elevator.model;

import java.io.Serializable;

public class ElevatorShaft implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Elevator elevator;

	private Button firstFloorButton;
	private Button secondFloorButton;

	private Door firstFloorDoor;
	private Door secondFloorDoor;

	private Light firstFloorLight;
	private Light secondFloorLight;

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	public Button getFirstFloorButton() {
		return firstFloorButton;
	}

	public void setFirstFloorButton(Button firstFloorButton) {
		this.firstFloorButton = firstFloorButton;
	}

	public Button getSecondFloorButton() {
		return secondFloorButton;
	}

	public void setSecondFloorButton(Button secondFloorButton) {
		this.secondFloorButton = secondFloorButton;
	}

	public Door getFirstFloorDoor() {
		return firstFloorDoor;
	}

	public void setFirstFloorDoor(Door firstFloorDoor) {
		this.firstFloorDoor = firstFloorDoor;
	}

	public Door getSecondFloorDoor() {
		return secondFloorDoor;
	}

	public void setSecondFloorDoor(Door secondFloorDoor) {
		this.secondFloorDoor = secondFloorDoor;
	}

	public Light getFirstFloorLight() {
		return firstFloorLight;
	}

	public void setFirstFloorLight(Light firstFloorLight) {
		this.firstFloorLight = firstFloorLight;
	}

	public Light getSecondFloorLight() {
		return secondFloorLight;
	}

	public void setSecondFloorLight(Light secondFloorLight) {
		this.secondFloorLight = secondFloorLight;
	}

}
