package ws;

/**
 * The wumpus server's model of an explorer in the wumpus' world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Explorer extends Agent {

	/**
	 * Flag indicating whether this explorer has an arrow.
	 */
	private boolean hasArrow;

	/**
	 * Flag indicating whether this explorer has a bar of gold.
	 * It's always initially false.
	 */
	private boolean hasGold = false;

	/**
	 * Creates a new explorer, given its name, original position and
	 * direction. The explorer initially has an arrow.
	 *
	 * @param name the name of this explorer.
	 * @param row the row of the cave this explorer will
	 *          start.
	 * @param column the column of the cave this explorer will
	 *          start.
	 * @param direction the initial direction of this explorer.
	 * @see Constants#UP
	 * @see Constants#LEFT
	 * @see Constants#DOWN
	 * @see Constants#RIGHT
	 */
	public Explorer(String name, int row, int column,
												int direction) {
		this(name, row, column, direction, true);
	}
	
	/**
	 * Creates a new explorer, given its name, original position and
	 * direction and the indication whether he has an arrow or not.
	 *
	 * @param name the name of this explorer.
	 * @param row the row of the cave this explorer will
	 *          start.
	 * @param column the column of the cave this explorer will
	 *          start.
	 * @param direction the initial direction of this explorer.
	 * @param hasArrow indicates whether the explorer has an arrow.
	 * @see Constants#UP
	 * @see Constants#LEFT
	 * @see Constants#DOWN
	 * @see Constants#RIGHT
	 */
	public Explorer(String name, int row, int column,
								int direction, boolean hasArrow) {
		super(name, row, column, direction);
		this.hasArrow = hasArrow;
	}

	/**
	 * Checks whether this explorer has an arrow.
	 *
	 * @return <code>true</code> if this explorer has an arrow;
	 *          <code>false</code> otherwise.
	 */
	public boolean getHasArrow() {
		return hasArrow;
	}

	/**
	 * Checks whether this explorer has a bar of gold.
	 *
	 * @return <code>true</code> if this explorer has a bar of gold;
	 *          <code>false</code> otherwise.
	 */
	public boolean getHasGold() {
		return hasGold;
	}

	/**
	 * Determines whether this explorer has an arrow.
	 *
	 * @param value <code>true</code> if this explorer has an arrow;
	 *          <code>false</code> otherwise.
	 */
	public void setHasArrow(boolean value) {
		hasArrow = value;
	}

	/**
	 * Determines whether this explorer has a bar of gold.
	 *
	 * @param value <code>true</code> if this explorer has a bar
	 *          of gold; <code>false</code> otherwise.
	 */
	public void setHasGold(boolean value) {
		hasGold = value;
	}

	/**
	 * Tells this explorer it lost its arrow (because it has
	 * shot it).
	 */
	public void shoot() throws NoArrowException {
		setHasArrow(false);
	}

	/**
	 * Returns a XML representation of this explorer.
	 *
	 * @return a XML representation of this explorer.
	 */
	public String toXml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<Explorer name=\"");
		sb.append(getName());
		sb.append("\" row=");
		sb.append(getRow());
		sb.append(" column=");
		sb.append(getColumn());
		sb.append(" direction=");
		sb.append(getDirection());
		sb.append(" hasArrow=");
		sb.append(hasArrow);
		sb.append(" hasGold=");
		sb.append(hasGold);
		sb.append(" />");
		return sb.toString();
	}

	/**
	 * Auxiliary method used to create an instance of an Explorer from a XML
	 * string.
	 *
	 * @param xml the XML string representing an Explorer
	 * @return the Explorer represented by the given XML string.
	 */
	public static Explorer fromXml(String xml) {
		String name = "Explorer";
		int direction = UP, row = 0, col = 0;
		boolean hasArrow = false, hasGold = false;
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
			} else if (names[i].equals("hasArrow")) {
				hasArrow = values[i].charAt(0) == 't';
			} else if (names[i].equals("hasGold")) {
				hasGold = values[i].charAt(0) == 't';
			}
		}
		Explorer result = new Explorer(name, row, col, direction, hasArrow);
		result.setHasGold(hasGold);
		return result;
	}

}