package ws.agents;

/**
 * A null action, that can be executed by an agent in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Nop extends Action {

	/**
	 * Class constructor.
	 */
	public Nop() {
		super();
	}

	/**
	 * Returns a XML representation of this action.
	 *
	 * @return a XML representation of this action.
	 */
	public String toXml() {
		return "<nop>";
	}
}
