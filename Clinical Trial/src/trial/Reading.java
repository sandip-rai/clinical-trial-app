package trial;

import java.util.Date;

/**
 * Reading class creates objects of readings for the Patient objects. Need to
 * add the clinic section
 */

public class Reading {

	// Initializing parameters
	private String readingId;
	private String type;
	private double value;
	private String bpValue;
	private Date date;
	private String clinicId;
	private Clinic clinic;

	// Constructor for every reading value except of blood_pressure type
	public Reading(String readingId, String type, double value, Date date, Clinic clinic) {
		this.readingId = readingId;
		this.type = type;
		this.value = value;
		this.date = date;
	}

	// Constructor for the reading value of blood_pressure type
	public Reading(String readingId, String type, String bpValue, Date date, Clinic clinic) {
		this.readingId = readingId;
		this.type = type;
		this.bpValue = bpValue;
		this.date = date;
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
	 * Getter for value of every type except blood_pressure
	 * 
	 * @return value of the reading of the patient
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Getter for reading value of blood_pressure type
	 * 
	 * @return value of the blood_pressure reading of the patient
	 */
	public String getBpValue() {
		return bpValue;
	}

	/**
	 * Getter for date
	 * 
	 * @return date of the reading of the patient
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * toString method to print the String representation of the Reading object
	 */
	public String toString() {
		String string = "Reading ID: " + readingId + "\n" + "Type: " + type + "\n";
		if (bpValue == null) { // for every value except blood_pressure
			string = string + "Value: " + value + "\n";
		} else {// for only blood_pressure value
			string = string + "Value: " + bpValue + "\n";
		}
		string = string + "Date: " + date + "\n";
		if (clinic != null) {
			string = string + "Clinic: " + clinic.toString() + "\n\n";
		}else {
			string = string + "Clinic: Unkown\n\n";
		}
		return string;
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