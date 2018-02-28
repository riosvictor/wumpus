package ws;

import java.util.Vector;

/**
 * Constants used in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public interface Constants {

	/**
	 * The "up" direction.
	 */
	public static final int UP = 0;

	/**
	 * The "left" direction.
	 */
	public static final int LEFT = 1;

	/**
	 * The "down" direction.
	 */
	public static final int DOWN = 2;

	/**
	 * The "right" direction.
	 */
	public static final int RIGHT = 3;

	/**
	 * A breeze perception.
	 */
	public static final int BREEZE = 0x0001;

	/**
	 * A stench perception.
	 */
	public static final int STENCH = 0x0002;

	/**
	 * A parfum perception.
	 */
	public static final int PARFUM = 0x0004;

	/**
	 * A wall perception.
	 */
	public static final int WALL = 0x0008;

	/**
	 * A wumpus scream perception.
	 */
	public static final int WUMPUS_SCREAM = 0x0010;

	/**
	 * An explorer scream perception.
	 */
	public static final int EXPLORER_SCREAM = 0x0020;

	/**
	 * A glitter perception.
	 */
	public static final int GLITTER = 0x0040;

	/**
	 * An explorer.
	 */
	public static final int EXPLORER = 0x0080;
	
	/**
	 * A wumpus.
	 */
	public static final int WUMPUS = 0x0100;
}