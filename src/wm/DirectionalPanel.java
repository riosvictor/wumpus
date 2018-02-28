package wm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.Panel;
import java.awt.Toolkit;
import ws.Constants;

/**
 * Class that models a panel with an image inside, and a direction
 * (up, left, down, right).
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class DirectionalPanel extends ImagePanel implements Constants {

	/**
	 * The direction of the element in this panel.
	 *
	 * @see ws.Constants#UP
	 * @see ws.Constants#LEFT
	 * @see ws.Constants#DOWN
	 * @see ws.Constants#RIGHT
	 */
	private int direction;

	/**
	 * Indicates whether the panel should be crossed or not. It's useful
	 * to indicate that some agent was killed.
	 */
	private boolean crossed = false;

	/**
	 * Class constructor
	 *
	 * @param direction the initial direction of the element.
	 */
	public DirectionalPanel(int direction) {
		super(ImagePanel.NONE);
		setDirection(direction);
	}

	/**
	 * Class constructor
	 *
	 * @param imageName the name of the image file.
	 * @param direction the initial direction of the element.
	 */
	public DirectionalPanel(String imageName, int direction) {
		super(imageName, ImagePanel.NONE);
		setDirection(direction);
	}

	/**
	 * Class constructor
	 *
	 * @param direction the initial direction of the element.
	 * @param borders the borders that must be drawn with this panel.
	 */
	public DirectionalPanel(int direction, int borders) {
		super(borders);
		setDirection(direction);
	}

	/**
	 * Class constructor
	 *
	 * @param imageName the name of the image file.
	 * @param direction the initial direction of the element.
	 * @param borders the borders that must be drawn with this panel.
	 */
	public DirectionalPanel(String imageName, int direction, int borders) {
		super(imageName, borders);
		setDirection(direction);
	}

	/**
	 * Defines the direction of this panel.
	 *
	 * @param direction the direction of the element.
	 * @see ws.Constants#UP
	 * @see ws.Constants#LEFT
	 * @see ws.Constants#DOWN
	 * @see ws.Constants#RIGHT
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Returns the direction of this panel.
	 *
	 * @return the direction of this panel.
	 * @see ws.Constants#UP
	 * @see ws.Constants#LEFT
	 * @see ws.Constants#DOWN
	 * @see ws.Constants#RIGHT
	 */
	public int getDirection() {
		return this.direction;
	}

	/**
	 * Defines whether the panel should be crossed or not.
	 *
	 * @param value <code>true</code> if this panel should be crossed out;
	 *          <code>false</code> otherwise.
	 */
	public void setCrossed(boolean value) {
		this.crossed = value;
	}

	/**
	 * Checks whether this panel is to be crossed or not.
	 *
	 * @return <code>true</code> if this panel is to be crossed out;
	 *          <code>false</code> otherwise.
	 */
	public boolean getCrossed() {
		return this.crossed;
	}

	/**
	 * Paints this image panel, drawing the image.
	 *
	 * @param g a graphics context to be painted.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d = getSize();
		int[] x = new int[7];
		int[] y = new int[7];
		if (crossed) {
			Color current = g.getColor();
			g.setColor(Color.red);
			x[0] = 3; y[0] = 3;
			x[1] = 5; y[1] = 3;
			x[2] = d.width - 1 - 3; y[2] = d.height - 1 - 5;
			x[3] = d.width - 1 - 3; y[3] = d.height - 1 - 3;
			x[4] = d.width - 1 - 5; y[4] = d.height - 1 - 3;
			x[5] = 3; y[5] = 5;
			g.fillPolygon(x, y, 6);
			y[0] = d.height - 1 - 3;
			y[1] = d.height - 1 - 3;
			y[2] = 5;
			y[3] = 3;
			y[4] = 3;
			y[5] = d.height - 1 - 5;
			g.fillPolygon(x, y, 6);
			g.setColor(current);
		}
		boolean toDraw = true;
		switch (direction) {
			case UP :
				x[0] = d.width / 2;
				y[0] = 5;
				x[1] = x[0] + 4;
				y[1] = y[0] + 4;
				x[2] = x[0] + 1;
				y[2] = y[0] + 4;
				x[3] = x[0] + 1;
				y[3] = y[0] + 8;
				x[4] = x[0] - 1;
				y[4] = y[0] + 8;
				x[5] = x[0] - 1;
				y[5] = y[0] + 4;
				x[6] = x[0] - 4;
				y[6] = y[0] + 4;
				break;
			case DOWN :
				x[0] = d.width / 2;
				y[0] = d.height - 5;
				x[1] = x[0] + 4;
				y[1] = y[0] - 4;
				x[2] = x[0] + 1;
				y[2] = y[0] - 4;
				x[3] = x[0] + 1;
				y[3] = y[0] - 8;
				x[4] = x[0] - 1;
				y[4] = y[0] - 8;
				x[5] = x[0] - 1;
				y[5] = y[0] - 4;
				x[6] = x[0] - 4;
				y[6] = y[0] - 4;
				break;
			case LEFT :
				x[0] = 5;
				y[0] = d.height / 2;
				x[1] = x[0] + 4;
				y[1] = y[0] - 4;
				x[2] = x[0] + 4;
				y[2] = y[0] - 1;
				x[3] = x[0] + 8;
				y[3] = y[0] - 1;
				x[4] = x[0] + 8;
				y[4] = y[0] + 1;
				x[5] = x[0] + 4;
				y[5] = y[0] + 1;
				x[6] = x[0] + 4;
				y[6] = y[0] + 4;
				break;
			case RIGHT :
				x[0] = d.width - 5;
				y[0] = d.height / 2;
				x[1] = x[0] - 4;
				y[1] = y[0] - 4;
				x[2] = x[0] - 4;
				y[2] = y[0] - 1;
				x[3] = x[0] - 8;
				y[3] = y[0] - 1;
				x[4] = x[0] - 8;
				y[4] = y[0] + 1;
				x[5] = x[0] - 4;
				y[5] = y[0] + 1;
				x[6] = x[0] - 4;
				y[6] = y[0] + 4;
				break;
			default:
				toDraw = false;
				break;
		}
		if (toDraw) {
			g.fillPolygon(x, y, 7);
		}
	}
}