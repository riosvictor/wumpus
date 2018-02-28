package ws.agents;

import java.io.IOException;
import ws.Constants;

/**
 * A framework for the development of explorers for the wumpus server.
 * This class (and its superclass) deals with the communication details,
 * and can be subclassed by actual implementation of explorers. Agents
 * that subclass this class should override the abstract method
 * messageReceived(TurnNotification).
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public abstract class BasicExplorer extends BasicAgent implements Constants {

	/**
	 * Creates a new explorer, given the host name and port of the wumpus
	 * server, as well as the local port for this agent.
	 *
	 * @param name the name of this agent.
	 * @param serverHost the name of the host of the wumpus server.
	 * @param serverPort the port number from which the wumpus server is
	 *          waiting for join requests.
	 * @param localPort the port this agent will listen for server messages.
	 * @exception IOException if the datagram socket can't be
	 *          created.
	 * @exception AgentCreationException if there is an error while
	 *          connecting to the wumpus server.
	 */
	public BasicExplorer(String name, String serverHost,
											int serverPort, int localPort)
							throws IOException, AgentCreationException {
		super(name, EXPLORER, serverHost, serverPort, localPort);
	}

}
