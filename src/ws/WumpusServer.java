package ws;

import java.awt.Point;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import wm.WMInterface;

/**
 * The server for the wumpus world game. The server will install
 * itself in a port and listen for datagram packets sent by
 * players (agents) that intend to join the game. Once the game
 * is started, every turn this server asks the registered players
 * which actions they intend to execute.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class WumpusServer implements Runnable, Constants {

	/**
	 * The socket used for the communication.
	 */
	private DatagramSocket socket;
	
	/**
	 * The port this server uses for the communication.
	 */
	private int commPort;
	
	/**
	 * The wumpus world managed by this server.
	 */
	private WumpusWorld world;
	
	/**
	 * Server parameter: the reach of an arrow.
	 */
	private int arrowReach = 1000; // inifinity, as the cave can't be that big.
	
	/**
	 * Server parameter: the reach of the voice of the agents. The value
	 * of this parameter is the distance from which the speech of an agent
	 * will be garbled.
	 */
	private int voiceReach = 1000; // All the cave listens to what an agent says.
	
	/**
	 * Server parameter: the decay of the voice of agents, as the distance
	 * from the speaker to the listener grows bigger than the voice reach
	 * parameter.
	 */
	private double voiceDecay = 0.5;
	
	/**
	 * Server parameter: the number of points an explorer has in the
	 * beginning of his turn. The server will execute the actions the agent
	 * request as long as the explorer has enough points.
	 *
	 * @see #walkPoints
	 * @see #grabPoints
	 * @see #shootPoints
	 * @see #turnPoints
	 * @see #talkPoints
	 * @see #nopPoints
	 */
	private int explorerPoints = 10;

	/**
	 * Server parameter: the number of points a wumpus has in the beginning
	 * of his turn. The server will execute the actions the agent requests
	 * as long as the wumpus has enough points.
	 *
	 * @see #walkPoints
	 * @see #grabPoints
	 * @see #shootPoints
	 * @see #turnPoints
	 * @see #talkPoints
	 * @see #nopPoints
	 */
	private int wumpusPoints = 10;

	/**
	 * Server parameter: the number of points required for the agent
	 * to walk.
	 *
	 * @see #explorerPoints
	 * @see #wumpusPoints
	 */
	private int walkPoints = 10;

	/**
	 * Server parameter: the number of points required for the agent to
	 * grab the gold.
	 *
	 * @see #explorerPoints
	 * @see #wumpusPoints
	 */
	private int grabPoints = 10;

	/**
	 * Server parameter: the number of points required for the agent to
	 * leave the cave.
	 *
	 * @see #explorerPoints
	 * @see #wumpusPoints
	 */
	private int leavePoints = 10;

	/**
	 * Server parameter: the number of points required for the agent
	 * to turn.
	 *
	 * @see #explorerPoints
	 * @see #wumpusPoints
	 */
	private int turnPoints = 10;

	/**
	 * Server parameter: the number of points required for the agent to
	 * shoot his arrow.
	 *
	 * @see #explorerPoints
	 * @see #wumpusPoints
	 */
	private int shootPoints = 10;

	/**
	 * Server parameter: the number of points required for the agent to
	 * talk.
	 *
	 * @see #explorerPoints
	 * @see #wumpusPoints
	 */
	private int talkPoints = 10;

	/**
	 * Server parameter: the number of points required for the agent to
	 * do nothing.
	 *
	 * @see #explorerPoints
	 * @see #wumpusPoints
	 */
	private int nopPoints = 10;

	/**
	 * Auxiliar class used to store the agent clients connected to
	 * this server.
	 *
	 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
	 */
	private static class AgentClient extends Client {
		
		/**
		 * The agent representing this client.
		 */
		public Agent agent;

		/**
		 * Class constructor.
		 *
		 * @param agent the proxy agent for this client.
		 * @param address the address of this client.
		 * @param port the port of this client.
		 */
		public AgentClient(Agent agent, InetAddress address, int port) {
			super(address, port);
			this.agent = agent;
		}
	}

	/**
	 * Auxiliar class used to store the clients connected to this server.
	 *
	 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
	 */
	private static class Client {
		
		/**
		 * The address of the machine this monitor is running.
		 */
		public InetAddress address;

		/**
		 * The port number of the monitor process.
		 */
		public int port;

		/**
		 * The number of failures in the last attempts of communication
		 * with this client.
		 */
		public int commFailures;

		/**
		 * Class constructor.
		 *
		 * @param address the address of this monitor.
		 * @param port the port of this monitor.
		 */
		public Client(InetAddress address, int port) {
			this.address = address;
			this.port = port;
			this.commFailures = 0;
		}
	}

	/**
	 * The list of monitors connected to this server.
	 */
	private List monitors;

	/**
	 * The list of agent clients connected to this server.
	 */
	private List agentClients;

	/**
	 * Auxiliar class used to implement the listening of a port where new
	 * players (and monitors) will request their entrance in this server.
	 *
	 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
	 */
	private class JoiningThread extends Thread {

		/**
		 * The socket from which this thread will wait for requests.
		 */
		private DatagramSocket socket;
		
		/**
		 * Class constructor
		 *
		 * @param port the port this thread will listen to.
		 * @exception IOException if the socket can't be created.
		 */
		public JoiningThread(int port) throws IOException {
			socket = new DatagramSocket(port);
		}

		/**
		 * Auxiliar method used to add a monitor to this wumpus server.
		 *
		 * @param t the tag received from the monitor.
		 */
		private void addMonitor(Tag t) {
			String[] names = t.getAttribNames();
			String[] values = t.getAttribValues();
			if (names[0].equalsIgnoreCase("url")) {
				try {
					WMInterface monitor = (WMInterface) Naming.lookup(values[0]);
					monitors.add(monitor);
					monitor.currentWorld(world);
				} catch (Exception e) {
					// Sorry, try again.
				}
			}
		}

		/**
		 * The run method, which is an infinite loop waiting for join requests.
		 */
		public void run() {
			byte[] buffer = new byte[255];
			try {
				while (true) {
					try {
						DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
						socket.receive(packet);
						byte[] resp = new byte[packet.getLength()];
						System.arraycopy(packet.getData(), packet.getOffset(), resp, 0, resp.length);
						String s = new String(resp);
						Tag t = new Tag(s);
						System.out.println("Tag received: " + t);
						if (t.getName().equalsIgnoreCase("monitorJoin")) {
							addMonitor(t);
							continue;
						}
						boolean error = false;
						String returnMessage = null;
						if (!t.getName().equalsIgnoreCase("join")) {
							error = true;
							returnMessage = "<error kind=\"unknown message\">";
						}
						String name = null;
						boolean wumpus = false;
						int clientPort = -1;
						if (!error) {
							String[] attrib = t.getAttribNames();
							String[] values = t.getAttribValues();
							for (int i = 0; i < attrib.length; i++) {
								if (attrib[i].equals("name")) {
									name = values[i];
								}
								if (attrib[i].equals("kind")) {
									wumpus = values[i].charAt(0) == 'W' || values[i].charAt(0) == 'w';
								}
								if (attrib[i].equals("port")) {
									clientPort = Integer.parseInt(values[i]);
								}
							}
							if (name == null) {
								error = true;
								returnMessage = "<error kind=\"missing name\">";
							} else if (clientPort == -1) {
								error = true;
								returnMessage = "<error kind=\"missing client port\">";
							}
						}
						System.out.println("Wumpus = " + wumpus);
						Agent agent = null;
						if (!error) {
							try {
								agent = world.createAgent(name, wumpus ? WUMPUS : EXPLORER);
								world.addAgent(agent);
							} catch (NoSpaceException e) {
								error = true;
								returnMessage = "<error kind=\"no space left in the world\">";
							} catch (IllegalArgumentException e) {
								error = true;
								returnMessage = "<error kind=\"error placing agent at the world: "+e.getMessage()+"\">";
							}
						}
						if (!error) {
							AgentClient agentClient = new AgentClient(agent,
												packet.getAddress(), clientPort);
							boolean ok = true;
							for (int i = 0; ok && i < agentClients.size(); i++) {
								AgentClient c = (AgentClient) agentClients.get(i);
								if (c.agent.getName().equals(name)) {
									error = true;
									ok = false;
									returnMessage = "<error kind=\"there is already an agent with this name\">";
								}
							}
							if (!error) {
								agentClients.add(agentClient);
								
								// The agent will hear screams from explorers
								if (explorerScreamTTL != 0) {
									explorerScreamTTL++;
								}
								
								// The agent will hear screams from wumpuses
								if (wumpusScreamTTL != 0) {
									wumpusScreamTTL++;
								}
								
								// The agent will hear speeches from other agents
								if (speechTTL != 0) {
									speechTTL++;
								}
							}
						}
						if (!error) {
							returnMessage = "<ok startRow="+agent.getRow()+" startColumn="+agent.getColumn();
							returnMessage = returnMessage + " startDirection=";
							switch(agent.getDirection()) {
								case UP : returnMessage = returnMessage + "UP>"; break;
								case LEFT : returnMessage = returnMessage + "LEFT>"; break;
								case DOWN : returnMessage = returnMessage + "DOWN>"; break;
								case RIGHT : returnMessage = returnMessage + "RIGHT>"; break;
							}
						}
						byte[] returnMsg = returnMessage.getBytes();
						DatagramPacket response = new DatagramPacket(returnMsg, returnMsg.length,
																packet.getAddress(), packet.getPort());
						System.out.println("Sending: " + returnMessage);
						socket.send(response);
						if (!error) {
							for (int i = 0; i < monitors.size(); i++) {
								WMInterface monitor = (WMInterface) monitors.get(i);
								monitor.join(agent);
							}
						}
						System.out.println("Sent");
					} catch (IOException e) {}
				}
			} catch (Exception e) {
				System.out.println("Erro: " + e);
				e.printStackTrace();
			}
		}
	}

	/**
	 * The timeout that happens between two turns. Useful for the monitors
	 * be able to refresh themselves.
	 */
	//private long timeBetweenTurns = 20000;
	private long timeBetweenTurns = 1000;
	
	/**
	 * The time remaining until an explorer scream ceases to be heard.
	 */
	private int explorerScreamTTL;
	
	/**
	 * The time remaining until a wumpus scream ceases to be heard.
	 */
	private int wumpusScreamTTL;

	/**
	 * The speech some agent has made.
	 */
	private String speech = "";
	
	/**
	 * The time remaining until a speech ceases to be heard.
	 */
	private int speechTTL;

	/**
	 * The position from which the last agent has spoken.
	 */
	private Point speechPosition;

	/**
	 * Creates a new Wumpus Server, given the port it will
	 * stay listening for requests.
	 *
	 * @param world the wumpus world this server will manage. It
	 *          must initially be empty (i.e., no wumpuses or
	 *          explorers).
	 * @param serverPort the port number of this server.
	 * @param joinServerPort the port number of the server waiting for
	 *          join requests.
	 * @exception IOException if the datagram socket can't be
	 *          created.
	 */
	public WumpusServer(WumpusWorld world, int serverPort, int joinServerPort) throws IOException {
		this.world = world;
		this.agentClients = new ArrayList();
		this.monitors = new ArrayList();
		this.commPort = serverPort;
		new JoiningThread(joinServerPort).start();
		socket = new DatagramSocket(serverPort);

		/* 10 seconds is the maximum time this server will
		   wait for the response of an agent/player.
		*/
		socket.setSoTimeout(10000);
		new Thread(this).start();
	}

	/**
	 * Auxiliar method, used to transform a set of perceptions into a
	 * string that will be sent to the agent clients.
	 *
	 * @param p the set of perceptions
	 * @return a string to be sent to the agent clients.
	 */
	private static String perceptionsToString(Perceptions p) {
		StringBuffer sb = new StringBuffer();
		sb.append("breeze=");
		sb.append((p.getBreeze()) ? "yes " : "no ");
		sb.append("stench=");
		sb.append((p.getStench()) ? "yes " : "no ");
		sb.append("parfum=");
		sb.append((p.getParfum()) ? "yes " : "no ");
		sb.append("bump=");
		sb.append((p.getWall()) ? "yes " : "no ");
		sb.append("wumpusScream=");
		sb.append((p.getWumpusScream()) ? "yes " : "no ");
		sb.append("explorerScream=");
		sb.append((p.getExplorerScream()) ? "yes " : "no ");
		sb.append("glitter=");
		sb.append((p.getGlitter()) ? "yes " : "no ");
		sb.append("speech=\"");
		sb.append(p.getSpeech());
		sb.append("\" ");
		return sb.toString();
	}

	/**
	 * Sends to an agent a message indicating that it was killed. Also,
	 * warns the monitors that the agent was killed.
	 *
	 * @param agent the agent that was killed.
	 */
	private void sayGoodbye(Agent agent) {
		DatagramPacket packet = null;
		try {
			for (Iterator i = agentClients.iterator(); i.hasNext(); ) {
				AgentClient c = (AgentClient) i.next();
				if (c.agent.equals(agent)) {
					byte[] msg = "<killed>".getBytes();
					packet = new DatagramPacket(msg, msg.length,
													c.address, c.port);
				}
			}
			if (packet != null) {
				socket.send(packet);
			}
		} catch (IOException e) {
			// Sorry, the agent is dead but it won't realize that...
		}
		for (int i = 0; i < monitors.size(); i++) {
			WMInterface monitor = (WMInterface) monitors.get(i);
			try {
				monitor.killed(agent);
			} catch (RemoteException e) {} // Sorry, nothing to do.
		}
	}

	/**
	 * Send to all registered monitors the message that the given agent has
	 * turned left.
	 *
	 * @param agent the agent that turned left.
	 */
	private void monitorAgentTurnLeft(Agent agent) {
		for (int i = 0; i < monitors.size(); i++) {
			WMInterface monitor = (WMInterface) monitors.get(i);
			try {
				monitor.turnLeft(agent);
			} catch (RemoteException e) {} // Sorry, nothing to do.
		}
	}

	/**
	 * Send to all registered monitors the message that the given agent has
	 * turned right.
	 *
	 * @param agent the agent that turned right.
	 */
	private void monitorAgentTurnRight(Agent agent) {
		for (int i = 0; i < monitors.size(); i++) {
			WMInterface monitor = (WMInterface) monitors.get(i);
			try {
				monitor.turnRight(agent);
			} catch (RemoteException e) {} // Sorry, nothing to do.
		}
	}

	/**
	 * Send to all registered monitors the message that the given agent has
	 * walked.
	 *
	 * @param agent the agent that walked.
	 */
	private void monitorAgentWalk(Agent agent) {
		for (int i = 0; i < monitors.size(); i++) {
			WMInterface monitor = (WMInterface) monitors.get(i);
			try {
				monitor.walk(agent);
			} catch (RemoteException e) {} // Sorry, nothing to do.
		}
	}

	/**
	 * Send to all registered monitors the message that the given agent has
	 * grabbed the gold.
	 *
	 * @param agent the agent that grabbed the gold.
	 */
	private void monitorAgentGrab(Agent agent) {
		for (int i = 0; i < monitors.size(); i++) {
			WMInterface monitor = (WMInterface) monitors.get(i);
			try {
				monitor.grab(agent);
			} catch (RemoteException e) {} // Sorry, nothing to do.
		}
	}

	/**
	 * Send to all registered monitors the message that the given agent has
	 * left the cave.
	 *
	 * @param agent the agent that left the cave.
	 */
	private void monitorAgentLeave(Agent agent) {
		for (int i = 0; i < monitors.size(); i++) {
			WMInterface monitor = (WMInterface) monitors.get(i);
			try {
				monitor.leave(agent);
			} catch (RemoteException e) {} // Sorry, nothing to do.
		}
	}

	/**
	 * Processes the actions received from an agent client. This method will
	 * return the end turn tag that should be sent back to the client.
	 *
	 * @param client the agent client from which the actions came.
	 * @param msg the message that came from the client.
	 * @return the end turn tag that shall be sent back to the client.
	 */
	private String processActions(AgentClient client, String msg) {
		int agentPoints = (client.agent instanceof Wumpus) ?
										wumpusPoints : explorerPoints;
		System.out.println(client.agent.getName()+"    AgentPoints: "+agentPoints);
		String[] tags = Tag.breakTags(msg);
		Agent a = client.agent;
		boolean bump = false;
		int i = 0, numberOfActions = 0;
		while (i < tags.length && agentPoints >= 0) {
			Tag t = new Tag(tags[i++]);
			String[] attribs = t.getAttribNames();
			String[] values = t.getAttribValues();
			if (t.getName().equalsIgnoreCase("nop")) {
				agentPoints -= nopPoints;
				if (agentPoints < 0) {
					continue;
				}
				numberOfActions++;
			} else if (t.getName().equalsIgnoreCase("turn")) {
				agentPoints -= turnPoints;
				if (agentPoints < 0) {
					continue;
				}
				if (values.length > 0) {
					if (values[0].equalsIgnoreCase("left")) {
						world.turnLeft(a);
						monitorAgentTurnLeft(a);
					} else {
						world.turnRight(a);
						monitorAgentTurnRight(a);
					}
					numberOfActions++;
				}
			} else if (t.getName().equalsIgnoreCase("walk")) {
				agentPoints -= walkPoints;
				if (agentPoints < 0) {
					continue;
				}
				try {
					world.walk(a);
					monitorAgentWalk(a);
					Room room = world.getRoom(a.getRow(), a.getColumn());
					if ((room.getWumpus() != null || room.getPit()) &&
										room.getNumberOfExplorers() != 0) {
						// All the explorers in the room were killed!!!
						for (Iterator it = room.getExplorers().iterator();
															it.hasNext(); ) {
							Explorer killed = (Explorer) it.next();
							killed.kill();
							sayGoodbye(killed);
						}
					}
				} catch (BumpException e) {
					bump = true;
				}
				numberOfActions++;
			} else if (t.getName().equalsIgnoreCase("shoot")) {
				agentPoints -= shootPoints;
				if (agentPoints < 0) {
					continue;
				}
				if (a instanceof Explorer) {
					try {
						Agent killed = world.shoot((Explorer) a, arrowReach);
						numberOfActions++;
						if (killed != null) {   // Someone was killed!!!
							if (killed instanceof Wumpus) {
								wumpusScreamTTL = agentClients.size();
							} else if (killed instanceof Explorer) {
								explorerScreamTTL = agentClients.size();
							}
							killed.kill();
							sayGoodbye(killed);
						}
					} catch (NoArrowException e) {
						// Sorry, nothing to do.
					}
				}
			} else if (t.getName().equalsIgnoreCase("grab")) {
				agentPoints -= grabPoints;
				if (agentPoints < 0) {
					continue;
				}
				if (a instanceof Explorer) {
					try {
						world.grab((Explorer) a);
						numberOfActions++;
						monitorAgentGrab(a);
					} catch (NoGoldException e) {
						// Sorry, there's nothing we can do...
					}
				}
			} else if (t.getName().equalsIgnoreCase("leave")) {
				agentPoints -= leavePoints;
				if (agentPoints < 0) {
					continue;
				}
				if (a instanceof Explorer) {
					try {
						world.leave((Explorer) a);
						numberOfActions++;
						monitorAgentLeave(a);
					} catch (IllegalArgumentException e) {
						// Sorry, there's nothing we can do...
					}
				}
			} else if (t.getName().equalsIgnoreCase("speak")) {
				agentPoints -= talkPoints;
				if (agentPoints < 0) {
					continue;
				}
				if (values.length > 0) {
					speech = values[0];
					speechTTL = agentClients.size();
					speechPosition = new Point(a.getRow(), a.getColumn());
					numberOfActions++;
				}
			}
		}
		String speechHeard = this.speech;
		// Checking whether the agent will hear some speech.
		if (speechTTL > 0) {
			int distFromSpeaker = 0;
			distFromSpeaker += Math.abs(speechPosition.x - a.getRow());
			distFromSpeaker += Math.abs(speechPosition.y - a.getColumn());
			int garbling = distFromSpeaker / voiceReach;
			double percentGarbled = 1;
			while (garbling > 0) {
				percentGarbled *= voiceDecay;
				garbling--;
			}
			if (percentGarbled != 1) {
				speechHeard = Perceptions.garbleSpeech(speech,
											percentGarbled * 100);
			}
		}
		Perceptions p = world.getPerceptions(a.getRow(),
						a.getColumn(), bump, wumpusScreamTTL > 0,
						explorerScreamTTL > 0);
		p.setSpeech(speechHeard);
		return "<endturn actionsExecuted="+numberOfActions+" " + perceptionsToString(p) + ">";
	}

	/**
	 * The main part of this class. Continuously listens
	 * for datagrams in a port, responding to them as they
	 * arrive.
	 */
	public void run() {
		byte[] buffer = new byte[512];
		while (true) {
			try {
				Thread.sleep(timeBetweenTurns);
			} catch (InterruptedException e) {}
			
			// The list of the agents that have been killed in that round.
			List dead = new ArrayList();

			// if there is any live agents in the world, ask them what to do.
			if (agentClients.size() != 0) {
				for (int i = 0; i < agentClients.size(); i++) {
					AgentClient c = (AgentClient) agentClients.get(i);
					Agent agent = c.agent;

					if (agent.isAlive()) {

						String speechHeard = this.speech;
						// Checking whether the agent will hear some speech.
						if (speechTTL > 0) {
							int distFromSpeaker = 0;
							distFromSpeaker += Math.abs(speechPosition.x - agent.getRow());
							distFromSpeaker += Math.abs(speechPosition.y - agent.getColumn());
							int garbling = distFromSpeaker / voiceReach;
							double percentGarbled = 1;
							while (garbling > 0) {
								percentGarbled *= voiceDecay;
								garbling--;
							}
							if (percentGarbled != 1) {
								speechHeard = Perceptions.garbleSpeech(speech,
															percentGarbled * 100);
							}
						}
						Perceptions p = world.getPerceptions(agent.getRow(),
										agent.getColumn(), false, wumpusScreamTTL > 0,
										explorerScreamTTL > 0);
						p.setSpeech(speechHeard);
						String leg1 = "<turn " + perceptionsToString(p) + ">";
						byte[] msgLeg1 = leg1.getBytes();
						try {
							DatagramPacket pktLeg1 = new DatagramPacket(msgLeg1,
											msgLeg1.length, c.address, c.port);
							// Sending the turn and perceptions to the agent
System.out.println("Sending leg 1: " + leg1);
							socket.send(pktLeg1);
							
							// waiting for the response of the agent...
							DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
							socket.receive(packet);
							byte[] msgLeg2 = new byte[packet.getLength()];
							System.arraycopy(packet.getData(),
												packet.getOffset(),
												msgLeg2, 0, msgLeg2.length);
							String leg2 = new String(msgLeg2);
System.out.println("Chegou leg2: " + leg2);
							String leg3 = processActions(c, leg2);
							byte[] msgLeg3 = leg3.getBytes();
							DatagramPacket pktLeg3 = new DatagramPacket(msgLeg3,
											msgLeg3.length, c.address, c.port);
System.out.println("Sending leg 3: " + leg3);
							socket.send(pktLeg3);
							c.commFailures = 0;
						} catch (InterruptedIOException e) {
							c.commFailures++;
							if (c.commFailures == 3) {
								// After 3 unsuccessful attempts, kill kim.
								dead.add(c);
							}
							System.out.println("Exception: " + e);
						} catch (IOException e) {
							System.out.println("Exception: " + e);
						}
					}
				}
			}
			
			// Removing the dead agents...
			if (dead.size() != 0) {
				for (int i = 0; i < dead.size(); i++) {
					Agent a = (Agent) dead.get(i);
					for (Iterator it = agentClients.iterator(); it.hasNext(); ) {
						AgentClient c = (AgentClient) it.next();
						if (c.agent.equals(a)) {
							it.remove();
						}
					}
				}
			}
		}
	}

	/**
	 * Test method of the class.
	 *
	 * @param args command-line arguments. The user must enter the
	 *          port number of the server, and the port number of the
	 *          join server.
	 */
	public static void main(String[] args) {
		int commPort, joinPort;
		if (args.length < 2) {
			System.out.println("WumpusServer V1.0.");
			System.out.println("Usage: java ws.WumpusServer serverPort joinServerPort [arguments]");
			System.out.println("Where:");
			System.out.println("  serverPort = port from which the server will communicate with its clients");
			System.out.println("  joinServerPort = port from which the server will wait for join requests");
			System.out.println("Optional arguments [and their default values]:");
			System.out.println("  -W:<n> - the width of the world [10]");
			System.out.println("  -H:<n> - the height of the world [10]");
			System.out.println("  -P:<n> - the pit probability of the world [0.2]");
			System.out.println("  -A:<n> - the reach of the arrow when shot by an explorer [1000]");
			System.out.println("  -V:<n> - the reach of the voice of an agent, before getting garbled. [1000]");
			System.out.println("  -v:<n> - the decay of the voice of an agent, after the reach area. [0.5]");
			System.out.println("  -e:<n> - the number of points an explorer has for its turn [10]");
			System.out.println("  -w:<n> - the number of points a wumpus has for its turn [10]");
			System.out.println("  -k:<n> - the number of points needed for an agent to walk [10]");
			System.out.println("  -t:<n> - the number of points needed for an agent to turn [10]");
			System.out.println("  -s:<n> - the number of points needed for an agent to shoot [10]");
			System.out.println("  -g:<n> - the number of points needed for an agent to grab [10]");
			System.out.println("  -L:<n> - the number of points needed for an agent to leave the cave [10]");
			System.out.println("  -l:<n> - the number of points needed for an agent to talk [10]");
			System.out.println("  -n:<n> - the number of points needed for an agent to do nothing [10]");
			System.exit(0);
		}
		commPort = Integer.parseInt(args[0]);
		joinPort = Integer.parseInt(args[1]);
		int width = 10, height = 10;
		int arrowReach = 1000, voiceReach = 1000;
		double voiceDecay = 0.5, pitProbability = 0.2;
		int explorerPoints = 10, wumpusPoints = 10, walkPoints = 10;
		int turnPoints = 10, shootPoints = 10, grabPoints = 10;
		int leavePoints = 10, talkPoints = 10, nopPoints = 10;
		for (int i = 2; i < args.length; i++) {
			if (args[i].length() < 3) {
				continue;
			}
			if (args[i].charAt(0) != '-' || args[i].charAt(2) != ':') {
				continue;
			}
			switch (args[i].charAt(1)) {
				case 'W': width = Integer.parseInt(args[i].substring(3)); break;
				case 'H': height = Integer.parseInt(args[i].substring(3)); break;
				case 'P': pitProbability = Double.parseDouble(args[i].substring(3)); break;
				case 'A': arrowReach = Integer.parseInt(args[i].substring(3)); break;
				case 'V': voiceReach = Integer.parseInt(args[i].substring(3)); break;
				case 'v': voiceDecay = Double.parseDouble(args[i].substring(3)); break;
				case 'e': explorerPoints = Integer.parseInt(args[i].substring(3)); break;
				case 'w': wumpusPoints = Integer.parseInt(args[i].substring(3)); break;
				case 'k': walkPoints = Integer.parseInt(args[i].substring(3)); break;
				case 't': turnPoints = Integer.parseInt(args[i].substring(3)); break;
				case 's': shootPoints = Integer.parseInt(args[i].substring(3)); break;
				case 'g': grabPoints = Integer.parseInt(args[i].substring(3)); break;
				case 'L': leavePoints = Integer.parseInt(args[i].substring(3)); break;
				case 'l': talkPoints = Integer.parseInt(args[i].substring(3)); break;
				case 'n': nopPoints = Integer.parseInt(args[i].substring(3)); break;
			}
		}
		WumpusWorld world = new WumpusWorld(width, height, pitProbability);
		try {
			WumpusServer server = new WumpusServer(world, commPort, joinPort);
			server.arrowReach = arrowReach;
			server.voiceReach = voiceReach;
			server.voiceDecay = voiceDecay;
			server.explorerPoints = explorerPoints;
			server.wumpusPoints = wumpusPoints;
			server.walkPoints = walkPoints;
			server.turnPoints = turnPoints;
			server.shootPoints = shootPoints;
			server.leavePoints = leavePoints;
			server.grabPoints = grabPoints;
			server.talkPoints = talkPoints;
			server.nopPoints = nopPoints;
			System.out.println("Wumpus Server launched!");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
