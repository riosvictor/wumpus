package ws.agents;

import java.io.IOException;

public class ShootExplorer extends BasicExplorer {

	private Action[] actions = new Action[1];
	private boolean first = true;
	public ShootExplorer(String name, String serverHost, int serverPort,
				int localPort) throws IOException, AgentCreationException {
		super(name, serverHost, serverPort, localPort);
	}

	public Action[] messageReceived(TurnNotification turn) {
		if (turn.isTurnEnding()) {
			actions[0] = Action.NOP;
		} else {
			if (first) {
				actions[0] = Action.SHOOT;
				first = false;
			} else {
				actions[0] = Action.WALK;
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

	public static void main(String[] args) {
		int serverPort, localPort;
		String host;
		if (args.length == 0) {
			host = "c5c05.di.ufpe.br";
		} else {
			host = args[0];
		}
		if (args.length < 2) {
			serverPort = 4445;
		} else {
			serverPort = Integer.parseInt(args[1]);
		}
		if (args.length < 3) {
			localPort = 2102;
		} else {
			localPort = Integer.parseInt(args[2]);
		}
		try {
			long l = Math.round(Math.random() * 10000);
			new ShootExplorer("Shoot Explorer " + l, host, serverPort, localPort);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}

}
