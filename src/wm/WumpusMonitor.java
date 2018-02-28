package wm;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import ws.Agent;
import ws.Constants;
import ws.Explorer;
import ws.Room;
import ws.Wumpus;
import ws.WumpusWorld;

/**
 * A monitor for the wumpus server.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class WumpusMonitor extends UnicastRemoteObject
						implements WMInterface, Serializable, Constants {

	/**
	 * The frame used to present the game.
	 */
	private Frame frame;

	/**
	 * The image name for explorers.
	 */
	private static final String EXPLORER_FILE = "explorer.gif";

	/**
	 * The image name for wumpuses.
	 */
	private static final String WUMPUS_FILE = "wumpus.gif";

	/**
	 * The image name for pits.
	 */
	private static final String PIT_FILE = "pit.gif";

	/**
	 * The image name for breezes.
	 */
	private static final String BREEZE_FILE = "breeze.gif";

	/**
	 * The image name for golds.
	 */
	private static final String GOLD_FILE = "gold.gif";

	/**
	 * The image name for stenches.
	 */
	private static final String STENCH_FILE = "stench.gif";

	/**
	 * Indicates whether this monitor is enabled. It's enabled automatically
	 * when it receives the first call to <code>currentWorld</code> from the
	 * server.
	 */
	private boolean enabled = false;

	/**
	 * The room panels that show the world.
	 */
	private DirectionalPanel[][][] rooms;

	/**
	 * The width of the wumpus world.
	 */
	private int width;

	/**
	 * The height of the wumpus world.
	 */
	private int height;

	/**
	 * A map that takes the agent (names) to their positions.
	 */
	private Map agents;

	/**
	 * A map that takes the positions to the agents that are in it.
	 *
	 * @invariant agents.get(name) == p <=>
	 *          \exists a:Agent @ ((Set)agentPositions.get(p)).contains(a)
	 *                            && a.getName().equals(name)
	 */
	private Map agentPositions;

	/**
	 * Class constructor.
	 *
	 * @exception RemoteException if there is some problem in the
	 *          establishment of the communication.
	 */
	public WumpusMonitor() throws RemoteException {
		super();
		agents = new HashMap();
		agentPositions = new HashMap();
	}

	/**
	 * Returns the next empty spot in the given room.
	 *
	 * @param row the row of the room
	 * @param col the column of the room
	 * @return the next empty panel of the given room.
	 */
	private DirectionalPanel nextEmpty(int row, int col) {
		DirectionalPanel[] room = rooms[row][col];
		for (int i = 0; i < room.length; i++) {
			if (room[i].getImageName() == null) {
				return room[i];
			}
		}
		return null;
	}

	/**
	 * Checks if there is such a image in the given room.
	 *
	 * @param row the row of the room
	 * @param col the column of the room
	 * @param imageName the name of the image to be checked.
	 * @return <code>true</code> if there is a image with the given name
	 *          in the room; <code>false</code> otherwise.
	 */
	private boolean checkImage(int row, int col, String imageName) {
		DirectionalPanel[] room = rooms[row][col];
		for (int i = 0; i < room.length; i++) {
			String roomImageName = room[i].getImageName();
			if (roomImageName != null && roomImageName.equals(imageName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds an image to one of the rooms.
	 *
	 * @param row the row of the room
	 * @param col the column of the room
	 * @param imageName the name of the image to be added.
	 * @param imageFileName the name of the file containing the image.
	 */
	private void addImage(int row, int col, String imageName,
												String imageFileName) {
		DirectionalPanel panel = nextEmpty(row, col);
		if (panel != null) {
			panel.setImage(imageFileName);
			panel.setImageName(imageName);
			panel.invalidate();
			panel.repaint();
		}
	}

	/**
	 * Sets the direction of a directional panel.
	 *
	 * @param row the row of the room
	 * @param col the column of the room
	 * @param imageName the name of the image whose panel is to be modified.
	 * @param direction the new direction.
	 */
	private void setDirection(int row, int col, String imageName,
													int direction) {
		DirectionalPanel[] room = rooms[row][col];
		int index = -1;
		for (int i = 0; index == -1 && i < room.length; i++) {
			String roomImageName = room[i].getImageName();
			if (roomImageName != null && roomImageName.equals(imageName)) {
				index = i;
			}
		}
		if (index != -1) {
			room[index].setDirection(direction);
			room[index].invalidate();
			room[index].repaint();
		}
	}

	/**
	 * Removes an image from one of the rooms.
	 *
	 * @param row the row of the room
	 * @param col the column of the room
	 * @param imageName the name of the image to be removed.
	 */
	private void removeImage(int row, int col, String imageName) {
		DirectionalPanel[] room = rooms[row][col];
		int index = -1;
		for (int i = 0; index == -1 && i < room.length; i++) {
			String roomImageName = room[i].getImageName();
			if (roomImageName != null && roomImageName.equals(imageName)) {
				index = i;
			}
		}
		if (index != -1) {
			room[index].setImage(null);
			for (int i = index + 1; i < room.length; i++) {
				room[i - 1].setImage(room[i].getImageFileName());
				room[i - 1].setImageName(room[i].getImageName());
				room[i - 1].setDirection(room[i].getDirection());
				room[i - 1].setCrossed(room[i].getCrossed());
				room[i - 1].invalidate();
				room[i - 1].repaint();
				if (room[i].getImageName() == null) {
					break;
				}
			}
		}
	}

	/**
	 * Crosses out an image panel. Used to indicate that an agent was
	 * killed.
	 *
	 * @param row the row of the room
	 * @param col the column of the room
	 * @param imageName the name of the image whose panel is to be modified.
	 */
	private void setCrossed(int row, int col, String imageName) {
		DirectionalPanel[] room = rooms[row][col];
		int index = -1;
		for (int i = 0; index == -1 && i < room.length; i++) {
			String roomImageName = room[i].getImageName();
			if (roomImageName != null && roomImageName.equals(imageName)) {
				index = i;
			}
		}
		if (index != -1) {
			room[index].setCrossed(true);
			room[index].setImageName("__KILLED__");
			room[index].invalidate();
			room[index].repaint();
		}
	}

	/**
	 * Receives an update of the entire world. It will be invoked once
	 * in the beginning of the communication, and once in a while,
	 * to resynchronize in case of lost packages.
	 *
	 * @param world the world as is in the current state.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void currentWorld(WumpusWorld world) throws RemoteException {
		width = world.getWidth();
		height = world.getHeight();
		if (frame == null) {
			frame = new Frame();
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					frame.dispose();
					System.exit(0);
				}
			});
			frame.setTitle("The Wumpus Monitor");
			frame.setLayout(new GridLayout(width * 2, height * 2));
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setBounds(0, 0, d.width - 1, d.height - 1);
		} else {
			frame.removeAll();
		}
		rooms = new DirectionalPanel[width][height][8];
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				rooms[row][col][0] = new DirectionalPanel(-1,
										ImagePanel.NORTH | ImagePanel.WEST);
				rooms[row][col][1] = new DirectionalPanel(-1,
										ImagePanel.NORTH | ImagePanel.EAST);
				rooms[row][col][2] = new DirectionalPanel(-1,
										ImagePanel.SOUTH | ImagePanel.WEST);
				rooms[row][col][3] = new DirectionalPanel(-1,
										ImagePanel.SOUTH | ImagePanel.EAST);
				for (int k = 4; k < 8; k++) {
					rooms[row][col][k] = new DirectionalPanel(-1);
				}
				agentPositions.put(new Point(row, col), new HashSet());
			}
		}
		for (int row = 0; row < world.getWidth(); row++) {
			for (int turn = 0; turn < 2; turn++) {
				for (int col = 0; col < world.getHeight(); col++) {
					frame.add(rooms[height - row - 1][col][2*turn]);
					frame.add(rooms[height - row - 1][col][2*turn + 1]);
				}
			}
		}
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				Room room = world.getRoom(row, col);
				if (room.getPit()) {
					addImage(row, col, PIT_FILE, PIT_FILE);
				}
				if (room.getGold()) {
					addImage(row, col, GOLD_FILE, GOLD_FILE);
				}
				Wumpus w = room.getWumpus();
				if (w != null) {
					addImage(row, col, w.getName(), WUMPUS_FILE);
					setDirection(row, col, w.getName(), w.getDirection());
					Point pos = new Point(w.getRow(), w.getColumn());
					agents.put(w.getName(), pos);
					Set s = (Set) agentPositions.get(pos);
					s.add(w);
					checkStench(row + 1, col - 1, row - 1, col + 1);
				}
				Set explorers = room.getExplorers();
				for (Iterator it = explorers.iterator(); it.hasNext(); ) {
					Explorer e = (Explorer) it.next();
					addImage(row, col, e.getName(), EXPLORER_FILE);
					setDirection(row, col, e.getName(), e.getDirection());
					Point pos = new Point(e.getRow(), e.getColumn());
					agents.put(e.getName(), pos);
					Set s = (Set) agentPositions.get(pos);
					s.add(e);
				}
				boolean breeze = false;
				if (row > 0 && world.getRoom(row - 1, col).getPit()) {
					breeze = true;
				} else if (row < world.getWidth() - 1 &&
									world.getRoom(row + 1, col).getPit()) {
					breeze = true;
				} else if (col > 0 && world.getRoom(row, col - 1).getPit()) {
					breeze = true;
				} else if (col < world.getHeight() - 1 &&
									world.getRoom(row, col + 1).getPit()) {
					breeze = true;
				}
				if (breeze) {
					addImage(row, col, BREEZE_FILE, BREEZE_FILE);
				}
			}
		}
		frame.show();
		this.enabled = true;
	}

	/**
	 * Checks whether to show a stench image in some region of the world.
	 *
	 * @param top the top row
	 * @param left the left column
	 * @param bottom the bottom row
	 * @param right the right column
	 * @precondition (top >= bottom) && (right >= left)
	 */
	private void checkStench(int top, int left, int bottom, int right) {
		if (top > height - 1) {
			top = height - 1;
		}
		if (bottom < 0) {
			bottom = 0;
		}
		if (left < 0) {
			left = 0;
		}
		if (right > width - 1) {
			right = width - 1;
		}
		boolean stench = false;
		for (int i = bottom; i <= top; i++) {
			for (int j = left; j <= right; j++) {
				stench = false;
				if (i > 0) {
					Set s = (Set) agentPositions.get(new Point(i - 1, j));
					for (Iterator it = s.iterator(); it.hasNext(); ) {
						if (it.next() instanceof Wumpus) {
							stench = true;
						}
					}
				}
				if (i < width - 1) {
					Set s = (Set) agentPositions.get(new Point(i + 1, j));
					for (Iterator it = s.iterator(); it.hasNext(); ) {
						if (it.next() instanceof Wumpus) {
							stench = true;
						}
					}
				}
				if (j > 0) {
					Set s = (Set) agentPositions.get(new Point(i, j - 1));
					for (Iterator it = s.iterator(); it.hasNext(); ) {
						if (it.next() instanceof Wumpus) {
							stench = true;
						}
					}
				}
				if (j < height - 1) {
					Set s = (Set) agentPositions.get(new Point(i, j + 1));
					for (Iterator it = s.iterator(); it.hasNext(); ) {
						if (it.next() instanceof Wumpus) {
							stench = true;
						}
					}
				}
				if (stench) {
					if (!checkImage(i, j, STENCH_FILE)) {
						addImage(i, j, STENCH_FILE, STENCH_FILE);
					}
				} else {
					if (checkImage(i, j, STENCH_FILE)) {
						removeImage(i, j, STENCH_FILE);
					}
				}
			}
		}
	}

	/**
	 * Receives an indication that an agent has joined the game
	 *
	 * @param agent the agent that joined the game.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void join(Agent agent) throws RemoteException {
System.out.println("Em join: agent = " + agent.toXml());
		int row = agent.getRow();
		int col = agent.getColumn();
		Point pos = new Point(row, col);
		agents.put(agent.getName(), pos);
		Set s = (Set) agentPositions.get(pos);
		s.add(agent);
		String fileName;
		if (agent instanceof Explorer) {
			fileName = EXPLORER_FILE;
		} else {
			fileName = WUMPUS_FILE;
		}
		addImage(row, col, agent.getName(), fileName);
		setDirection(row, col, agent.getName(), agent.getDirection());
		if (agent instanceof Wumpus) {
			checkStench(row + 1, col - 1, row - 1, col + 1);
		}
	}

	/**
	 * Receives an indication that an agent has turned left.
	 *
	 * @param agent the agent that turned left.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void turnLeft(Agent agent) throws RemoteException {
		Object obj = agents.get(agent.getName());
		Point point = (Point) obj;
		if (agent.getRow() != point.x || agent.getColumn() != point.y) {
			System.out.println("Incompativeis!!!");
			return;
		}
		setDirection(agent.getRow(), agent.getColumn(), agent.getName(),
													agent.getDirection());
	}

	/**
	 * Receives an indication that an agent has turned right.
	 *
	 * @param agent the agent that turned right.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void turnRight(Agent agent) throws RemoteException {
		turnLeft(agent);  // The processing is the same.
	}

	/**
	 * Receives an indication that an agent has walked.
	 *
	 * @param agent the agent that walked.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void walk(Agent agent) throws RemoteException {
System.out.println("Em walk: agent = " + agent.toXml());
		int currRow = agent.getRow();
		int currCol = agent.getColumn();
		int oldRow = currRow;
		int oldCol = currCol;
		switch (agent.getDirection()) {
			case UP: oldRow--; break;
			case DOWN: oldRow++; break;
			case LEFT: oldCol++; break;
			case RIGHT: oldCol--; break;
		}
		String agentName = agent.getName();
		Object obj = agents.get(agentName);
		Point p = (Point) obj;
		if (oldRow != p.x || oldCol != p.y) {
			System.out.println("Incompativeis!!! ");
			return;
		}
		p.x = currRow;
		p.y = currCol;
		removeImage(oldRow, oldCol, agentName);
		if (agent instanceof Wumpus) {
			addImage(currRow, currCol, agentName, WUMPUS_FILE);
			checkStench(currRow + 1, currCol - 1, currRow - 1, currCol + 1);
		} else {
			addImage(currRow, currCol, agentName, EXPLORER_FILE);
		}
		setDirection(currRow, currCol, agentName, agent.getDirection());
	}

	/**
	 * Receives an indication that an agent has grabbed the gold.
	 *
	 * @param agent the agent that grabbed the gold.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void grab(Agent agent) throws RemoteException {
		removeImage(agent.getRow(), agent.getColumn(), GOLD_FILE);
	}

	/**
	 * Receives an indication that an agent has shot its arrow.
	 *
	 * @param agent the agent that shot.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void shoot(Agent agent) throws RemoteException {
	}

	/**
	 * Receives an indication that an agent has left the cave.
	 *
	 * @param agent the agent that left the cave.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void leave(Agent agent) throws RemoteException {
		Object obj = agents.get(agent.getName());
		Point point = (Point) obj;
		if (agent.getRow() != point.x || agent.getColumn() != point.y) {
			System.out.println("Incompativeis!!!");
			return;
		}
	}

	/**
	 * Receives an indication that an agent was killed. If the agent had
	 * the gold, then the gold should be available in the same room of the
	 * agent.
	 *
	 * @param agent the agent that was killed.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void killed(Agent agent) throws RemoteException {
		Object obj = agents.get(agent.getName());
		Point point = (Point) obj;
		if (agent.getRow() != point.x || agent.getColumn() != point.y) {
			System.out.println("Incompativeis!!!");
			return;
		}
		setCrossed(agent.getRow(), agent.getColumn(), agent.getName());
		if (agent instanceof Explorer && ((Explorer)agent).getHasGold()) {
			addImage(agent.getRow(), agent.getColumn(), GOLD_FILE, GOLD_FILE);
		}
	}

	/**
	 * Receives an indication that the game is over.
	 */
	public void gameOver() {
		frame.setTitle(frame.getTitle() + " - Game Over");
	}

	/**
	 * Entry point of this class. Launches the monitor and connects to
	 * the wumpus server.
	 *
	 * @param args command-line arguments.
	 */
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Wumpus Monitor V1.0.");
			System.out.println("Usage: java wm.WumpusMonitor <server host> <server port> <logical name> [<RMIRegistry port>]");
			System.exit(0);
		}
		Registry r;
		try {
			int registryPort=1099;
			String serverHost = args[0];
			int serverPort = Integer.parseInt(args[1]);
			String logicalName = args[2];
			String localHost = InetAddress.getLocalHost().getHostAddress();
			if(args.length == 4) {
				registryPort =Integer.parseInt(args[3]);
			}
			String url = "rmi://"+localHost+":"+Integer.toString(registryPort)+"/"+logicalName;
			WMInterface monitor = new WumpusMonitor();
			r=LocateRegistry.getRegistry(localHost,registryPort);
			r.rebind(logicalName,monitor);
			//Naming.rebind(url, monitor);
			DatagramSocket socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName(serverHost);
			String msg = "<monitorJoin url=\"" + url + "\">";
			byte[] message = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(message,
									message.length, address, serverPort);
			socket.send(packet);
			System.out.println("Waiting for the first message from server");
			while (!((WumpusMonitor)monitor).enabled) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
			System.out.println("Enjoy the Wumpus Monitor!");
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
}