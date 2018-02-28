package ws.agents;

/**
 * A speak action, that can be executed by an agent in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Speak extends Action {

	/**
	 * The speech of the agent.
	 */
	private String speech;

	/**
	 * Class constructor.
	 *
	 * @param speech the speech of the agent.
	 */
	public Speak(String speech) {
		this.speech = speech;
	}

	/**
	 * Returns a XML representation of this action.
	 *
	 * @return a XML representation of this action.
	 */
	public String toXml() {
		return "<speak content=\"" + speech + "\">";
	}
}
