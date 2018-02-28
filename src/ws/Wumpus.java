package ws;

/**
 * The wumpus server's model of a wumpus in the wumpus' world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Wumpus extends Agent {

	/**
	 * Creates a new wumpus, given its name, original position and
	 * direction.
	 *
	 * @param name the name of this wumpus.
	 * @param row the row of the cave this wumpus will
	 *          start.
	 * @param column the column of the cave this wumpus will
	 *          start.
	 * @param direction the initial direction of this explorer.
	 * @see Constants#UP
	 * @see Constants#LEFT
	 * @see Constants#DOWN
	 * @see Constants#RIGHT
	 */
	public Wumpus(String name, int row, int column, int direction) {
		super(name, row, column, direction);
	}

	/**
	 * Returns a XML representation of this wumpus.
	 *
	 * @return a XML representation of this wumpus.
	 */
	public String toXml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<Wumpus name=\"");
		sb.append(getName());
		sb.append("\" row=");
		sb.append(getRow());
		sb.append(" column=");
		sb.append(getColumn());
		sb.append(" direction=");
		sb.append(getDirection());
		sb.append(" />");
		return sb.toString();
	}
	
	/**
	 * Auxiliary method used to create an instance of a Wumpus from a XML
	 * string.
	 *
	 * @param xml the XML string representing a Wumpus
	 * @return the Wumpus represented by the given XML string.
	 */
	public static Wumpus fromXml(String xml) {
		String name = "Wumpus";
		int direction = UP, row = 0, col = 0;
		Tag t = new Tag(xml);
		String[] names = t.getAttribNames();
		String[] values = t.getAttribValues();
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("name")) {
				name = values[i];
			} else if (names[i].equals("row")) {
				row = Integer.parseInt(values[i]);
			} else if (names[i].equals("column")) {
				col = Integer.parseInt(values[i]);
			} else if (names[i].equals("direction")) {
				direction = Integer.parseInt(values[i]);
			}
		}
		return new Wumpus(name, row, col, direction);
	}
}