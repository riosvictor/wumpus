package ws.agents;

/**
 * Exception thrown when there is an error while creating an agent that
 * is trying to connect itself to the wumpus server.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class AgentCreationException extends Exception {

	/**
	 * Creates a new agent creation exception, with no detail message.
	 */
	public AgentCreationException() {
		super();
	}

	/**
	 * Creates a new agent creation exception, with a message that further
	 * explains the error.
	 *
	 * @param msg the detail message.
	 */
	public AgentCreationException(String msg) {
		super(msg);
	}

}