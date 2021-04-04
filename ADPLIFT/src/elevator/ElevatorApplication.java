package elevator;

import java.awt.*;

import javax.swing.*;

import elevator.controller.*;
import elevator.model.*;
import elevator.view.*;

public class ElevatorApplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ElevatorSimulation model;
	private ElevatorView view;
	private ElevatorController controller;

	public ElevatorApplication() {
		super("ADP LIFT ASSIGNMENT");

		model = new ElevatorSimulation();
		view = new ElevatorView();
		controller = new ElevatorController(model);

		model.setElevatorSimulationListener(view);

		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(controller, BorderLayout.SOUTH);

	}

	public static void main(String args[]) {

		ElevatorApplication caseStudy = new ElevatorApplication();
		caseStudy.setDefaultCloseOperation(EXIT_ON_CLOSE);
		caseStudy.pack();
		caseStudy.setVisible(true);
	}
}
