package elevator.view;

import java.util.*;

import javax.swing.*;

public class AnimatedPanel extends MovingPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<int[]> frameSequences;
	private ImageIcon imageIcons[];

	private boolean animating;
	private int animationRate;
	private int animationRateCounter;

	private int currentAnimation;

	private boolean loop;

	private boolean displayLastFrame;

	private int currentFrameCounter;

	public AnimatedPanel(int identifier, String imageName[]) {
		super(identifier, imageName[0]);

		imageIcons = new ImageIcon[imageName.length];

		for (int i = 0; i < imageIcons.length; i++) {
			imageIcons[i] = new ImageIcon(getClass().getResource(imageName[i]));
		}

		frameSequences = new ArrayList<>();

	}

	@Override
	public void animate() {
		super.animate();

		if (frameSequences != null && isAnimating()) {

			if (animationRateCounter > animationRate) {
				animationRateCounter = 0;
				determineNextFrame();
			} else
				animationRateCounter++;
		}
	}

	private void determineNextFrame() {
		int frameSequence[] = frameSequences.get(currentAnimation);

		if (currentFrameCounter >= frameSequence.length) {
			currentFrameCounter = 0;

			if (!isLoop()) {

				setAnimating(false);

				if (isDisplayLastFrame())

					currentFrameCounter = frameSequence.length - 1;
			}
		}

		setCurrentFrame(frameSequence[currentFrameCounter]);
		currentFrameCounter++;

	}

	public void addFrameSequence(int frameSequence[]) {
		frameSequences.add(frameSequence);
	}

	public boolean isAnimating() {
		return animating;
	}

	public void setAnimating(boolean animate) {
		animating = animate;
	}

	public void setCurrentFrame(int frame) {
		setIcon(imageIcons[frame]);
	}

	public void setAnimationRate(int rate) {
		animationRate = rate;
	}

	public int getAnimationRate() {
		return animationRate;
	}

	public void setLoop(boolean loopAnimation) {
		loop = loopAnimation;
	}

	public boolean isLoop() {
		return loop;
	}

	private boolean isDisplayLastFrame() {
		return displayLastFrame;
	}

	public void setDisplayLastFrame(boolean displayFrame) {
		displayLastFrame = displayFrame;
	}

	public void playAnimation(int frameSequence) {
		currentAnimation = frameSequence;
		currentFrameCounter = 0;
		setAnimating(true);
	}
}
