package wm;

import java.awt.*;

public class Teste {
	public static void main(String[] args) {
		Frame f = new Frame() {
			public void paint(Graphics g) {
				Dimension d = getSize();
				g.drawRect(0, 0, d.width - 1, d.height - 1);
			}
		};
		f.setSize(200, 200);
		f.setLayout(new GridLayout(2,2));
		ImagePanel img = new DirectionalPanel("stench.gif", ws.Constants.LEFT);
		ImagePanel img2 = new DirectionalPanel("explorer.gif", ws.Constants.UP);
		ImagePanel img3 = new DirectionalPanel("breeze.gif", ws.Constants.DOWN);
		f.add(img);
		f.add(img2);
		f.add(img3);
		f.add(img);
		f.show();
		System.out.println("Sleeping");
		try {Thread.sleep(10000);}catch(Exception e){}
		System.out.println("Changing image");
		img2.setImage("wumpus.gif");
		f.repaint();
		System.out.println("Changed");
	}
}