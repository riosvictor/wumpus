package ws;

/**
 * Exception thrown when an agent tries to enter the wumpus world, but there
 * is no space where it can enter safely.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class NoSpaceException extends Exception {

	/**
	 * Creates a new no space exception, with no detail message.
	 */
	public NoSpaceException() {
		super();
	}

	/**
	 * Creates a new no space exception, with a message that further
	 * explains the error.
	 *
	 * @param msg the detail message.
	 */
	public NoSpaceException(String msg) {
		super(msg);
	}

}