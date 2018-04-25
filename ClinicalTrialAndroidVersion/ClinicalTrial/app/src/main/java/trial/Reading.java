package trial;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reading class creates objects of readings for the Patient objects. Need to
 * add the clinic section
 */

public class Reading {

	/** The reading id. */
	// Initializing parameters
	private String readingId;
	
	/** The type. */
	private String type;
	
	/** The value. */
	private String value;
	
	/** The date. */
	private Date date;
	
	/** The clinic. */
	private Clinic clinic;

	/**
	 * Instantiates a new reading.
	 *
	 * @param readingId the reading id
	 * @param type the type
	 * @param value the value
	 * @param date the date
	 * @param clinic the clinic
	 */
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

	/**
	 * Verify a valid type was input and sets it to a standard value.
	 *
	 * @param type the type
	 * @return the string
	 */
	private String validType(String type) {
		//Set type to all lower case
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
		//If type was recognized return the type
		if (type.equals("Weight") || type.equals("Steps") || type.equals("Temperature")
				|| type.equalsIgnoreCase("Blood Pressure")) {
			return type;
		}
		//If type was not recognized return null
		return null;
	}

	/**
	 * toString method to print the String representation of the Reading object.
	 *
	 * @param dateFormat the date format
	 * @return the string
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
	 * Getter for readingId.
	 *
	 * @return readingId of the patient
	 */
	public String getReadingId() {
		return readingId;
	}

	/**
	 * Getter for type.
	 *
	 * @return type of reading of the patient
	 */
	public String getType() {
		return type;
	}

	/**
	 * Getter for value of every type.
	 *
	 * @return value of the reading of the patient
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Getter for date.
	 *
	 * @return date of the reading of the patient
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the clinic.
	 *
	 * @return the clinic
	 */
	public Clinic getClinic() {
		if (clinic == null) {
			return new Clinic("Unknown", "Unkown");
		}
		return clinic;
	}

	/**
	 * toString method to print the String representation of the Reading object.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String clinicName = this.clinic.getName();
		String clinicId = this.clinic.getId();
		return	"ReadingId= '" + readingId + '\'' +
				", Type= '" + type + '\'' +
				", Value= '" + value + '\'' +
				", Date= " + date +
				", ClinicName= " + clinicName +
				", ClinicId= " + clinicId;
	}
}