package ws;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * Class that represents a XML tag. It's used to decompose a string
 * representing a tag in its name and attributes.
 *
 * @author Carlos Figueira Filho (<a href="mailto:csff@di.ufpe.br">csff@di.ufpe.br</a>)
 */
public class Tag {

	/**
	 * The tag's name.
	 */
	private String name;

	/**
	 * Indicates whether this tag is a finalizer. (&lt;/anything&gt;)
	 */
	private boolean finalizer = false;
	
	/**
	 * Indicates whether the tag is an empty tag. (&lt;anything/&gt;)
	 */
	private boolean empty = false;
	
	/**
	 * The names of the attributes of this tag.
	 */
	private String[] attribNames;

	/**
	 * The values of the attributes of this tag.
	 */
	private String[] attribValues;

	/**
	 * Class constructor. It will decompose a tag string in its name
	 * and attributes.
	 *
	 * @param str the tag string.
	 */
	public Tag(String str) {
		int inicial = 1, fim = str.length() - 1;
		if (str.charAt(fim - 1) == '/') {
			fim--;
			empty = true;
		}
		while (str.charAt(inicial) == ' ') {
			inicial++;
		}
		if (str.charAt(inicial) == '/') {
			finalizer = true;
			inicial++;
		}
		str = str.substring(inicial, fim).trim();  // retirando o "<" e o ">".
		int i = str.indexOf(' ');
		if (i == -1) {
			name = str;
			attribNames = attribValues = new String[0];
		} else {
			name = str.substring(0, i);
			str = str.substring(i).trim();
			Hashtable h = new Hashtable();
			while (str.length() != 0) {
				int indIgual = str.indexOf('=');
				String n = str.substring(0, indIgual);
				int fim2 = indIgual + 1;
				if (str.charAt(fim2) == '"') {
					fim2++;
					while (str.charAt(fim2) != '"') {
						fim2++;
					}
					h.put(n, str.substring(indIgual + 2, fim2));
					str = str.substring(fim2 + 1).trim();
				} else {
					while (fim2 < str.length() && str.charAt(fim2) != ' ') {
						fim2++;
					}
					h.put(n, str.substring(indIgual + 1, fim2));
					str = str.substring(fim2).trim();
				}
			}
			attribNames = new String[h.size()];
			attribValues = new String[h.size()];
			i = 0;
			for (Enumeration e = h.keys(); e.hasMoreElements(); ) {
				attribNames[i] = (String) e.nextElement();
				attribValues[i] = (String) h.get(attribNames[i]);
				i++;
			}
		}
	}
	/**
	 * Returns the attribute names of this tag.
	 *
	 * @return this tag's attribute names.
	 */
	public String[] getAttribNames() {
		return attribNames;
	}
	/**
	 * Returns the attribute values of this tag.
	 *
	 * @return this tag's attribute values.
	 */
	public String[] getAttribValues() {
		return attribValues;
	}
	/**
	 * Returns this tag's name.
	 *
	 * @return this tag's name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Checks whether this tag is an empty tag, like <code>&lt;anything/&gt;</code>.
	 */
	public boolean isEmpty() {
		return empty;
	}
	/**
	 * Checks whether this tag is a finalizer, like <code>.&lt;/anything&gt;</code>..
	 */
	public boolean isFinalizer() {
		return finalizer;
	}
	/**
	 * Returns a string representing this tag.
	 *
	 * @return a string representing this tag.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append('<');
		if (isFinalizer()) {
			sb.append('/');
		}
		sb.append(name);
		for (int i = 0; i < attribNames.length; i++) {
			sb.append(' ');
			sb.append(attribNames[i]);
			sb.append("=\"");
			sb.append(attribValues[i]);
			sb.append('\"');
		}
		if (isEmpty()) {
			sb.append('/');
		}
		sb.append('>');
		return sb.toString();
	}

	/**
	 * Auxiliar method that breaks a string composed of a series of tags
	 * into a string array.
	 *
	 * @param str the string that contains all the tags
	 * @return a string array with the tags split up.
	 */
	public static String[] breakTags(String tags) {
		List l = new ArrayList();
		int i = 0;
		boolean emString = false;
		StringBuffer aux = null;
		while (i < tags.length()) {
			char c = tags.charAt(i);
			if (aux == null && c == '<') {
				aux = new StringBuffer();
			}
			if (aux != null) {
				aux.append(c);
				if (c == '\"') {
					emString = !emString;
				}
				if (!emString && c == '>') {
					l.add(aux.toString());
					aux = null;
				}
			}
			i++;
		}
		return ((String[]) l.toArray(new String[0]));
	}

}