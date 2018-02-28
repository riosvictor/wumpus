package ws.agents;

/**
 * A grab action, that can be executed by an explorer in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Grab extends Action {

	/**
	 * Class constructor.
	 */
	public Grab() {
		super();
	}

	/**
	 * Returns a XML representation of this action.
	 *
	 * @return a XML representation of this action.
	 */
	public String toXml() {
		return "<grab>";
	}
}
