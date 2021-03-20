package Elevator;


import java.awt.BorderLayout;

import javax.swing.JFrame;

import Elevator.model.ElevatorSimulation;
import Elevator.view.ElevatorView;

public class ElevatorApplication  extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private ElevatorSimulation model;
	private ElevatorView view;

	public static void main(String[] args) {
		ElevatorApplication application = new ElevatorApplication();
		application.setDefaultCloseOperation(EXIT_ON_CLOSE);
		application.pack();
		application.setVisible(true);
	}
	
	public ElevatorApplication() {
		super("Java Elevator Simulation");

		model = new ElevatorSimulation();
		view = new ElevatorView();

	}

}
