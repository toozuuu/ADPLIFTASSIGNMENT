package Elevator.model;

public class Person {

	private String destinationFloorLocation;
	private boolean isMove = false;

	private static final int TIME_TO_WALK = 3000;
	public static final int PERSON_CREATED = 1;
	public static final int PERSON_ARRIVED = 2;
	public static final int PERSON_ENTERING_ELEVATOR = 3;
	public static final int PERSON_EXITING_ELEVATOR = 5;
	public static final int PERSON_EXITED = 6;
	public static final int PERSON_PRESSING_BUTTON = 4;

	public String getDestinationFloorLocation() {
		return destinationFloorLocation;
	}

	public void setDestinationFloorLocation(String destinationFloorLocation) {
		this.destinationFloorLocation = destinationFloorLocation;
	}

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

}
