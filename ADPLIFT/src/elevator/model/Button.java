package elevator.model;

import java.io.Serializable;

import elevator.event.*;

public class Button implements ElevatorMoveListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ButtonListener buttonListener = null;

	private boolean pressed = false;

	public void setButtonListener(ButtonListener listener) {
		buttonListener = listener;
	}

	public void pressButton(Location location) {
		pressed = true;

		buttonListener.buttonPressed(new ButtonEvent(this, location));
	}

	public void resetButton(Location location) {
		pressed = false;

		buttonListener.buttonReset(new ButtonEvent(this, location));
	}

	public boolean isButtonPressed() {
		return pressed;
	}

	public void elevatorArrived(ElevatorMoveEvent moveEvent) {
		resetButton(moveEvent.getLocation());
	}

	@Override
	public void elevatorDeparted(ElevatorMoveEvent moveEvent) {
		// TODO Auto-generated method stub
		
	}
}
