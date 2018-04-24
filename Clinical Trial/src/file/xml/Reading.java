package file.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * The Class Reading.
 * Helper class to read XML files
 */
class Reading {
	
	/** The id. */
	private String id;
	
	/** The type. */
	private String type;
	
	/** The value. */
	//private String Value;
	private Value value;
	
	/** The Date. */
	private String Date;
	
	/** The patient. */
	private String patient;
	
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
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	@XmlElement(name = "Date")
	public String getDate() {
		return Date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		Date = date;
	}
	
	/**
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	@XmlElement(name = "Patient")
	public String getPatient() {
		return patient;
	}
	
	/**
	 * Sets the patient.
	 *
	 * @param patient the new patient
	 */
	public void setPatient(String patient) {
		this.patient = patient;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@XmlElement( name = "Value" )
	public Value getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(Value value) {
		this.value = value;
	}
	
	
}
