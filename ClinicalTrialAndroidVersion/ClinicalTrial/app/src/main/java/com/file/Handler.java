package com.file;

import java.util.ArrayList;
import java.util.Date;
import trial.*;

/**
 * The Class Handler.
 */
public class Handler {

	/** The clinical trial. */
	protected ClinicalTrial clinicalTrial;

	/**
	 * Used by child classes to temporarily store Clinic and Reading data.
	 */
	public class FileReading {

		/** The patient id. */
		private String patient_id;

		/** The reading type. */
		private String reading_type;

		/** The reading id. */
		private String reading_id;

		/** The reading value. */
		private String reading_value;

		/** The reading date. */
		private String reading_date;

		/** The clinic id. */
		private String clinic_id;

		/** The clinic name. */
		private String clinic_name;

		/**
		 * Instantiates a new file reading.
		 *
		 * @param patient_id
		 *            the patient id
		 * @param reading_type
		 *            the reading type
		 * @param reading_id
		 *            the reading id
		 * @param reading_value
		 *            the reading value
		 * @param reading_date
		 *            the reading date
		 * @param clinic_id
		 *            the clinic id
		 * @param clinic_name
		 *            the clinic name
		 */
		public FileReading(String patient_id, String reading_type, String reading_id, String reading_value,
				String reading_date, String clinic_id, String clinic_name) {
			this.patient_id = patient_id;
			this.reading_type = reading_type;
			this.reading_id = reading_id;
			this.reading_value = reading_value;
			this.reading_date = reading_date;
			this.clinic_id = clinic_id;
			this.clinic_name = clinic_name;
		}
	}
	
	/*
	 * Getter for clinical trial, for testing
	 */
	public ClinicalTrial getClinicalTrial() {
		return clinicalTrial;
	}

	/**
	 * Used by child classes to temporarily store Clinic and Reading data.
	 */
	public class FileReadings {

		/** The patient readings. */
		public ArrayList<FileReading> patient_readings;

		/**
		 * Instantiates a new file readings.
		 *
		 * @param patient_readings
		 *            the patient readings
		 */
		public FileReadings(ArrayList<FileReading> patient_readings) {
			this.patient_readings = patient_readings;
		}
	}

	/**
	 * Adds the clinic to trial if enabled in system settings.
	 *
	 * @param readings the readings
	 */
	public void addClinicToTrial(ArrayList<FileReading> readings) {
		//check system settings
		if (clinicalTrial.getSettings().addUnknownClinics()) {
			for (FileReading reading : readings) {
				//get clinic info
				String clinicName = reading.clinic_name;
				String clinicId = reading.clinic_id;
				//search clinicalTrial for the clinic
				Clinic clinic = clinicalTrial.findClinic(clinicId);
				//if clinic is not already in the trial add it
				if (clinic == null) {
					clinic = clinicalTrial.addClinic(clinicName, clinicId);
				}
			}
		}
	}

	/**
	 * Takes in an ArrayList of patient readings. Readings are validated and added
	 * to the trial. All readings are set to active or inactive based on the
	 * parameter
	 *
	 * @param readings
	 *            the readings
	 * @param active
	 *            the active
	 */
	public void addPatientsToTrial(ArrayList<FileReading> readings, boolean active) {
		// Loop threw all readings in the readings array
		for (FileReading reading : readings) {
			// Validate the reading and ensure that the patient is not already in the trial
			if (validReading(reading) && clinicalTrial.findPatient(reading.patient_id) == null) {
				// Add the patient to the trial
				Patient patient = new Patient(reading.patient_id);
				//TODO: set patient state
				//patient.setActive(active);
				clinicalTrial.getAllPatients().add(patient);
			}
		}
	}

	/**
	 * Adds a reading to a patient if they are in the trial.
	 *
	 * @param readings
	 *            the readings
	 */
	public void AddReadingToPatient(ArrayList<FileReading> readings) {
		// Loop threw all readings in the readings array
		for (FileReading reading : readings) {
			// ensure that reading is valid
			if (validReading(reading)) {
				// set reading variables
				String readingId = reading.reading_id;
				String type = reading.reading_type;
				Date date = null;
				// ensure that a date is present and turn it into a Date object
				if (reading.reading_date != null) {
					date = new Date(Long.parseLong(reading.reading_date));
				}
				String clinicId = reading.clinic_id;
				Clinic clinic = clinicalTrial.findClinic(clinicId);
				String value = reading.reading_value;
				// ensure patient is in the trial
				Patient patient = clinicalTrial.findPatient(reading.patient_id); // Get a patient from the arrayList
				if (patient != null) {
					patient.addReading(readingId, type, value, date, clinic);
				}
			}
		}
	}

	/**
	 * Validates readings. A reading is valid if and only if it has a type, value,
	 * patient, and clinic ID. Clinic id is only an exception if the
	 *
	 * @param reading
	 *            the reading
	 * @return true, if successful
	 */
	private boolean validReading(FileReading reading) {
		// get required fields
		String type = reading.reading_type;
		String value = reading.reading_value;
		String patientId = reading.patient_id;
		String clinicId = reading.clinic_id;
		Clinic clinic = clinicalTrial.findClinic(clinicId);
		boolean addClinic = clinicalTrial.getSettings().addUnknownClinics();
		//if required fields are present return true
		if (type != null && value != null && patientId != null && (clinic != null || addClinic)) {
			return true;
		} else {
			//if required fields are not present return false
			return false;
		}
	}
}