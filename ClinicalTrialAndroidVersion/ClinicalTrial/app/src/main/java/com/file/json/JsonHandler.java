package com.file.json;
import java.io.*;
import java.util.*;
import com.file.Handler;
import trial.*;
import com.google.gson.*;

// TODO: Auto-generated Javadoc
/**
 * The Class JsonHandler.
 */
public class JsonHandler extends Handler {	
	/** The save state path. */
	private final String SAVE_STATE_PATH = "SaveState.json";

	/**
	 * Instantiates a new json handler.
	 *
	 * @param clinicalTrial the clinical trial
	 */
	public JsonHandler(ClinicalTrial clinicalTrial) {
		this.clinicalTrial = clinicalTrial;
	}

	/**
	 * Read file.
	 *
	 * @param path the path
	 * @return true, if successful
	 */
	public boolean readFile(String path) {
		//Decide how to handle unknown patients and readings based on system settings
		boolean addPatients = clinicalTrial.getSettings().jsonAddUnknownPatients();
		boolean addReadings = clinicalTrial.getSettings().jsonAddUnknownReadings();
		//instantiate a new Gson object to read the file
		Gson gson = new GsonBuilder().serializeNulls().create();
		//get the file path from the user 
		try (Reader fileReader = new FileReader(path)) {
			// Instantiate FIleReadings object from the file using gson
			FileReadings readingList = gson.fromJson(fileReader, FileReadings.class);
			//Attempt to add the clinics to the trial
			addClinicToTrial(readingList.patient_readings);
			//If system settings are to add unknown patients attempt to add the patients to the trial
			if (addPatients) {
				addPatientsToTrial(readingList.patient_readings, addReadings);
			}
			// Add readings from input file to Patient's readings ArrayList
			AddReadingToPatient(readingList.patient_readings);
			// If file has been read and contents added
			return true; 
		} catch (IOException e) { 
			// Catch if fileLocation doesn't exist
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Write patient readings.
	 *
	 * @param fileName the file name
	 * @return true, if successful
	 */
	public boolean WritePatientReadings(String fileName) {
		try {
			Writer writer = new FileWriter(fileName);
			//Instantiate a new Gson object
			Gson gson = new GsonBuilder().create();
			ArrayList<FileReading> jsonReadings = getJsonReadings();
			FileReadings allReadings = new FileReadings(jsonReadings);
			gson.toJson(allReadings, writer);
			writer.close();
			return true; // If file is written and writer closed
		} catch (IOException e) {
			return false; // If exception occurs
		}
	}

	/**
	 * Converts all Patients in the current trial to an array list of FileReadings
	 *
	 * @return the FileReadings
	 * 
	 */
	private ArrayList<FileReading> getJsonReadings() {
		//Get the patients in the ClinicalTrial
		ArrayList<Patient> allPatients = clinicalTrial.getAllPatients();
		//Instantiate an Array list of FileReadings to hold the new FileReading objects
		ArrayList<FileReading> allReadings = new ArrayList<FileReading>();
		//Loop threw the ClinicalTrial Patients
		for (Patient patient : allPatients) {
			//get the readings for the patient
			ArrayList<Reading> patientReadings = patient.getReadings();
			//loop threw each patients readings
			for (Reading reading : patientReadings) {
				//set file reading variables from the reading and patient
				String patient_id = patient.getPatientId();
				String reading_type = reading.getType();
				String reading_id = reading.getReadingId();
				String reading_date = null;
				if (reading.getDate() != null) {
					reading_date = Long.toString(reading.getDate().getTime());
				}
				String reading_value = reading.getValue();
				String clinic_id = reading.getClinic().getId();
				String clinic_name = reading.getClinic().getName();
				//Create a new file reading
				FileReading readingJson = new FileReading(patient_id, reading_type, reading_id, reading_value,
						reading_date, clinic_id, clinic_name);
				//Store the FileReading
				allReadings.add(readingJson);
			}
		}
		return allReadings;
	}

	/**
	 * saves current clinical trial that contains all readings,
	 * patients, clinics, and settings.
	 *
	 * @return true, if successful
	 */
	public boolean saveState() {
		try {
			//write a save file to the SAVE_STATE_PATH
			Writer writer = new FileWriter(SAVE_STATE_PATH);
			Gson gson = new GsonBuilder().create();
			//write the current ClinicalTrial
			gson.toJson(clinicalTrial, writer);
			writer.close();
			// If file is written return true
			return true; 
		} catch (IOException e) {
			e.printStackTrace();
			return false; // If exception occurs
		}
	}

	/**
	 * Load a clinical trial from the save file.
	 *
	 * @return the clinical trial
	 */
	public ClinicalTrial loadState() {
		Gson gson = new GsonBuilder().serializeNulls().create();
		try (Reader fileReader = new FileReader(SAVE_STATE_PATH)) {
			// Create PatientReadingsJson object which creates an AarrayList
			ClinicalTrial fileTrial = gson.fromJson(fileReader, ClinicalTrial.class);
			// If file has been read return the ClinicalTrial
			return fileTrial; 
		} catch (IOException e) { 
			//Create a new clinical trial if file could not be read
			return new ClinicalTrial();
		}
	}
}
