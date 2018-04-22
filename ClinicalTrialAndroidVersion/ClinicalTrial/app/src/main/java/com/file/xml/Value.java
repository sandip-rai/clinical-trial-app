package file.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * The Class Value.
 * Helper class to read XML files
 */
class Value {
	
	/** The value. */
	private String value;
	
	/** The unit. */
	private String unit;
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@XmlValue
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	@XmlAttribute(name = "unit")
	public String getUnit() {
		return unit;
	}
	
	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
