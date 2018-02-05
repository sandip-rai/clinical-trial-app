/**
 * Patient class contains patient Id, a boolean active for being in the trial, and an arraylist of corresponding readings.
 */

import java.util.ArrayList;

public class Patient {
	//Initialization
	private String patientId;
	private boolean active;
	private ArrayList<Reading> readings;

	/**
	 * Class Constructor specifying the patient Id
	 * @param patientId the id of the patient
	 */
	protected Patient(String patientId) {
		this.patientId = patientId;
		this.setActive(true); //Needs to be false as no patient is in the trial at first; This will be set to true once a patient enters a trial
		this.readings = new ArrayList<Reading>(); //Creates an arrayList of reading 
	}

	/**
	 * Getter for patient Id
	 * @return patientId
	 */
	protected String getPatientId() {
		return patientId;
	}

	/**
	 * Getter for patient's readings
	 * @return an arrayList of readings
	 */
	protected ArrayList<Reading> getReadings() {
		return readings;
	}

	/**
	 * Creates a reading object for every reading type except the blood_pressure
	 * @param readingId the reading Id number
	 * @param type the reading type except blood_pressure
	 * @param value the reading value number
	 * @param date the date when reading was taken
	 */
	protected void addReading(String readingId, String type, double value, long date) {
		if (active) {
			Reading reading = new Reading(readingId, type, value, date);
			readings.add(reading);	
		}
	}

	/**
	 * Creates a reading object for only the blood_pressure reading type
	 * @param readingId the reading Id number
	 * @param type the blood_pressure reading type
	 * @param value the reading value number
	 * @param date the date when reading was taken
	 */
	protected void addReading(String readingId, String type, String bpValue, long date) {
		if (active) {
			Reading reading = new Reading(readingId, type, bpValue, date);
			readings.add(reading);	
		}
	}

	/**
	 * Returns patient's active boolean value
	 * @return active the boolean to show if patient is in trial
	 */
	protected boolean isActive() {
		return active;
	}

	/**
	 * Sets true if patient is in trial
	 * @param active the boolean to show if patient is in trial
	 */
	protected void setActive(boolean active) {
		this.active = active;
	}

}