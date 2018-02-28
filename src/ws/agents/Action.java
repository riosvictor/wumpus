package ws.agents;

/**
 * An action, that can be executed by an agent in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public abstract class Action {

	/**
	 * A null action.
	 */
	public static final Action NOP = new Nop();
	
	/**
	 * A turn left action.
	 */
	public static final Action TURN_LEFT = new Turn(true);

	/**
	 * A turn right action.
	 */
	public static final Action TURN_RIGHT = new Turn(false);

	/**
	 * A grab action.
	 */
	public static final Action GRAB = new Grab();

	/**
	 * A walk action.
	 */
	public static final Action WALK = new Walk();

	/**
	 * A shoot action.
	 */
	public static final Action SHOOT = new Shoot();

	/**
	 * A leave action.
	 */
	public static final Action LEAVE = new Leave();

	/**
	 * Returns a XML representation of this action.
	 *
	 * @return a XML representation of this action.
	 */
	public abstract String toXml();
}
