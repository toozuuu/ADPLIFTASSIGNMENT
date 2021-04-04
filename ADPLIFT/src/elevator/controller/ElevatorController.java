package elevator.controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import elevator.ElevatorGlobalValues;
import elevator.event.*;
import elevator.model.*;

public class ElevatorController extends JPanel implements ElevatorGlobalValues {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton firstControllerButton;
	private JButton secondControllerButton;
	private JButton thridControllerButton;

	private ElevatorSimulation elevatorSimulation;

	public ElevatorController(ElevatorSimulation simulation) {

		elevatorSimulation = simulation;
		setBackground(Color.white);

		firstControllerButton = new JButton("Case 1");
		add(firstControllerButton);

		secondControllerButton = new JButton("Case 2");
		add(secondControllerButton);

		thridControllerButton = new JButton("Case 3");
		add(thridControllerButton);

		firstControllerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				elevatorSimulation.addPerson(FIRST_FLOOR_NAME);

				firstControllerButton.setEnabled(false);
			}
		});

		secondControllerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				elevatorSimulation.addPerson(SECOND_FLOOR_NAME);

				secondControllerButton.setEnabled(false);
			}
		});

		thridControllerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				elevatorSimulation.addPerson(FIRST_FLOOR_NAME);

				firstControllerButton.setEnabled(false);

				elevatorSimulation.addPerson(SECOND_FLOOR_NAME);

				secondControllerButton.setEnabled(false);
			}
		});

		elevatorSimulation.addPersonMoveListener(new PersonMoveListener() {

			public void personEntered(PersonMoveEvent event) {

				String location = event.getLocation().getLocationName();

				if (location.equals(FIRST_FLOOR_NAME)) {
					firstControllerButton.setEnabled(true);
				} else {
					secondControllerButton.setEnabled(true);
				}

			}

			@Override
			public void personCreated(PersonMoveEvent moveEvent) {
				// TODO Auto-generated method stub

			}

			@Override
			public void personArrived(PersonMoveEvent moveEvent) {
				// TODO Auto-generated method stub

			}

			@Override
			public void personDeparted(PersonMoveEvent moveEvent) {
				// TODO Auto-generated method stub

			}

			@Override
			public void personPressedButton(PersonMoveEvent moveEvent) {
				// TODO Auto-generated method stub

			}

			@Override
			public void personExited(PersonMoveEvent moveEvent) {
				// TODO Auto-generated method stub

			}
		});
	}
}
