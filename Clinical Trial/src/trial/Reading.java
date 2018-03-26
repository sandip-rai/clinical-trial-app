package trial;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reading class creates objects of readings for the Patient objects. Need to
 * add the clinic section
 */

public class Reading {

	// Initializing parameters
	private String readingId;
	private String type;
	private String value;
	private Date date;
	private String clinicId;
	private Clinic clinic;

	// Constructor for every reading value except of blood_pressure type
	public Reading(String readingId, String type, String value, Date date, Clinic clinic) {
		type = validType(type);
		if (type == null) {
			throw new IllegalArgumentException("Reading type not supported.");
		}
		this.readingId = readingId;
		this.type = type;
		this.value = value;
		this.date = date;
		this.clinic = clinic;
	}

	private String validType(String type) {
		type = type.toLowerCase();
		if (type.equals("weight")) {
			type = "Weight";
		} else if (type.equals("steps")) {
			type = "Steps";
		} else if (type.equals("temp") || type.equals("temperature")) {
			type = "Temperature";
		} else if (type.equals("blood_press") || type.equals("blood pressure") || type.equals("bloodpressure")) {
			type = "Blood Pressure";
		}
		if (type.equals("Weight") || type.equals("Steps") || type.equals("Temperature")
				|| type.equalsIgnoreCase("Blood Pressure")) {
			return type;
		}
		return null;
	}

	/**
	 * toString method to print the String representation of the Reading object
	 */
	public String toString(String dateFormat) {
		String date;
		if (this.date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			date = formatter.format(this.date);
		}else {
			date = "Unknown";
		}
		String string = "Reading ID: " + readingId + "\n" + "Type: " + type + "\n" + "Value: " + value + "\n" + "Date: "
				+ date + "\n";
		if (clinic != null) {
			string = string + "Clinic: " + clinic.toString() + "\n\n";
		} else {
			string = string + "Clinic: Unkown\n\n";
		}
		return string;
	}

	/**
	 * Getter for readingId
	 * 
	 * @return readingId of the patient
	 */
	public String getReadingId() {
		return readingId;
	}

	/**
	 * Getter for type
	 * 
	 * @return type of reading of the patient
	 */
	public String getType() {
		return type;
	}

	/**
	 * Getter for value of every type
	 * 
	 * @return value of the reading of the patient
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Getter for date
	 * 
	 * @return date of the reading of the patient
	 */
	public Date getDate() {
		return date;
	}

	public String getClinicId() {
		return clinicId;
	}

	public Clinic getClinic() {
		if (clinic == null) {
			return new Clinic("Unknown", "Unkown");
		}
		return clinic;
	}
}