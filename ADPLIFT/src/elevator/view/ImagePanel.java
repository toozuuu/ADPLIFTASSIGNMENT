package elevator.view;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class ImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private Point2D.Double position;

	private ImageIcon imageIcon;

	private Set<ImagePanel> panelChildren;

	public ImagePanel(int identifier, String imageName) {
		super(null);
		setOpaque(false);

		id = identifier;

		position = new Point2D.Double(0, 0);
		setLocation(0, 0);

		imageIcon = new ImageIcon(getClass().getResource(imageName));

		Image image = imageIcon.getImage();
		setSize(image.getWidth(this), image.getHeight(this));

		panelChildren = new HashSet<>();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		imageIcon.paintIcon(this, g, 0, 0);
	}

	public void add(ImagePanel panel) {
		panelChildren.add(panel);
		super.add(panel);
	}

	public void add(ImagePanel panel, int index) {
		panelChildren.add(panel);
		super.add(panel, index);
	}

	public void remove(ImagePanel panel) {
		panelChildren.remove(panel);
		super.remove(panel);
	}

	public void setIcon(ImageIcon icon) {
		imageIcon = icon;
	}

	public void setPosition(double x, double y) {
		position.setLocation(x, y);
		setLocation((int) x, (int) y);
	}

	public int getID() {
		return id;
	}

	public Point2D.Double getPosition() {
		return position;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public Set<ImagePanel> getChildren() {
		return panelChildren;
	}
}
