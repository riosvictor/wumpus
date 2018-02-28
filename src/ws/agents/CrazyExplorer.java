package ws.agents;

import java.io.IOException;

/**
 * A simple agent for the wumpus world game. It's an explorer that moves
 * randomly.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class CrazyExplorer extends BasicExplorer {

	/**
	 * The set of actions this server will always return.
	 */
	private Action[] actions = new Action[1];

	/**
	 * Creates a new CrazyExplorer agent, given the host name and port of
	 * the wumpus server, as well as the local port for this agent.
	 *
	 * @param serverHost the name of the host of the wumpus server.
	 * @param serverPort the port number of the wumpus server.
	 * @param localPort the port this agent will listen for server messages.
	 * @exception IOException if the datagram socket can't be
	 *          created.
	 * @exception AgentCreationException if there is an error while
	 *          connecting to the wumpus server.
	 */
	public CrazyExplorer(String serverHost, int serverPort, int localPort)
								throws IOException, AgentCreationException {
		this("Wumpus", serverHost, serverPort, localPort);
	}

	/**
	 * Creates a new CrazyExplorer agent, given the agent's name, the
	 * host name and port of the wumpus server, and the local port for
	 * this agent.
	 *
	 * @param name the name of this agent.
	 * @param serverHost the name of the host of the wumpus server.
	 * @param serverPort the port number of the wumpus server.
	 * @param localPort the port this agent will listen for server messages.
	 * @exception IOException if the datagram socket can't be
	 *          created.
	 * @exception AgentCreationException if there is an error while
	 *          connecting to the wumpus server.
	 */
	public CrazyExplorer(String name, String serverHost, int serverPort,
				int localPort) throws IOException, AgentCreationException {
		super(name, serverHost, serverPort, localPort);
	}

	/*
	 * Callback method, invoked by the superclass.
	 *
	 * @param turn the turn notification for the agent, with the
	 *          perceptions it senses.
	 * @return the actions the agent wishes to execute..
	 */
	public Action[] messageReceived(TurnNotification turn) {
		if (turn.isTurnEnding()) {
			actions[0] = Action.NOP;
		} else {
			int rand = (int) (Math.random() * 8);
			switch (rand) {
				case 0:
				case 1:
				case 2: actions[0] = Action.WALK; break;
				case 3:
				case 4: actions[0] = Action.TURN_LEFT; break;
				case 5:
				case 6: actions[0] = Action.TURN_RIGHT; break;
				case 7: actions[0] = Action.GRAB; break;
				default:actions[0] = Action.NOP; break;
			}
		}
		return actions;
	}
	
	/**
	 * Method called to say that this agent was killed.
	 */
	public void killed() {
		System.out.println("Goodbye!");
	}

	/**
	 * Test method of this class.
	 *
	 * @param args command-line arguments. The user must enter the
	 *          host name and port number of the server.
	 */
	public static void main(String[] args) {
		int serverPort, localPort;
		String host;
		if (args.length == 0) {
			host = "paulista.di.ufpe.br";
		} else {
			host = args[0];
		}
		if (args.length < 2) {
			serverPort = 4445;
		} else {
			serverPort = Integer.parseInt(args[1]);
		}
		if (args.length < 3) {
			localPort = 2001;
		} else {
			localPort = Integer.parseInt(args[2]);
		}
		try {
			long l = Math.round(Math.random() * 10000);
			new CrazyExplorer("Crazy Explorer " + l, host, serverPort, localPort);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}

}
