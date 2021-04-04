package elevator.model;

import java.io.Serializable;

import elevator.ElevatorGlobalValues;
import elevator.event.*;

public class Light implements ElevatorMoveListener, Serializable,ElevatorGlobalValues {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean lightOn;


	private LightListener lightListener;

	private Location lightLocation;

	public void setLightListener(LightListener listener) {
		lightListener = listener;
	}

	public void turnOnLight(Location location) {
		if (!lightOn) {

			lightOn = true;

			lightListener.lightTurnedOn(new LightEvent(this, location));

			lightLocation = location;

			Thread thread = new Thread(new Runnable() {

				public void run() {

					try {
						Thread.sleep(AUTOMATIC_TURNOFF_DELAY);
						turnOffLight(lightLocation);
					}

					catch (InterruptedException exception) {
						exception.printStackTrace();
					}
				}
			});

			thread.start();
		}
	}

	public void turnOffLight(Location location) {
		if (lightOn) {

			lightOn = false;

			lightListener.lightTurnedOff(new LightEvent(this, location));
		}
	}

	public boolean isLightOn() {
		return lightOn;
	}

	public void elevatorDeparted(ElevatorMoveEvent moveEvent) {
		turnOffLight(moveEvent.getLocation());
	}

	public void elevatorArrived(ElevatorMoveEvent moveEvent) {
		turnOnLight(moveEvent.getLocation());
	}
}
