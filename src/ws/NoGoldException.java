package ws;

/**
 * Exception thrown when an agent tries to grab the bar of gold in a room
 * where there's no such bar.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class NoGoldException extends Exception {

	/**
	 * Creates a new no gold exception, with no detail message.
	 */
	public NoGoldException() {
		super();
	}

	/**
	 * Creates a new no gold exception, with a message that further
	 * explains the error.
	 *
	 * @param msg the detail message.
	 */
	public NoGoldException(String msg) {
		super(msg);
	}

}