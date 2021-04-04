package elevator.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Java extension package
import javax.swing.*;

import elevator.ElevatorGlobalValues;
import elevator.event.*;

public class ElevatorView extends JPanel implements ActionListener, ElevatorSimulationListener, ElevatorGlobalValues {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int PERSON_TO_ELEVATOR_DISTANCE = PERSON_TO_BUTTON_DISTANCE + BUTTON_TO_ELEVATOR_DISTANCE;

	private static final String doorFrames[] = { "images/door1.png", "images/door2.png", "images/door3.png",
			"images/door4.png", "images/door5.png" };

	private static final String personFrames[] = { "images/manF.png", "images/manF.png", "images/manF.png",
			"images/manF.png", "images/manF.png", "images/manB.png", "images/manB.png", "images/manB.png" };

	private static final String lightFrames[] = { "images/lightOff.png", "images/lightOn.png" };

	private static final String firstFloorLightFrames[] = { "images/firstFloorLightOff.png",
			"images/firstFloorLightOn.png" };

	private static final String secondFloorLightFrames[] = { "images/secondFloorLightOff.png",
			"images/secondFloorLightOn.png", };

	private static final String floorButtonFrames[] = { "images/floorButtonUnpressed.png",
			"images/floorButtonPressed.png", "images/floorButtonLit.png" };

	private static final String elevatorButtonFrames[] = { "images/elevatorButtonUnpressed.png",
			"images/elevatorButtonPressed.png", "images/elevatorButtonLit.png" };

	private static final String floorImage = "images/floor.png";
	private static final String ceilingImage = "images/ceiling.png";
	private static final String elevatorImage = "images/Elevator.png";
	private static final String wallImage = "images/wall.jpg";
	private static final String elevatorShaftImage = "images/elevatorShaft.png";

	private ImagePanel firstFloorPanel;
	private ImagePanel secondFloorPanel;
	private ImagePanel elevatorShaftPanel;
	private ImagePanel wallPanel;
	private ImagePanel ceilingPanel;

	private MovingPanel elevatorPanel;

	private AnimatedPanel firstFloorButtonPanel;
	private AnimatedPanel secondFloorButtonPanel;
	private AnimatedPanel elevatorButtonPanel;
	private AnimatedPanel elevatorLightPanel;
	private AnimatedPanel firstFloorLightPanel;
	private AnimatedPanel secondFloorLightPanel;
	private AnimatedPanel doorPanel;

	private java.util.List<AnimatedPanel> personAnimatedPanels;

	private javax.swing.Timer animationTimer;

	private int firstFloorPosition;
	private int secondFloorPosition;

	private double elevatorVelocity;

	public ElevatorView() {

		super(null);

		instantiatePanels();
		placePanelsOnView();

		double floorDistance = (double) (firstFloorPosition - secondFloorPosition);

		double time = ELEVATOR_TRAVEL_TIME / (double) ANIMATION_DELAY;

		elevatorVelocity = (floorDistance + OFFSET) / time;

		startAnimation();

	}

	private void instantiatePanels() {

		firstFloorPanel = new ImagePanel(0, floorImage);
		secondFloorPanel = new ImagePanel(0, floorImage);

		firstFloorPosition = VIEW_HEIGHT - firstFloorPanel.getHeight();
		secondFloorPosition = (firstFloorPosition / 2) - OFFSET;

		firstFloorPanel.setPosition(0, firstFloorPosition);
		secondFloorPanel.setPosition(0, secondFloorPosition);

		wallPanel = new ImagePanel(0, wallImage);

		elevatorShaftPanel = new ImagePanel(0, elevatorShaftImage);

		double xPosition = PERSON_TO_ELEVATOR_DISTANCE + (double) OFFSET;
		double yPosition = firstFloorPosition - (double) elevatorShaftPanel.getHeight();

		elevatorShaftPanel.setPosition(xPosition, yPosition);

		ceilingPanel = new ImagePanel(0, ceilingImage);

		yPosition = elevatorShaftPanel.getPosition().getY() - ceilingPanel.getHeight();

		ceilingPanel.setPosition(xPosition, yPosition);

		elevatorPanel = new MovingPanel(0, elevatorImage);

		yPosition = firstFloorPosition - (double) elevatorPanel.getHeight();

		elevatorPanel.setPosition(xPosition, yPosition);

		firstFloorButtonPanel = new AnimatedPanel(0, floorButtonFrames);

		xPosition = PERSON_TO_BUTTON_DISTANCE + 2 * OFFSET;
		yPosition = firstFloorPosition - (double) 5 * OFFSET;
		firstFloorButtonPanel.setPosition(xPosition, yPosition);

		int floorButtonPressedFrameOrder[] = { 0, 1, 2 };
		firstFloorButtonPanel.addFrameSequence(floorButtonPressedFrameOrder);

		secondFloorButtonPanel = new AnimatedPanel(1, floorButtonFrames);

		xPosition = PERSON_TO_BUTTON_DISTANCE + (double) (2 * OFFSET);
		yPosition = secondFloorPosition - (double) (5 * OFFSET);
		secondFloorButtonPanel.setPosition(xPosition, yPosition);

		secondFloorButtonPanel.addFrameSequence(floorButtonPressedFrameOrder);

		firstFloorLightPanel = new AnimatedPanel(0, firstFloorLightFrames);

		xPosition = elevatorPanel.getLocation().x - (double) 4 * OFFSET;
		yPosition = firstFloorButtonPanel.getLocation().y - (double) (10 * OFFSET);
		firstFloorLightPanel.setPosition(xPosition, yPosition);

		secondFloorLightPanel = new AnimatedPanel(1, secondFloorLightFrames);

		yPosition = secondFloorButtonPanel.getLocation().y - (double) (10 * OFFSET);
		secondFloorLightPanel.setPosition(xPosition, yPosition);

		doorPanel = new AnimatedPanel(0, doorFrames);
		int doorOpenedFrameOrder[] = { 0, 1, 2, 3, 4 };
		int doorClosedFrameOrder[] = { 4, 3, 2, 1, 0 };
		doorPanel.addFrameSequence(doorOpenedFrameOrder);
		doorPanel.addFrameSequence(doorClosedFrameOrder);

		yPosition = elevatorPanel.getHeight() - (double) doorPanel.getHeight();

		doorPanel.setPosition(0, yPosition);

		elevatorLightPanel = new AnimatedPanel(0, lightFrames);
		elevatorLightPanel.setPosition(OFFSET, (double) 5 * OFFSET);

		yPosition = elevatorLightPanel.getPosition().getY() + elevatorLightPanel.getHeight() + OFFSET;

		elevatorButtonPanel = new AnimatedPanel(0, elevatorButtonFrames);

		yPosition = elevatorPanel.getHeight() - (double) 6 * OFFSET;
		elevatorButtonPanel.setPosition(10 * (double) OFFSET, yPosition);

		int buttonPressedFrameOrder[] = { 0, 1, 2 };
		elevatorButtonPanel.addFrameSequence(buttonPressedFrameOrder);

		personAnimatedPanels = new ArrayList<>();

	}

	private void placePanelsOnView() {

		add(firstFloorPanel);
		add(secondFloorPanel);
		add(ceilingPanel);
		add(elevatorPanel);
		add(firstFloorButtonPanel);
		add(secondFloorButtonPanel);
		add(firstFloorLightPanel);
		add(secondFloorLightPanel);
		add(elevatorShaftPanel);
		add(wallPanel);

		elevatorPanel.add(doorPanel);
		elevatorPanel.add(elevatorLightPanel);
		elevatorPanel.add(elevatorButtonPanel);

	}

	public void startAnimation() {
		if (animationTimer == null) {
			animationTimer = new javax.swing.Timer(ANIMATION_DELAY, this);
			animationTimer.start();
		} else

		if (!animationTimer.isRunning())
			animationTimer.restart();
	}

	public void stopAnimation() {
		animationTimer.stop();
	}

	public void actionPerformed(ActionEvent actionEvent) {
		elevatorPanel.animate();

		firstFloorButtonPanel.animate();
		secondFloorButtonPanel.animate();

		Iterator<AnimatedPanel> iterator = getPersonAnimatedPanelsIterator();

		while (iterator.hasNext()) {

			AnimatedPanel personPanel = iterator.next();

			personPanel.animate();
		}

		repaint();

	}

	private Iterator<AnimatedPanel> getPersonAnimatedPanelsIterator() {

		synchronized (personAnimatedPanels) {
			return new ArrayList<AnimatedPanel>(personAnimatedPanels).iterator();
		}
	}

	private AnimatedPanel getPersonPanel(PersonMoveEvent event) {
		Iterator<AnimatedPanel> iterator = getPersonAnimatedPanelsIterator();

		while (iterator.hasNext()) {

			AnimatedPanel personPanel = iterator.next();

			if (personPanel.getID() == event.getID())
				return personPanel;
		}

		return null;

	}

	public void elevatorDeparted(ElevatorMoveEvent moveEvent) {
		String location = moveEvent.getLocation().getLocationName();

		Iterator<AnimatedPanel> iterator = getPersonAnimatedPanelsIterator();

		while (iterator.hasNext()) {

			AnimatedPanel personPanel = iterator.next();

			double yPosition = personPanel.getPosition().getY();
			String panelLocation;

			if (yPosition > secondFloorPosition)
				panelLocation = FIRST_FLOOR_NAME;
			else
				panelLocation = SECOND_FLOOR_NAME;

			int xPosition = (int) personPanel.getPosition().getX();

			if (panelLocation.equals(location) && xPosition > PERSON_TO_BUTTON_DISTANCE + OFFSET) {

				remove(personPanel);

				elevatorPanel.add(personPanel, 1);
				personPanel.setLocation(2 * OFFSET, 9 * OFFSET);
				personPanel.setMoving(false);
				personPanel.setAnimating(false);
				personPanel.setVelocity(0, 0);
				personPanel.setCurrentFrame(1);
			}
		}

		if (location.equals(FIRST_FLOOR_NAME))
			elevatorPanel.setVelocity(0, -elevatorVelocity);
		else

		if (location.equals(SECOND_FLOOR_NAME))
			elevatorPanel.setVelocity(0, elevatorVelocity);

		elevatorPanel.setMoving(true);

	}

	public void elevatorArrived(ElevatorMoveEvent moveEvent) {

		elevatorPanel.setMoving(false);

		double xPosition = elevatorPanel.getPosition().getX();
		double yPosition;

		if (elevatorPanel.getYVelocity() < 0)
			yPosition = secondFloorPosition - (double) elevatorPanel.getHeight();
		else
			yPosition = firstFloorPosition - (double) elevatorPanel.getHeight();

		elevatorPanel.setPosition(xPosition, yPosition);

	}

	public void personCreated(PersonMoveEvent personEvent) {
		int personID = personEvent.getID();

		String floorLocation = personEvent.getLocation().getLocationName();

		AnimatedPanel personPanel = new AnimatedPanel(personID, personFrames);

		double xPosition = -personPanel.getWidth();
		double yPosition = 0;

		if (floorLocation.equals(FIRST_FLOOR_NAME))
			yPosition = firstFloorPosition + ((double) firstFloorPanel.getHeight() / 2);
		else

		if (floorLocation.equals(SECOND_FLOOR_NAME))
			yPosition = secondFloorPosition + ((double) secondFloorPanel.getHeight() / 2);

		yPosition -= personPanel.getHeight();

		personPanel.setPosition(xPosition, yPosition);

		int walkFrameOrder[] = { 1, 0, 1, 2 };
		int pressButtonFrameOrder[] = { 1, 3, 3, 4, 4, 1 };
		int walkAwayFrameOrder[] = { 6, 5, 6, 7 };
		personPanel.addFrameSequence(walkFrameOrder);
		personPanel.addFrameSequence(pressButtonFrameOrder);
		personPanel.addFrameSequence(walkAwayFrameOrder);

		personPanel.playAnimation(0);
		personPanel.setLoop(true);
		personPanel.setAnimating(true);
		personPanel.setMoving(true);

		double time = ((double) TIME_TO_BUTTON / (double) ANIMATION_DELAY);

		double xDistance = PERSON_TO_BUTTON_DISTANCE - 2 * (double) OFFSET + (double) personPanel.getSize().width;
		double xVelocity = xDistance / time;

		personPanel.setVelocity(xVelocity, 0);
		personPanel.setAnimationRate(1);

		synchronized (personAnimatedPanels) {
			personAnimatedPanels.add(personPanel);
		}

		add(personPanel, 0);

	}

	public void personArrived(PersonMoveEvent personEvent) {

		AnimatedPanel panel = getPersonPanel(personEvent);

		if (panel != null) {

			panel.setMoving(false);
			panel.setAnimating(false);
			panel.setCurrentFrame(1);

			double xPosition = (double) PERSON_TO_BUTTON_DISTANCE - ((double) panel.getSize().width / 2);
			double yPosition = panel.getPosition().getY();

			panel.setPosition(xPosition, yPosition);
		}
	}

	public void personPressedButton(PersonMoveEvent personEvent) {

		AnimatedPanel panel = getPersonPanel(personEvent);

		if (panel != null) {

			panel.setLoop(false);
			panel.playAnimation(1);

			panel.setVelocity(0, 0);
			panel.setMoving(false);
			panel.setAnimating(true);
		}
	}

	public void personEntered(PersonMoveEvent personEvent) {

		AnimatedPanel panel = getPersonPanel(personEvent);

		if (panel != null) {

			double time = (double) TIME_TO_ELEVATOR / (double) ANIMATION_DELAY;

			double distance = elevatorPanel.getPosition().getX() - panel.getPosition().getX() + 2 * OFFSET;

			panel.setVelocity(distance / time, -1.5);

			panel.setMoving(true);
			panel.playAnimation(0);
			panel.setLoop(true);
		}
	}

	public void personDeparted(PersonMoveEvent personEvent) {

		AnimatedPanel panel = getPersonPanel(personEvent);

		if (panel != null) {

			double time = (double) TIME_TO_BUTTON / (double) ANIMATION_DELAY;
			double xVelocity = -PERSON_TO_BUTTON_DISTANCE / time;

			panel.setVelocity(xVelocity, 0);

			elevatorPanel.remove(panel);

			double xPosition = PERSON_TO_ELEVATOR_DISTANCE + (double) 3 * OFFSET;
			double yPosition = 0;

			String floorLocation = personEvent.getLocation().getLocationName();

			if (floorLocation.equals(FIRST_FLOOR_NAME))
				yPosition = firstFloorPosition + ((double) firstFloorPanel.getHeight() / 2);
			else

			if (floorLocation.equals(SECOND_FLOOR_NAME))
				yPosition = secondFloorPosition + ((double) secondFloorPanel.getHeight() / 2);

			yPosition -= panel.getHeight();

			panel.setPosition(xPosition, yPosition);

			add(panel, 0);

			panel.setMoving(true);
			panel.setAnimating(true);
			panel.playAnimation(2);
			panel.setLoop(true);
		}
	}

	public void personExited(PersonMoveEvent personEvent) {

		AnimatedPanel panel = getPersonPanel(personEvent);

		if (panel != null) {

			panel.setMoving(false);
			panel.setAnimating(false);

			synchronized (personAnimatedPanels) {
				personAnimatedPanels.remove(panel);
			}
			remove(panel);
		}
	}

	public void doorOpened(DoorEvent doorEvent) {

		doorEvent.getLocation().getLocationName();

		doorPanel.playAnimation(0);
		doorPanel.setAnimationRate(2);
		doorPanel.setDisplayLastFrame(true);

	}

	public void doorClosed(DoorEvent doorEvent) {

		doorEvent.getLocation().getLocationName();

		doorPanel.playAnimation(1);
		doorPanel.setAnimationRate(2);
		doorPanel.setDisplayLastFrame(true);

	}

	public void buttonPressed(ButtonEvent buttonEvent) {

		String location = buttonEvent.getLocation().getLocationName();

		if (location.equals(ELEVATOR_NAME)) {
			elevatorButtonPanel.playAnimation(0);
			elevatorButtonPanel.setDisplayLastFrame(true);
		}

		else

		if (location.equals(FIRST_FLOOR_NAME)) {
			firstFloorButtonPanel.playAnimation(0);
			firstFloorButtonPanel.setDisplayLastFrame(true);
		} else

		if (location.equals(SECOND_FLOOR_NAME)) {
			secondFloorButtonPanel.playAnimation(0);
			secondFloorButtonPanel.setDisplayLastFrame(true);
		}

	}

	public void buttonReset(ButtonEvent buttonEvent) {

		String location = buttonEvent.getLocation().getLocationName();

		if (location.equals(ELEVATOR_NAME)) {

			if (elevatorButtonPanel.isAnimating())
				elevatorButtonPanel.setDisplayLastFrame(false);
			else
				elevatorButtonPanel.setCurrentFrame(0);
		}

		else

		if (location.equals(FIRST_FLOOR_NAME)) {

			if (firstFloorButtonPanel.isAnimating())
				firstFloorButtonPanel.setDisplayLastFrame(false);
			else
				firstFloorButtonPanel.setCurrentFrame(0);
		} else

		if (location.equals(SECOND_FLOOR_NAME)) {

			if (secondFloorButtonPanel.isAnimating())
				secondFloorButtonPanel.setDisplayLastFrame(false);
			else
				secondFloorButtonPanel.setCurrentFrame(0);
		}

	}

	public void lightTurnedOn(LightEvent lightEvent) {

		elevatorLightPanel.setCurrentFrame(1);

		String location = lightEvent.getLocation().getLocationName();

		if (location.equals(FIRST_FLOOR_NAME))
			firstFloorLightPanel.setCurrentFrame(1);

		else

		if (location.equals(SECOND_FLOOR_NAME))
			secondFloorLightPanel.setCurrentFrame(1);

	}

	public void lightTurnedOff(LightEvent lightEvent) {

		elevatorLightPanel.setCurrentFrame(0);

		String location = lightEvent.getLocation().getLocationName();

		if (location.equals(FIRST_FLOOR_NAME))
			firstFloorLightPanel.setCurrentFrame(0);

		else

		if (location.equals(SECOND_FLOOR_NAME))
			secondFloorLightPanel.setCurrentFrame(0);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(VIEW_WIDTH, VIEW_HEIGHT);
	}

	@Override
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
}
