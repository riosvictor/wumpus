package ws;

/**
 * Exception thrown when an agent tries to shoot but he hasn't any arrow
 * to do so.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class NoArrowException extends Exception {

	/**
	 * Creates a new no arrow exception, with no detail message.
	 */
	public NoArrowException() {
		super();
	}

	/**
	 * Creates a new no arrow exception, with a message that further
	 * explains the error.
	 *
	 * @param msg the detail message.
	 */
	public NoArrowException(String msg) {
		super(msg);
	}

}