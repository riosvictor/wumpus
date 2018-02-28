package wm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.Panel;
import java.awt.Toolkit;

/**
 * Class that models a panel with an image inside.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class ImagePanel extends Panel implements ImageObserver {

	/**
	 * The image of this panel.
	 */
	private Image image;

	/**
	 * The name of the image file of this panel.
	 */
	private String imageFileName;

	/**
	 * Indicates that this panel should have a north border.
	 */
	public static final int NORTH = 0x01;

	/**
	 * Indicates that this panel should have a south border.
	 */
	public static final int SOUTH = 0x02;

	/**
	 * Indicates that this panel should have a west border.
	 */
	public static final int WEST = 0x04;

	/**
	 * Indicates that this panel should have an east border.
	 */
	public static final int EAST = 0x08;

	/**
	 * Indicates that this panel should have no borders.
	 */
	public static final int NONE = 0x08;

	/**
	 * The borders that must be drawn with this panel.
	 */
	private int borders;

	/**
	 * The name of the image of this panel.
	 */
	private String imageName;

	/**
	 * Class constructor
	 *
	 * @param borders the borders that must be drawn with this panel.
	 */
	public ImagePanel(int borders) {
		this(null, borders);
	}

	/**
	 * Class constructor
	 *
	 * @param imageName the name of the image file.
	 * @param borders the borders that must be drawn with this panel.
	 */
	public ImagePanel(String imageName, int borders) {
		setImage(imageName);
		this.borders = borders;
	}

	/**
	 * Returns the name of the image of this panel.
	 *
	 * @return the name of the image of this panel.
	 */
	public String getImageName() {
		return this.imageName;
	}

	/**
	 * Defines the name of the image of this panel.
	 *
	 * @param value the name of the image of this panel.
	 */
	public void setImageName(String value) {
		this.imageName = value;
		if (value == null) {
			this.image = null;
		}
	}

	/**
	 * Returns the name of the image file of this panel.
	 *
	 * @return the name of the image file of this panel.
	 */
	public String getImageFileName() {
		return this.imageFileName;
	}

	/**
	 * Sets the image of this panel.
	 *
	 * @param imageFileName the name of the file containing the image.
	 */
	public void setImage(String imageName) {
		if (imageName == null || imageName.equals("")) {
			image = null;
			this.imageFileName = null;
			this.imageName = null;
		} else {
			image = Toolkit.getDefaultToolkit().getImage(imageName);
			imageFileName = imageName;
		}
	}

	/**
	 * Auxiliar methos used to draw the borders of this panel.
	 *
	 * @param g a graphics context to be painted.
	 * @param size the size of this panel.
	 */
	private void drawBorders(Graphics g, Dimension size) {
		int top, left, bottom, right;
		top = 0;
		left = 0;
		bottom = size.height - 1;
		right = size.width - 1;
		if ((borders & NORTH) != 0) {
			top++;
		}
		if ((borders & SOUTH) != 0) {
			bottom--;
		}
		if ((borders & EAST) != 0) {
			right--;
		}
		if ((borders & WEST) != 0) {
			left++;
		}
		
		if ((borders & NORTH) != 0) {
			g.drawLine(left, top, right, top);
		}
		if ((borders & SOUTH) != 0) {
			g.drawLine(left, bottom, right, bottom);
		}
		if ((borders & EAST) != 0) {
			g.drawLine(right, top, right, bottom);
		}
		if ((borders & WEST) != 0) {
			g.drawLine(left, top, left, bottom);
		}
	}

	/**
	 * Paints this image panel, drawing the image.
	 *
	 * @param g a graphics context to be painted.
	 */
	public void paint(Graphics g) {
		Dimension size = getSize();
		drawBorders(g, size);
		if (image != null) {
			int imgWidth, imgHeight;
			imgWidth = image.getWidth(this);
			int x = 0, y = 0;
			if (imgWidth != -1) {
				imgHeight = image.getHeight(null);
				if (size.width > imgWidth) {
					x = (size.width - imgWidth) / 2;
				}
				if (size.height > imgHeight) {
					y = (size.height - imgHeight) / 2;
				}
			}
			g.drawImage(image, x, y, null);
		}
	}

	/**
	 * Callback method invoked when an image that was being loaded becomes
	 * available.
	 *
	 * @param img the image that was being loaded.
	 * @param infoflags the flags passed by the image.
	 * @param x ignored.
	 * @param y ignored.
	 * @param width ignored.
	 * @param height ignored.
	 */
	public boolean imageUpdate(Image img, int infoflags,
			int x, int y, int width, int height) {
		if ((infoflags & ImageObserver.ALLBITS) != 0) {
			repaint();
			return false;
		}
		return true;
	}
}