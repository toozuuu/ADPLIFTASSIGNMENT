package Elevator.model;

import java.io.Serializable;

/**
 * Button Model Class
 * @author H.D.Sachin Dilshan
 * @version 1.0.0
 * @since Version 1.0.0
 */

public class Button implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isPressed = false;

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
}
