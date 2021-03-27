package Elevator.model;

import java.io.Serializable;

/**
 * Elevator Model Class
 * 
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public class Elevator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String currentFloorLocation;
	private String destinationFloorLocation;
	private boolean isBellRing = false;
	private boolean isDoorOpen = false;
	private boolean isMove = false;

	private Button firstFloorButton;
	private Button secondFloorButton;

	private Door firstFloorDoor;
	private Door secondFloorDoor;

	private Light firstFloorLight;
	private Light secondFloorLight;
	
	private Floor firstFloor;
	private Floor secondFloor;
	
	private int numberOfPeople = 0;

	public String getCurrentFloorLocation() {
		return currentFloorLocation;
	}

	public void setCurrentFloorLocation(String currentFloorLocation) {
		this.currentFloorLocation = currentFloorLocation;
	}

	public String getDestinationFloorLocation() {
		return destinationFloorLocation;
	}

	public void setDestinationFloorLocation(String destinationFloorLocation) {
		this.destinationFloorLocation = destinationFloorLocation;
	}

	public boolean isBellRing() {
		return isBellRing;
	}

	public void setBellRing(boolean isBellRing) {
		this.isBellRing = isBellRing;
	}

	public boolean isDoorOpen() {
		return isDoorOpen;
	}

	public void setDoorOpen(boolean isDoorOpen) {
		this.isDoorOpen = isDoorOpen;
	}

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
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


}
