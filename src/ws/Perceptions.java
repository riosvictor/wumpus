package ws;

/**
 * A set of perceptions an agent has in the wumpus world.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 * @see Constants#BREEZE
 * @see Constants#STENCH
 * @see Constants#PARFUM
 * @see Constants#WALL
 * @see Constants#WUMPUS_SCREAM
 * @see Constants#EXPLORER_SCREAM
 * @see Constants#GLITTER
 */
public class Perceptions implements Constants {

	/**
	 * A breeze, indicating that in one of the neighbouring rooms
	 * there is a pit.
	 */
	private boolean breeze;

	/**
	 * A stench, indicating that in one of the neighbouring rooms
	 * there is a wumpus.
	 */
	private boolean stench;

	/**
	 * A parfum, indicating that in one of the neighbouring rooms
	 * there is an explorer.
	 */
	private boolean parfum;

	/**
	 * A glitter, indicating that in the room there is a bar of gold.
	 */
	private boolean glitter;

	/**
	 * A wall, indicating that the agent tried to walk into one
	 * of the ends of the cave (a wall).
	 */
	private boolean wall;

	/**
	 * A wumpus scream, indicating that somewhere in the cave a
	 * wumpus was killed.
	 */
	private boolean wumpusScream;

	/**
	 * An explorer scream, indicating that somewhere in the cave an
	 * explorer was killed.
	 */
	private boolean explorerScream;

	/**
	 * Something someone has spoken.
	 */
	private String speech;

	/**
	 * Creates a new set of perceptions.
	 *
	 * @param perceptions the perceptions the agent will receive.
	 */
	public Perceptions(int perceptions) {
		this(perceptions, "");
	}

	/**
	 * Creates a new set of perceptions, including a speech someone
	 * has made.
	 *
	 * @param perceptions the perceptions the agent will receive.
	 * @param speech a speech someone has made.
	 */
	public Perceptions(int perceptions, String speech) {
		this.breeze = (perceptions & BREEZE) != 0;
		this.stench = (perceptions & STENCH) != 0;
		this.parfum = (perceptions & PARFUM) != 0;
		this.glitter = (perceptions & GLITTER) != 0;
		this.wall = (perceptions & WALL) != 0;
		this.wumpusScream = (perceptions & WUMPUS_SCREAM) != 0;
		this.explorerScream = (perceptions & EXPLORER_SCREAM) != 0;
		this.speech = speech;
	}

	/**
	 * Checks whether there is a breeze in this set of perceptions.
	 *
	 * @return <code>true</code> if there is a breeze;
	 *          <code>false</code> otherwise.
	 */
	public boolean getBreeze() {
		return breeze;
	}

	/**
	 * Checks whether there is a stench in this set of perceptions.
	 *
	 * @return <code>true</code> if there is a stench;
	 *          <code>false</code> otherwise.
	 */
	public boolean getStench() {
		return stench;
	}

	/**
	 * Checks whether there is a parfum in this set of perceptions.
	 *
	 * @return <code>true</code> if there is a parfum;
	 *          <code>false</code> otherwise.
	 */
	public boolean getParfum() {
		return parfum;
	}

	/**
	 * Checks whether there is a glitter in this set of perceptions.
	 *
	 * @return <code>true</code> if there is a glitter;
	 *          <code>false</code> otherwise.
	 */
	public boolean getGlitter() {
		return glitter;
	}

	/**
	 * Checks whether there is a wall in this set of perceptions.
	 *
	 * @return <code>true</code> if there is a wall;
	 *          <code>false</code> otherwise.
	 */
	public boolean getWall() {
		return wall;
	}

	/**
	 * Checks whether there is a wumpus scream in this set
	 * of perceptions.
	 *
	 * @return <code>true</code> if there is a wumpus scream;
	 *          <code>false</code> otherwise.
	 */
	public boolean getWumpusScream() {
		return wumpusScream;
	}

	/**
	 * Checks whether there is an explorer scream in this set
	 * of perceptions.
	 *
	 * @return <code>true</code> if there is an explorer scream;
	 *          <code>false</code> otherwise.
	 */
	public boolean getExplorerScream() {
		return explorerScream;
	}

	/**
	 * Returns the speech of this set of perceptions.
	 *
	 * @return the speech of this set of perceptions.
	 */
	public String getSpeech() {
		return speech;
	}

	/**
	 * Sets the speech of this set of perceptions.
	 *
	 * @param speech the speech of this set of perceptions.
	 */
	public void setSpeech(String speech) {
		this.speech = speech;
	}

	/**
	 * Determines whether this set of perceptions has a wall.
	 *
	 * @param value <code>true</code> if the agent has a perception
	 *          that it hit the wall; <code>false</code> otherwise.
	 */
	public void setWall(boolean value) {
		this.wall = value;
	}

	/**
	 * Utilitary method used to garbles the speech in this
	 * set of perceptions. Useful in simulating the decay of
	 * the loudness of the voice for distant rooms.
	 *
	 * @param speech the speech to be garbled.
	 * @param garblePercent the percentage of the message to
	 *          be garbled.
	 */
	public static String garbleSpeech(String speech, double garblePercent) {
		garblePercent /= 100.0;
		StringBuffer sb = new StringBuffer(speech);
		for (int i = 0; i < speech.length(); i++) {
			if (Math.random() < garblePercent) {
				sb.setCharAt(i, ' ');
			}
		}
		return sb.toString();		
	}

}