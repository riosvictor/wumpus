package wm;

import java.rmi.Remote;
import java.rmi.RemoteException;
import ws.Agent;
import ws.WumpusWorld;

/**
 * An interface defined to be implemented by the wumpus monitor,
 * a view of a game in the wumpus world. It defines a series of
 * callback methods to be invoked by the wumpus server.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public interface WMInterface extends Remote {

	/**
	 * Receives an update of the entire world. It will be invoked once
	 * in the beginning of the communication, and once in a while,
	 * to resynchronize in case of lost packages.
	 *
	 * @param world the world as is in the current state.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void currentWorld(WumpusWorld world) throws RemoteException;

	/**
	 * Receives an indication that an agent has turned left.
	 *
	 * @param agent the agent that turned left.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void turnLeft(Agent agent) throws RemoteException;

	/**
	 * Receives an indication that an agent has joined the game
	 *
	 * @param agent the agent that joined the game.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void join(Agent agent) throws RemoteException;

	/**
	 * Receives an indication that an agent has turned right.
	 *
	 * @param agent the agent that turned right.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void turnRight(Agent agent) throws RemoteException;

	/**
	 * Receives an indication that an agent has walked.
	 *
	 * @param agent the agent that walked.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void walk(Agent agent) throws RemoteException;

	/**
	 * Receives an indication that an agent has grabbed the gold.
	 *
	 * @param agent the agent that grabbed the gold.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void grab(Agent agent) throws RemoteException;

	/**
	 * Receives an indication that an agent has left the cave.
	 *
	 * @param agent the agent that left the cave.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void leave(Agent agent) throws RemoteException;

	/**
	 * Receives an indication that an agent has shot its arrow.
	 *
	 * @param agent the agent that shot.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void shoot(Agent agent) throws RemoteException;

	/**
	 * Receives an indication that an agent was killed. If the agent had
	 * the gold, then the gold should be available in the same room of the
	 * agent.
	 *
	 * @param agent the agent that was killed.
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void killed(Agent agent) throws RemoteException;
	
	/**
	 * Receives an indication that the game is over.
	 *
	 * @exception RemoteException if there is an error in
	 *          the communication.
	 */
	public void gameOver() throws RemoteException;

}