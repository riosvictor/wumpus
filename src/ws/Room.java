package ws;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A room in the cave of the wumpus' world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Room implements Serializable {

	/**
	 * The row of this room.
	 */
	private int row;
	
	/**
	 * The column of this room.
	 */
	private int column;

	/**
	 * Flag that indicates whether a pit exists in this room.
	 */
	private boolean pit;

	/**
	 * Flag that indicates whether a bar of gold exists in this room.
	 */
	private boolean gold;

	/**
	 * The wumpus (if any) that is in this room.
	 */
	private Wumpus wumpus;

	/**
	 * The explorers that are in this room.
	 */
	private Set explorers;

	/**
	 * Creates a new room.
	 *
	 * @param row the row of this room.
	 * @param col the column of thsi room.
	 * @param pit <code>true</code> if this room has a pit;
	 *          <code>false</code> otherwise.
	 */
	public Room(int row, int col, boolean pit) {
		this.row = row;
		this.column = col;
		this.pit = pit;
		this.explorers = new HashSet();
		this.wumpus = null;
		this.gold = false;
	}

	/**
	 * Returns the row of this room.
	 *
	 * @return the row of this room.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Returns the column of this room.
	 *
	 * @return the column of this room.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Checks whether this room has a pit.
	 *
	 * @return <code>true</code> if this room has a pit;
	 *          <code>false</code> otherwise.
	 */
	public boolean getPit() {
		return pit;
	}

	/**
	 * Checks whether this room has a bar of gold.
	 *
	 * @return <code>true</code> if there is gold in this room;
	 *          <code>false</code> otherwise.
	 */
	public boolean getGold() {
		return gold;
	}

	/**
	 * Defines whether this room has a bar of gold.
	 *
	 * @param value <code>true</code> if there is gold in this room;
	 *          <code>false</code> otherwise.
	 */
	public void setGold(boolean value) {
		this.gold = value;
	}

	/**
	 * Sets the wumpus of this cave.
	 *
	 * @param w the new wumpus of this cave.
	 */
	public void setWumpus(Wumpus w) {
		this.wumpus = w;
	}

	/**
	 * Gets the wumpus of this cave.
	 *
	 * @return the wumpus of this cave.
	 */
	public Wumpus getWumpus() {
		return wumpus;
	}

	/**
	 * Adds an explorer to this room.
	 *
	 * @param e the explorer to be added.
	 */
	public void addExplorer(Explorer e) {
		if (!explorers.contains(e)) {
			explorers.add(e);
		}
	}

	/**
	 * Remove an explorer of this room.
	 *
	 * @param e the explorer to be removed.
	 */
	public void removeExplorer(Explorer e) {
		if (explorers.contains(e)) {
			explorers.remove(e);
		}
	}
	
	/**
	 * Returns the explorers in this room.
	 *
	 * @return the set of explorers in this room.
	 */
	public Set getExplorers() {
		return Collections.unmodifiableSet(explorers);
	}
	
	/**
	 * Returns the number of explorers in this room.
	 *
	 * @return the number of explorers in this room.
	 */
	public int getNumberOfExplorers() {
		return explorers.size();
	}

	/**
	 * Returns a string representation of this object. Useful for debugging.
	 *
	 * @return a string representation of this object.
	 */
	public String toString() {
		return ("Room[("+row+","+column+"),pit="+pit+",gold="+gold+"]");
	}

}