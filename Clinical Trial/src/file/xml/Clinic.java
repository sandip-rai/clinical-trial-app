package file.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


/**
 * The Class Clinic.
 * Helper class to read XML files
 */
class Clinic {
	
	/** The name. */
	private String name;
	
	/** The id. */
	private String id;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@XmlValue
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
}
