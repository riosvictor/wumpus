package ws;

import java.io.Serializable;

/**
 * The wumpus server's model of an agent - an explorer of a
 * wumpus - in the wumpus' world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public abstract class Agent implements Constants, Serializable {

	/**
	 * The name of this agent.
	 */
	private String name;

	/**
	 * The row of the cave in which this agent is in.
	 * The left-lower room is considered to be numbered (0,0).
	 */
	private int row;
	
	/**
	 * The column of the cave in which this agent is in.
	 * The left-lower room is considered to be numbered (0,0).
	 */
	private int column;
	
	/**
	 * The direction of the agent.
	 *
	 * @see Constants#UP
	 * @see Constants#LEFT
	 * @see Constants#DOWN
	 * @see Constants#RIGHT
	 */
	private int direction;

	/**
	 * Flag indicating whether this agent is alive. It's initially true,
	 * and can be set to false once (by the method kill()).
	 */
	private boolean alive = true;

	/**
	 * Creates a new agent, given its name, original position and
	 * direction.
	 *
	 * @param name the name of this agent.
	 * @param row the row of the cave this agent will
	 *          start.
	 * @param column the column of the cave this agent will
	 *          start.
	 * @param direction the initial direction of this agent.
	 * @see Constants#UP
	 * @see Constants#LEFT
	 * @see Constants#DOWN
	 * @see Constants#RIGHT
	 */
	public Agent(String name, int row, int column, int direction) {
		this.name = name;
		this.row = row;
		this.column = column;
		this.direction = direction;
	}
	
	/**
	 * Returns the name of this agent.
	 *
	 * @return the name of this agent.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the row of this agent.
	 *
	 * @return the row of this agent.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Returns the column of this agent.
	 *
	 * @return the column of this agent.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Returns the direction of this agent.
	 *
	 * @return the direction of this agent.
	 * @see Constants#UP
	 * @see Constants#LEFT
	 * @see Constants#DOWN
	 * @see Constants#RIGHT
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Turns left.
	 */
	public void turnLeft() {
		switch (direction) {
			case UP: direction = LEFT; break;
			case LEFT: direction = DOWN; break;
			case DOWN: direction = RIGHT; break;
			case RIGHT: direction = UP; break;
		}
	}

	/**
	 * Turns right.
	 */
	public void turnRight() {
		switch (direction) {
			case UP: direction = RIGHT; break;
			case LEFT: direction = UP; break;
			case DOWN: direction = LEFT; break;
			case RIGHT: direction = DOWN; break;
		}
	}
	
	/**
	 * Walks to the next room.
	 */
	public void walk() {
		switch (direction) {
			case UP: row++; break;
			case LEFT: column--; break;
			case DOWN: row--; break;
			case RIGHT: column++; break;
		}
	}
	
	/**
	 * Checks whether this agent is equal to the given object.
	 *
	 * @return <code>true</code> if the given object is an agent
	 *          with the same name of this object; <code>false</code>
	 *          otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Agent) {
			Agent temp = (Agent) obj;
			return getName().equals(temp.getName());
		}
		return false;
	}
	
	/**
	 * Returns a hash code for this object.
	 *
	 * @return a hash code for this object.
	 */
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Kills this agent.
	 */
	public void kill() {
		this.alive = false;
	}
	
	/**
	 * Checks whether this agent is alive.
	 *
	 * @return <code>true</code> if this agent is alive; <code>false</code>
	 *          otherwise.
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Returns a XML representation of this agent.
	 *
	 * @return a XML representation of this agent.
	 */
	public abstract String toXml();

}