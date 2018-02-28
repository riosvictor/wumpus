package ws;

/**
 * Exception thrown when an agent tries to walk into a wall in
 * the wumpus' world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class BumpException extends Exception {

	/**
	 * Creates a new bump exception, with no detail message.
	 */
	public BumpException() {
		super();
	}

	/**
	 * Creates a new bump exception, with a message that further
	 * explains the error.
	 *
	 * @param msg the detail message.
	 */
	public BumpException(String msg) {
		super(msg);
	}

}