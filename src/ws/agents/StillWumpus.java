package ws.agents;

import java.io.IOException;

/**
 * A simple agent for the wumpus world game. It's a wumpus that doesn't
 * move.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class StillWumpus extends BasicWumpus {

	/**
	 * The set of actions this server will always return.
	 */
	private final Action[] actions = new Action[] { new Nop() };

	/**
	 * Creates a new Wumpus agent, which doesn't move, given the
	 * host name and port of the wumpus server.
	 *
	 * @param serverHost the name of the host of the wumpus server.
	 * @param serverPort the port number of the wumpus server.
	 * @param localPort the port this agent will listen for server messages.
	 * @exception IOException if the datagram socket can't be
	 *          created.
	 * @exception AgentCreationException if there is an error while
	 *          connecting to the wumpus server.
	 */
	public StillWumpus(String serverHost, int serverPort, int localPort)
								throws IOException, AgentCreationException {
		this("Wumpus", serverHost, serverPort, localPort);
	}

	/**
	 * Creates a new Wumpus agent, which doesn't move, given the
	 * agent's name, the host name and port of the wumpus server.
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
	public StillWumpus(String name, String serverHost, int serverPort,
				int localPort) throws IOException, AgentCreationException {
		super(name, serverHost, serverPort, localPort);
	}

	/*
	 * Callback method, invoked by the superclass.
	 *
	 * @param turn the turn notification for the agent, with the
	 *          perceptions it senses.
	 * @return the actions the agent wishes to execute. Always Nop.
	 */
	public Action[] messageReceived(TurnNotification turn) {
		System.out.print("Turn notification... end: ");
		System.out.println(turn.isTurnEnding());
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
			host = "c5c05";
		} else {
			host = args[0];
		}
		if (args.length < 2) {
			serverPort = 4445;
		} else {
			serverPort = Integer.parseInt(args[1]);
		}
		if (args.length < 3) {
			localPort = 2000;
		} else {
			localPort = Integer.parseInt(args[2]);
		}
		try {
			long l = Math.round(Math.random() * 10000);
			new StillWumpus("Wumpus" + l, host, serverPort, localPort);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}

}
