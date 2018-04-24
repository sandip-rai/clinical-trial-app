package com.file.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Attribute;

/**
 * The Class Reading.
 * Helper class to read XML files
 */
@Root(name="Reading")
class Reading {
	
	/** The id. */
	@Attribute(required=false)
	private String id;
	
	/** The type. */
	@Attribute(required=false)
	private String type;
	
	/** The value. */
	@Element(name = "Value", required=false)
	private Value value;
	
	/** The Date. */
	@Attribute(required=false)
	private String Date;
	
	
	/** The patient. */
	@Element(name = "Patient")
	private String patient;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
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
