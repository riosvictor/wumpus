package ws.agents;

/**
 * A leave action, that can be executed by an agent in the wumpus world when it's
 * in the entry point of the cave.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Leave extends Action {

	/**
	 * Class constructor.
	 */
	public Leave() {
		super();
	}

	/**
	 * Returns a XML representation of this action.
	 *
	 * @return a XML representation of this action.
	 */
	public String toXml() {
		return "<leave>";
	}
}
