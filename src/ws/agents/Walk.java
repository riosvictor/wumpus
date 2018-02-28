package ws.agents;

/**
 * A walk action, that can be executed by an agent in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Walk extends Action {

	/**
	 * Class constructor.
	 */
	public Walk() {
		super();
	}

	/**
	 * Returns a XML representation of this action.
	 *
	 * @return a XML representation of this action.
	 */
	public String toXml() {
		return "<walk>";
	}
}
