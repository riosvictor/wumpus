package ws.agents;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import ws.Constants;
import ws.Perceptions;
import ws.Tag;

/**
 * A framework for the development of agents for the wumpus server.
 * This class deals with the communication details, and can be subclassed
 * by actual implementation of agents. Agents that subclass this class
 * should override the abstract method messageReceived(TurnNotification).
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public abstract class BasicAgent implements Constants, Runnable {

	/**
	 * The socket used for the communication.
	 */
	private DatagramSocket socket;

	/**
	 * The initial row of this agent.
	 */
	private int initialRow;

	/**
	 * The initial column of this agent.
	 */
	private int initialColumn;

	/**
	 * The initial direction of this agent.
	 *
	 * @see ws.Constants#UP
	 * @see ws.Constants#LEFT
	 * @see ws.Constants#DOWN
	 * @see ws.Constants#RIGHT
	 */
	private int initialDirection;

	/**
	 * Creates a new agent, given the host name and port of the wumpus
	 * server, as well as the local port for this agent.
	 *
	 * @param name the name of this agent.
	 * @param kind the kind of this agent. Check the constants defined in
	 *          class <code>Constants</code> to see the available kinds.
	 * @param serverHost the name of the host of the wumpus server.
	 * @param serverPort the port number from which the wumpus server is
	 *          waiting for join requests.
	 * @param localPort the port this agent will listen for server messages.
	 * @exception IOException if the datagram socket can't be
	 *          created.
	 * @exception AgentCreationException if there is an error while
	 *          connecting to the wumpus server.
	 * @see ws.Constants#EXPLORER
	 * @see ws.Constants#WUMPUS
	 */
	public BasicAgent(String name, int kind, String serverHost,
											int serverPort, int localPort)
							throws IOException, AgentCreationException {
		socket = new DatagramSocket(localPort);
		(new Thread(this)).start();
		DatagramSocket joinSocket = new DatagramSocket();
		InetAddress addr = InetAddress.getByName(serverHost);
		byte[] msg;
		if (kind == WUMPUS) {
			msg = ("<join name=\""+name+"\" kind=W port="+localPort+">").getBytes();
		} else {
			msg = ("<join name=\""+name+"\" kind=E port="+localPort+">").getBytes();
		}
		DatagramPacket packet = new DatagramPacket(msg, msg.length, addr, serverPort);
		System.out.println("Sending: " + packet);
		joinSocket.send(packet);
		byte[] resp = new byte[255];
		DatagramPacket response = new DatagramPacket(resp, resp.length);
		joinSocket.receive(response);
		byte[] recv = new byte[response.getLength()];
		System.arraycopy(response.getData(), response.getOffset(), recv, 0, recv.length);
		String s = new String(recv);
		Tag t = new Tag(s);
		if (t.getName().equalsIgnoreCase("error")) {
			throw new AgentCreationException(t.getAttribValues()[0]);
		} else {
			String[] attribs = t.getAttribNames();
			String[] values = t.getAttribValues();
			for (int i = 0; i < attribs.length; i++) {
				if (attribs[i].equals("startRow")) {
					initialRow = Integer.parseInt(values[i]);
				} else if (attribs[i].equals("startColumn")) {
					initialColumn = Integer.parseInt(values[i]);
				} else if (attribs[i].equals("startDirection")) {
					switch(values[i].charAt(0)) {
						case 'U' : initialDirection = UP; break;
						case 'L' : initialDirection = LEFT; break;
						case 'D' : initialDirection = DOWN; break;
						case 'R' : initialDirection = RIGHT; break;
					}
				}
			}
		}
	}
	
	/**
	 * Inifinite loop that waits for requests of the wumpus server, and
	 * handles them to the subclass.
	 */
	public void run() {
		boolean alive = true;
		while (alive) {
			try {
				byte[] buffer = new byte[255];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				byte[] recv = new byte[packet.getLength()];
				System.arraycopy(packet.getData(), packet.getOffset(), recv, 0, recv.length);
				Tag t = new Tag(new String(recv));
//System.out.println("Received leg 1: " + new String(recv));
				if (t.getName().equalsIgnoreCase("killed")) {
					alive = false;
					killed();
				} else if (t.getName().equalsIgnoreCase("turn")) {
					TurnNotification turn = tagToTurnNotification(t);
					Action[] actions = messageReceived(turn);
//System.out.print("[");
//for(int kk=0;kk<actions.length;kk++){
//System.out.print(actions[kk].toXml());
//if(kk<actions.length-1)
//System.out.print(",");
//}
//System.out.println("]");
					if (actions.length == 0) { // Error! Sending a nop.
						actions = new Action[] { new Nop() };
					}
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < actions.length; i++) {
						sb.append(actions[i].toXml());
					}
					byte[] rsp = sb.toString().getBytes();
					DatagramPacket rspPacket = new DatagramPacket(rsp,
						rsp.length, packet.getAddress(), packet.getPort());
System.out.println("Sending leg 2: " + sb.toString());
					socket.send(rspPacket);
					byte[] bufLeg3 = new byte[255];
					DatagramPacket packetLeg3 = new DatagramPacket(bufLeg3, bufLeg3.length);
					socket.receive(packetLeg3);
					recv = new byte[packetLeg3.getLength()];
//System.out.println("packetLeg3.getLength() = " + packetLeg3.getLength());
					System.arraycopy(packetLeg3.getData(), packetLeg3.getOffset(), recv, 0, recv.length);
//System.out.println("Received leg 3: " + new String(recv));
					t = new Tag(new String(recv));
					if (t.getName().equalsIgnoreCase("killed")) {
						alive = false;
						killed();
					} else if (t.getName().equalsIgnoreCase("endturn")) {
						turn = tagToTurnNotification(t);
					} else {
						turn.setNumberOfActions(0);
						turn.setTurnEnding(true);
					}
					messageReceived(turn);
				}
			} catch (IOException e) {}
		}
	}

	/**
	 * Auxiliar method used to create a TurnNotification object from the tag received
	 * by the server.
	 *
	 * @param tag the tag received by the server.
	 * @return a TurnNotification object representing the given tag.
	 */
	private static TurnNotification tagToTurnNotification(Tag t) {
		int numberOfActions = 0;
		boolean ending;
		int perceptions = 0;
		String speech = "";
		ending = t.getName().equalsIgnoreCase("endturn");
		String[] attrib = t.getAttribNames();
		String[] values = t.getAttribValues();
		for (int i = 0; i < attrib.length; i++) {
			if (attrib[i].equalsIgnoreCase("actionsexecuted")) {
				numberOfActions = Integer.parseInt(values[i]);
			} else if (attrib[i].equalsIgnoreCase("speech")) {
				speech = values[i];
			} else if (attrib[i].equalsIgnoreCase("breeze")) {
				if (values[i].charAt(0) == 'y' || values[i].charAt(0) == 't') {
					perceptions |= BREEZE;
				}
			} else if (attrib[i].equalsIgnoreCase("stench")) {
				if (values[i].charAt(0) == 'y' || values[i].charAt(0) == 't') {
					perceptions |= STENCH;
				}
			} else if (attrib[i].equalsIgnoreCase("bump")) {
				if (values[i].charAt(0) == 'y' || values[i].charAt(0) == 't') {
					perceptions |= WALL;
				}
			} else if (attrib[i].equalsIgnoreCase("glitter")) {
				if (values[i].charAt(0) == 'y' || values[i].charAt(0) == 't') {
					perceptions |= GLITTER;
				}
			} else if (attrib[i].equalsIgnoreCase("explorerscream")) {
				if (values[i].charAt(0) == 'y' || values[i].charAt(0) == 't') {
					perceptions |= EXPLORER_SCREAM;
				}
			} else if (attrib[i].equalsIgnoreCase("wumpusscream")) {
				if (values[i].charAt(0) == 'y' || values[i].charAt(0) == 't') {
					perceptions |= WUMPUS_SCREAM;
				}
			} else if (attrib[i].equalsIgnoreCase("parfum")) {
				if (values[i].charAt(0) == 'y' || values[i].charAt(0) == 't') {
					perceptions |= PARFUM;
				}
			}
		}
		Perceptions p = new Perceptions(perceptions, speech);
		TurnNotification turn = new TurnNotification(p, ending, numberOfActions);
		return turn;
	}

	/**
	 * Callback method called that must be overriden in the subclass to
	 * implement the communication with the wumpus server.<p>
	 * The communication with the server is 3-legged: the server sends
	 * the perceptions the agent feels; the agent sends its commands for
	 * that turn to the server; finally, the server sends to the agent the
	 * new perceptions it has. This method is called in the agent twice for
	 * each turn: in the first one (corresponding to the fisrt leg of the
	 * communication) the agent must answer in a reasonable time (or the
	 * server wont accept it's response due to timeout); the second one,
	 * which corresponds to the third leg of the communication, will ignore
	 * the return of the method. The agent can know to which leg the method
	 * call corresponds by checking the parameter it receives.
	 *
	 * @param turn the turn notification for the agent, with the
	 *          perceptions it senses.
	 * @return the actions the agent wishes to execute.
	 */
	public abstract Action[] messageReceived(TurnNotification turn);

	/**
	 * Callback method, invoked when the agent is killed. It's useful
	 * if the agent has allocated some resources and needs to free them
	 * before being actually killed.
	 */
	public void killed() {
	}

	/**
	 * Returns the initial row of this agent.
	 *
	 * @return the initial row of this agent.
	 */
	public int getInitialRow() {
		return initialRow;
	}

	/**
	 * Returns the initial column of this agent.
	 *
	 * @return the initial column of this agent.
	 */
	public int getInitialColumn() {
		return initialColumn;
	}

	/**
	 * Returns the initial direction of this agent.
	 *
	 * @return the initial direction of this agent.
	 * @see ws.Constants#UP
	 * @see ws.Constants#LEFT
	 * @see ws.Constants#DOWN
	 * @see ws.Constants#RIGHT
	 */
	public int getInitialDirection() {
		return initialDirection;
	}

}
