package ws.agents;

import ws.Perceptions;

/**
 * Class that represents a turn notification from the wumpus server to an
 * agent. It can be the notification of the beginning of a turn, or the end
 * of a turn.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class TurnNotification {

	/**
	 * The set of perceptions the agent senses.
	 */
	private Perceptions perceptions;

	/**
	 * If it's an end turn notification, indicated the number of actions
	 * the wumpus server has accepted.
	 */
	private int numberOfActions;

	/**
	 * Flag indicating whether the turn is beginning or ending;
	 */
	private boolean turnEnding;

	/**
	 * Class constructor.
	 *
	 * @param perceptions the perceptions the agent senses in the start or
	 *          end of the turn.
	 * @param endTurn <code>true</code> if the turn is ending;
	 *          <code>false</code> if the turn is beginning.
	 * @param numActions the number of actions the wumpus server has
	 *          accepted.
	 */
	public TurnNotification(Perceptions perceptions, boolean endTurn, int numActions) {
		this.perceptions = perceptions;
		this.turnEnding = endTurn;
		this.numberOfActions = numActions;
	}

	/**
	 * Checks whether the turn is beginning.
	 *
	 * @return <code>true</code> if this turn notification corresponds to
	 *          the start of a turn; <code>false</code> otherwise.
	 */
	public boolean isTurnBeginning() {
		return !turnEnding;
	}

	/**
	 * Checks whether the turn is ending.
	 *
	 * @return <code>true</code> if this turn notification corresponds to
	 *          the end of a turn; <code>false</code> otherwise.
	 */
	public boolean isTurnEnding() {
		return turnEnding;
	}

	/**
	 * Defines whether the turn is ending.
	 *
	 * @param value <code>true</code> if this turn notification corresponds
	 *          to the end of a turn; <code>false</code> otherwise.
	 */
	public void setTurnEnding(boolean value) {
		turnEnding = value;
	}

	/**
	 * Returns the perceptions the agent senses in this turn.
	 *
	 * @return the perceptions the agent senses in this turn.
	 */
	public Perceptions getPerceptions() {
		return perceptions;
	}

	/**
	 * Returns the number of actions the server has accepted. It makes
	 * sense only when it's the end of the turn.
	 *
	 * @return the number of actions the server has accepted.
	 */
	public int getNumberOfActions() {
		return numberOfActions;
	}

	/**
	 * Defines the number of actions the server has accepted. It makes
	 * sense only when it's the end of the turn.
	 *
	 * @param actions the number of actions the server has accepted.
	 */
	public void setNumberOfActions(int actions) {
		numberOfActions = actions;
	}

}
