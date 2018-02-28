package ws.agents;

/**
 * A turn action, that can be executed by an agent in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Turn extends Action {

	/**
	 * Constant used to indicate left direction
	 */
	public static final int LEFT = 0;

	/**
	 * Constant used to indicate right direction
	 */
	public static final int RIGHT = 1;

	/**
	 * The direction of the turn.
	 */
	private boolean turnLeft;

	/**
	 * Class constructor.
	 *
	 * @param direction the direction of the turn. Can be "left" or "right"
	 */
	public Turn(String direction) {
		this(direction.equalsIgnoreCase("left"));
	}

	/**
	 * Class constructor.
	 *
	 * @param direction the direction of the turn. Can be
	 *          <code>Turn.LEFT</code> or <code>Turn.RIGHT</code>.
	 */
	public Turn(int direction) {
		this(direction == LEFT);
	}

	/**
	 * Class constructor.
	 *
	 * @param left if the direction of the turn is left.
	 */
	public Turn(boolean left) {
		this.turnLeft = left;
	}

	/**
	 * Returns a XML representation of this action.
	 *
	 * @return a XML representation of this action.
	 */
	public String toXml() {
		if (turnLeft) {
			return "<turn direction=left>";
		} else {
			return "<turn direction=right>";
		}
	}
}
