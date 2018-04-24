package com.file.xml;

import org.simpleframework.xml.Text;
import org.simpleframework.xml.Attribute;

/**
 * The Class Clinic.
 * Helper class to read XML files
 */
class Clinic {
	/** The name. */
	@Text
	private String name;
	
	/** The id. */
	@Attribute(required=false)
	private String id;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
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
