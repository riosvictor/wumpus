package ws;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The world of wumpus, a monster that lives in a rectangular
 * cave, with several rooms. Some rooms contains a pit in which
 * any explorer that enters will fall to death. In a single room
 * there is a big treasure: a bar of gold that attracts several
 * explorers into the dangers of the cave.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class WumpusWorld implements Constants, Serializable {

	/**
	 * The width of this cave.
	 */
	private int width;
	
	/**
	 * The height of this cave.
	 */
	private int height;
	
	/**
	 * The rooms that make up this cave. The left-lower room is
	 * considered to be numbered (0,0).
	 */
	private Room[][] rooms;

	/**
	 * The agents that are in this world. It's actually a mapping from
	 * the agents to their positions in the world.
	 *
	 * @invariant \forall a : Agent | Point p = agents.get(a) @
	 *                                rooms[p.x][p.y].getExplorers().contains(a) ||
	 *                                rooms[p.x][p.y].getWumpus() == a.
	 * @invariant \forall a : Agent | Point p = agents.get(a) @
	 *                                p.x == a.getRow() && p.y == a.getColumn().
	 */
	private Map agents;

	/**
	 * Creates a new wumpus world, given its dimension.
	 *
	 * @param width the number of room columns.
	 * @param height the number of room rows.
	 */
	public WumpusWorld(int width, int height) {
		this(width, height, 0.2);
	}

	/**
	 * Creates a new wumpus world, given its dimension and the
	 * probability of the occurrence of a pit in each room.
	 *
	 * @param width the number of room columns.
	 * @param height the number of room rows.
	 * @param pitProbability the probability (between 0 and 1) of
	 *          the occurrence of a pit in each room.
	 * @exception IllegalArgumentException if the pit probability
	 *          is so high that there's no space left for the gold.
	 */
	public WumpusWorld(int width, int height, double pitProbability) {
		this.width = width;
		this.height = height;
		this.rooms = new Room[width][height];
		this.agents = new HashMap();
		List l = new ArrayList();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// I don't want a pit in any cell that is neighbor to the [0,0].
				if (Math.random() < pitProbability && ((i + j) > 1)) {
					rooms[i][j] = new Room(i, j, true);
				} else {
					rooms[i][j] = new Room(i, j, false);
					if ((i + j) > 1) {  // Let's not put the gold close to the exit...
						l.add(rooms[i][j]);
					}
				}
			}
		}
		Collections.shuffle(l); // to put the gold in a random position
		if (l.size() == 0) { // There are too many pits!
			throw new IllegalArgumentException("Pit probability too high!");
		}
		Room aux = (Room) l.get(0);
		aux.setGold(true);
	}

	/**
	 * Returns the width of this cave.
	 *
	 * @return the width of this cave.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of this cave.
	 *
	 * @return the height of this cave.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns a room from this world.
	 *
	 * @param row the row number
	 * @param col the column number
	 * @return the room located in [row,col].
	 */
	public Room getRoom(int row, int col) {
		return rooms[row][col];
	}

	/**
	 * Adds an agent to this world. An agent can be an explorer or a wumpus.
	 *
	 * @param agent the agent to be inserted into this world.
	 * @exception IllegalArgumentException if the agent can't be added to
	 *          the world, due to the restriction mentioned in the methods
	 *          <code>addExplorer</code> and <code>addWumpus</code>, or
	 *          because it's position lies outside the boundaries of this
	 *          world.
	 * @see #addExplorer
	 * @see #addWumpus
	 */
	public void addAgent(Agent agent) {
		if (agent instanceof Explorer) {
			addExplorer((Explorer) agent);
		} else if (agent instanceof Wumpus) {
			addWumpus((Wumpus) agent);
		}
	}

	/**
	 * Adds an explorer to this world. An explorer can only be added to an
	 * empty room, unless the room has only other explorers (i.e., no pits
	 * or wumpuses).
	 *
	 * @param explorer the explorer to be inserted into this world.
	 * @exception IllegalArgumentException if the explorer can't be added to
	 *          the world, due to the restriction mentioned above, or
	 *          because it's position lies outside the boundaries of this
	 *          world.
	 */
	public void addExplorer(Explorer explorer) {
		int row = explorer.getRow();
		int col = explorer.getColumn();
		if (row < 0 || row >= height || col < 0 || col >= width) {
			throw new IllegalArgumentException("Agent is outside this cave");
		}
		if (agents.get(explorer) != null) {
			throw new IllegalArgumentException("Agent is already in this cave");
		}
		Room room = getRoom(row,col);
		if (room.getWumpus() != null || room.getPit()) {
			throw new IllegalArgumentException("The room is not empty");
		}
		room.addExplorer(explorer);
		agents.put(explorer, new Point(row, col));
	}

	/**
	 * Adds a wumpus to this world. A wumpus can only be added to an empty
	 * room (i.e., no pits, explorers or other wumpuses).
	 *
	 * @param wumpus the wumpus to be inserted into this world.
	 * @exception IllegalArgumentException if the wumpus can't be added to
	 *          the world, due to the restriction mentioned above, or
	 *          because it's position lies outside the boundaries of this
	 *          world.
	 * @exception IllegalArgumentException if the given agent is already in
	 *          this cave.
	 */
	public void addWumpus(Wumpus wumpus) {
		int row = wumpus.getRow();
		int col = wumpus.getColumn();
		if (row < 0 || row >= height || col < 0 || col >= width) {
			throw new IllegalArgumentException("Agent is outside this cave");
		}
		if (agents.get(wumpus) != null) {
			throw new IllegalArgumentException("Agent is already in this cave");
		}
		Room room = getRoom(row,col);
		if (room.getWumpus() != null) {
			throw new IllegalArgumentException("The room is not empty");
		}
		if (room.getNumberOfExplorers() != 0) {
			throw new IllegalArgumentException("The room is not empty");
		}
		room.setWumpus(wumpus);
		agents.put(wumpus, new Point(row, col));
	}

	/**
	 * Removes an agent from this world.
	 *
	 * @param agent the agent to be removed.
	 * @exception IllegalArgumentException if the given agent is not in
	 *          this cave.
	 */
	public void removeAgent(Agent agent) {
		Point p = (Point) agents.get(agent);
		if (p == null) {
			throw new IllegalArgumentException("Agent is not in this cave");
		}
		Room room = getRoom(p.x, p.y);
		if (room.getWumpus() == agent) {
			room.setWumpus(null);
		} else { // The agent is an explorer
			room.removeExplorer((Explorer) agent);
		}
		agents.remove(agent);
	}

	/**
	 * Checks whether an agent can walk.
	 *
	 * @param a the agent.
	 * @exception BumpException if the agent can't walk (because there is a
	 *          wall in front of it).
	 * @exception IllegalArgumentException if the given agent doesn't belong
	 *          to this world.
	 */
	private void checkWalk(Agent a) throws BumpException {
		Point pos = (Point) agents.get(a);
		int row = pos.x;
		int col = pos.y;
		Room room = getRoom(row, col);
		if (pos == null) {
			throw new IllegalArgumentException("Illegal agent");
		}
		switch (a.getDirection()) {
			case UP :
				row++;
				break;
			case DOWN :
				row--;
				break;
			case LEFT :
				col--;
				break;
			case RIGHT :
				col++;
				break;
		}
System.out.println("Em checkWalk, row="+row+", col="+col+", height="+height+", width="+width);
		if (row < 0 || row >= height || col < 0 || col >= width) {
			throw new BumpException();
		}
		if (a instanceof Wumpus && getRoom(row, col).getWumpus() != null) {
			throw new BumpException();
		}
	}

	/**
	 * Makes an agent walk.
	 *
	 * @param agent the agent to walk.
	 * @exception IllegalArgumentException if the given agent doesn't
	 *          belong to this world.
	 * @exception BumpException if the agent hits a wall.
	 */
	public void walk(Agent agent) throws BumpException {
		checkWalk(agent);
		if (agent instanceof Explorer) {
			walkExplorer((Explorer) agent);
		} else if (agent instanceof Wumpus) {
			walkWumpus((Wumpus) agent);
		}
		Point p = (Point) agents.get(agent);
		p.x = agent.getRow();
		p.y = agent.getColumn();
	}

	/**
	 * Makes an explorer walk.
	 *
	 * @param explorer the explorer to walk.
	 * @exception IllegalArgumentException if the given explorer doesn't
	 *          belong to this world.
	 * @exception BumpException if the explorer hits a wall.
	 */
	public void walkExplorer(Explorer explorer) throws BumpException {
		Room room = getRoom(explorer.getRow(), explorer.getColumn());
		room.removeExplorer(explorer);
		explorer.walk();
		rooms[explorer.getRow()][explorer.getColumn()].addExplorer(explorer);
	}

	/**
	 * Makes a wumpus walk.
	 *
	 * @param wumpus the wumpus to walk.
	 * @exception IllegalArgumentException if the given wumpus doesn't
	 *          belong to this world.
	 * @exception BumpException if the wumpus hits a wall or a room
	 *          with another wumpus (they're too big to fit).
	 */
	public void walkWumpus(Wumpus wumpus) throws BumpException {
		Room room = getRoom(wumpus.getRow(), wumpus.getColumn());
		room.setWumpus(null);
		wumpus.walk();
		rooms[wumpus.getRow()][wumpus.getColumn()].setWumpus(wumpus);
	}

	/**
	 * Makes an agent turn left.
	 *
	 * @param agent the agent to turn left.
	 * @exception IllegalArgumentException if the given agent doesn't
	 *          belong to this world.
	 */
	public void turnLeft(Agent agent) {
		if (agents.get(agent) == null) {
			throw new IllegalArgumentException("Illegal agent");
		}
		agent.turnLeft();
	}

	/**
	 * Makes an agent turn right.
	 *
	 * @param agent the agent to turn right.
	 * @exception IllegalArgumentException if the given agent doesn't
	 *          belong to this world.
	 */
	public void turnRight(Agent agent) {
		if (agents.get(agent) == null) {
			throw new IllegalArgumentException("Illegal agent");
		}
		agent.turnRight();
	}

	/**
	 * Makes an explorer grab the gold that is in the same room as him.
	 *
	 * @param explorer the explorer to grab the gold.
	 * @exception IllegalArgumentException if the given agent doesn't
	 *          belong to this world.
	 * @exception NoGoldException if there is no gold in the room of the
	 *          agent.
	 */
	public void grab(Explorer explorer) throws NoGoldException {
		Point p = (Point) agents.get(explorer);
		if (p == null) {
			throw new IllegalArgumentException("Illegal agent");
		}
		int row = p.x;
		int col = p.y;
		Room room = getRoom(row, col);
System.out.println("room = " + room);
		if (room.getGold()) {
			explorer.setHasGold(true);
			room.setGold(false);
		} else {
			throw new NoGoldException();
		}
	}

	/**
	 * Makes an explorer shoots his arrow, assuming that the arrow reaches
	 * as far as the cave goes (or it hits an agent, killing it).
	 *
	 * @param explorer the explorer to shoot the arrow.
	 * @return the agent hit by the arrow, or <code>null</code> if none
	 *          was hit.
	 * @exception IllegalArgumentException if the given agent doesn't
	 *          belong to this world.
	 * @exception NoArrowException if the explorer doesn't have an arrow
	 *          to shoot.
	 */
	public Agent shoot(Explorer explorer) throws NoArrowException {
		return shoot(explorer, 1000);
	}

	/**
	 * Makes an explorer shoots his arrow.
	 *
	 * @param explorer the explorer to shoot the arrow.
	 * @param arrowReach the number of rooms the arrow can travel, before
	 *          losing its speed and falling down.
	 * @return the agent hit by the arrow, or <code>null</code> if none
	 *          was hit.
	 * @exception IllegalArgumentException if the given agent doesn't
	 *          belong to this world.
	 * @exception NoArrowException if the explorer doesn't have an arrow
	 *          to shoot.
	 */
	public Agent shoot(Explorer explorer, int arrowReach) throws NoArrowException {
		Point p = (Point) agents.get(explorer);
		if (p == null) {
			throw new IllegalArgumentException("Illegal agent");
		}
		int row = p.x;
		int col = p.y;
		Agent result = null;
		Room room;
		explorer.shoot();
		while (arrowReach > 0 && result == null && row < height && col < width) {
			switch (explorer.getDirection()) {
				case UP :
					row++;
					break;
				case LEFT :
					col--;
					break;
				case DOWN :
					row--;
					break;
				case RIGHT :
					col++;
					break;
			}
			arrowReach--;
			if (row < height && col < width) {
				room = getRoom(row, col);
				if (room.getWumpus() != null) {
					result = room.getWumpus();
				} else {
					Iterator i = room.getExplorers().iterator();
					if (i.hasNext()) {
						result = (Agent) i.next();
					}
				}
			}
		}
		return result;
	}

	/**
	 * Makes an explorer leave the cave, if he is in its entry room.
	 *
	 * @param explorer the explorer to leave the cave.
	 * @exception IllegalArgumentException if the given agent doesn't
	 *          belong to this world.
	 * @exception IllegalArgumentException if the explorer isn't in the
	 *          entry room of the world.
	 */
	public void leave(Explorer explorer) throws IllegalArgumentException {
		Point p = (Point) agents.get(explorer);
		if (p == null) {
			throw new IllegalArgumentException("Illegal agent");
		}
		if (p.x != 0 || p.y != 0) {
			throw new IllegalArgumentException("Agent can't leave from the current room.");
		}
		removeAgent(explorer);
	}

	/**
	 * Return a set of perceptions that would be sent to an
	 * agent if it was in the given room.
	 *
	 * @param row the row of the room.
	 * @param col the column of the room.
	 * @param bump if the agent has hit something it can't trespass.
	 * @param wumpusScream if there is a wumpus scream in the world.
	 * @param explorerScream if there is an explorer scream in the world.
	 * @return the set of perceptions for that room.
	 */
	public Perceptions getPerceptions(int row, int col, boolean bump,
				boolean wumpusScream, boolean explorerScream) {
		int percep = 0;
		if (bump) {
			percep |= WALL;
		}
		if (wumpusScream) {
			percep |= WUMPUS_SCREAM;
		}
		if (explorerScream) {
			percep |= EXPLORER_SCREAM;
		}
		if (rooms[row][col].getGold()) {
			percep |= GLITTER;
		}
		if (row > 0) {
			if (rooms[row-1][col].getPit()) {
				percep |= BREEZE;
			}
			if (rooms[row-1][col].getWumpus() != null) {
				percep |= STENCH;
			}
			if (rooms[row-1][col].getNumberOfExplorers() != 0) {
				percep |= PARFUM;
			}
		}
		if (row < height - 1) {
			if (rooms[row+1][col].getPit()) {
				percep |= BREEZE;
			}
			if (rooms[row+1][col].getWumpus() != null) {
				percep |= STENCH;
			}
			if (rooms[row+1][col].getNumberOfExplorers() != 0) {
				percep |= PARFUM;
			}
		}
		if (col > 0) {
			if (rooms[row][col-1].getPit()) {
				percep |= BREEZE;
			}
			if (rooms[row][col-1].getWumpus() != null) {
				percep |= STENCH;
			}
			if (rooms[row][col-1].getNumberOfExplorers() != 0) {
				percep |= PARFUM;
			}
		}
		if (col < width - 1) {
			if (rooms[row][col+1].getPit()) {
				percep |= BREEZE;
			}
			if (rooms[row][col+1].getWumpus() != null) {
				percep |= STENCH;
			}
			if (rooms[row][col+1].getNumberOfExplorers() != 0) {
				percep |= PARFUM;
			}
		}
		return new Perceptions(percep);
	}

	/**
	 * Creates a new agent to be inserted into this world. It's guaranteed
	 * that the agent will be safe at least in the first round. The wumpuses
	 * will be randomly placed in the world; the explorers, as of this version,
	 * will always start at room [0,0], facing right, if it's safe.
	 *
	 * @param name the agent's name
	 * @param kind the agent's kind. See the constants defined in Constants.java to
	 *          obtain a list of possible values.
	 * @exception NoSpaceException when there's no safe room where the agent can be
	 *          created.
	 * @see Constants#EXPLORER
	 * @see Constants#WUMPUS
	 */
	public Agent createAgent(String name, int kind) throws NoSpaceException {
		int row = 1, col, direction;
		Agent result;
		if (kind == EXPLORER) {
			Perceptions p = getPerceptions(0, 0, false, false, false);
			if (p.getStench() || getRoom(0,0).getWumpus() != null) {
				throw new NoSpaceException();
			} else {
				row = 0;
				col = 0;
				direction = RIGHT;
				result = new Explorer(name, row, col, direction);
			}
		} else {
			List possibleSpots = new ArrayList();
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if ((i + j) > 1) {
						Room r = getRoom(i,j);
						if (r.getWumpus() == null && r.getNumberOfExplorers() == 0) {
							Perceptions p = getPerceptions(i, j, false, false, false);
							if (!p.getParfum()) {
								possibleSpots.add(r);
							}
						}
					}
				}
			}
			if (possibleSpots.size() == 0) {
				throw new NoSpaceException();
			} else {
				Collections.shuffle(possibleSpots);
				Room r = (Room) possibleSpots.get(0);
				int i = (int) Math.random() * 4;
				switch (i) {
					case 0 : direction = UP; break;
					case 1 : direction = LEFT; break;
					case 2 : direction = DOWN; break;
					default: direction = RIGHT; break;
				}
				result = new Wumpus(name, r.getRow(), r.getColumn(), direction);
			}
		}
		return result;
	}

	/**
	 * Returns a XML representation of this world.
	 *
	 * @return a XML representation of this world.
	 */
	public String toXml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<WumpusWorld width=");
		sb.append(width);
		sb.append(" height=");
		sb.append(height);
		sb.append(" >");
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Room room = getRoom(i, j);
				if (room.getPit()) {
					sb.append("<Pit row=");
					sb.append(i);
					sb.append(" column=");
					sb.append(j);
					sb.append(" />");
				}
				if (room.getGold()) {
					sb.append("<Gold row=");
					sb.append(i);
					sb.append(" column=");
					sb.append(j);
					sb.append(" />");
				}
				Wumpus w = room.getWumpus();
				if (w != null) {
					sb.append(w.toXml());
				}
				Set explorers = room.getExplorers();
				for (Iterator it = explorers.iterator(); it.hasNext(); ) {
					Explorer e = (Explorer) it.next();
					sb.append(e.toXml());
				}
			}
		}
		sb.append("</WumpusWorld>");
		return sb.toString();
	}

	/**
	 * Auxiliary method used to create an instance of a Wumpus World from
	 * a XML string.
	 *
	 * @param xml the XML string representing a Wumpus World
	 * @return the WumpusWorld represented by the given XML string.
	 */
	public static WumpusWorld fromXml(String xml) {
		String[] tags = Tag.breakTags(xml);
		int width = 10, height = 10;
		int row = 0, col = 0;
		Tag t = new Tag(tags[0]);
		String[] names = t.getAttribNames();
		String[] values = t.getAttribValues();
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("width")) {
				width = Integer.parseInt(values[i]);
			} else if (names[i].equals("height")) {
				height = Integer.parseInt(values[i]);
			}
		}
		WumpusWorld result = new WumpusWorld(width, height);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				result.rooms[i][j] = new Room(i, j, false);
			}
		}
		for (int i = 1; i < tags.length; i++) {
			t = new Tag(tags[i]);
			if (t.getName().equals("WumpusWorld") && t.isFinalizer()) {
				break;
			} else if (t.getName().equals("Pit")) {
				for (int j = 0; j < names.length; j++) {
					if (names[j].equals("row")) {
						row = Integer.parseInt(values[j]);
					} else if (names[j].equals("column")) {
						col = Integer.parseInt(values[j]);
					}
				}
				result.rooms[row][col] = new Room(row, col, true);
			} else if (t.getName().equals("Gold")) {
				for (int j = 0; j < names.length; j++) {
					if (names[j].equals("row")) {
						row = Integer.parseInt(values[j]);
					} else if (names[j].equals("column")) {
						col = Integer.parseInt(values[j]);
					}
				}
				result.rooms[row][col].setGold(true);
			} else if (t.getName().equals("Wumpus")) {
				Wumpus w = Wumpus.fromXml(tags[i]);
				result.addAgent(w);
			} else if (t.getName().equals("Explorer")) {
				Explorer e = Explorer.fromXml(tags[i]);
				result.addAgent(e);
			}
		}
		return result;
	}
	
}