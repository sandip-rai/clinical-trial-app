package trial;

/**
 * The Class SystemSettings.
 */
public class SystemSettings {
	
	/** The json add unknown patients. */
	private boolean jsonAddUnknownPatients = false;
	
	/** The json add unknown readings. */
	private boolean jsonAddUnknownReadings = false;
	
	/** The xml add unknown patients. */
	private boolean xmlAddUnknownPatients = true;
	
	/** The xml add unknown readings. */
	private boolean xmlAddUnknownReadings = true;
	
	/** The add unknown clinics. */
	private boolean addUnknownClinics = true;

	/** The date format. */
	private String dateFormat = "ddMMMyyyy HH:mm";
	
	/**
	 * Json add unknown patients.
	 *
	 * @return true, if successful
	 */
	public boolean jsonAddUnknownPatients() {
		return jsonAddUnknownPatients;
	}
	
	/**
	 * Sets the json add unknown patients.
	 *
	 * @param jsonAddUnknownPatients the new json add unknown patients
	 */
	public void setJsonAddUnknownPatients(boolean jsonAddUnknownPatients) {
		this.jsonAddUnknownPatients = jsonAddUnknownPatients;
	}
	
	/**
	 * Json add unknown readings.
	 *
	 * @return true, if successful
	 */
	public boolean jsonAddUnknownReadings() {
		return jsonAddUnknownReadings;
	}
	
	/**
	 * Sets the json add unknown readings.
	 *
	 * @param jsonAddUnknownReadings the new json add unknown readings
	 */
	public void setJsonAddUnknownReadings(boolean jsonAddUnknownReadings) {
		this.jsonAddUnknownReadings = jsonAddUnknownReadings;
	}
	
	/**
	 * Xml add unknown patients.
	 *
	 * @return true, if successful
	 */
	public boolean xmlAddUnknownPatients() {
		return xmlAddUnknownPatients;
	}
	
	/**
	 * Sets the xml add unknown patients.
	 *
	 * @param xmlAddUnknownPatients the new xml add unknown patients
	 */
	public void setXmlAddUnknownPatients(boolean xmlAddUnknownPatients) {
		this.xmlAddUnknownPatients = xmlAddUnknownPatients;
	}
	
	/**
	 * Xml add unknown readings.
	 *
	 * @return true, if successful
	 */
	public boolean xmlAddUnknownReadings() {
		return xmlAddUnknownReadings;
	}
	
	/**
	 * Sets the xml add unknown readings.
	 *
	 * @param xmlAddUnknownReadings the new xml add unknown readings
	 */
	public void setXmlAddUnknownReadings(boolean xmlAddUnknownReadings) {
		this.xmlAddUnknownReadings = xmlAddUnknownReadings;
	}
	
	/**
	 * Gets the date format.
	 *
	 * @return the date format
	 */
	public String getDateFormat() {
		return dateFormat;
	}
	
	/**
	 * Sets the date format.
	 *
	 * @param dateFormat the new date format
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	/**
	 * Adds the unknown clinics.
	 *
	 * @return true, if successful
	 */
	public boolean addUnknownClinics() {
		return addUnknownClinics;
	}
	
	/**
	 * Sets the adds the unknown clinics.
	 *
	 * @param addUnknownClinics the new adds the unknown clinics
	 */
	public void setAddUnknownClinics(boolean addUnknownClinics) {
		this.addUnknownClinics = addUnknownClinics;
	}

}
