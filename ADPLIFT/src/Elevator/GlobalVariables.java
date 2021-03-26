package Elevator;

/**
 * Manage Global Variables
 * 
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public interface GlobalVariables  {
	
	public static final String FIRST_FLOOR_NAME = "firstFloor";
	public static final String SECOND_FLOOR_NAME = "secondFloor";
	public static final String ELEVATOR_NAME = "elevator";

	public static final int WAKK_TIME = 3000;
	public static final int AUTOMATIC_CLOSE_DELAY = 3000;

	public static final int PERSON_CREATED = 1;
	public static final int PERSON_ARRIVED = 2;
	public static final int PERSON_ENTERING_ELEVATOR = 3;
	public static final int PERSON_EXITING_ELEVATOR = 5;
	public static final int PERSON_EXITED = 6;
	public static final int PERSON_PRESSING_BUTTON = 4;

}
