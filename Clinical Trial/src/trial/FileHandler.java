package trial;
/**
 * FileHandler class handles the json file reading and writing the output to a new json file.
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import javax.swing.JFileChooser;

import com.google.gson.*; //Importing gson library

public class FileHandler {
	/**
	 * ReadingJson class handles the objects with the specified parameters that are
	 * present in the input Json File.
	 *
	 */
	private class ReadingJson {
		// Initializing parameters
		private String patient_id;
		private String reading_type;
		private String reading_id;
		private String reading_value;
		private String reading_date;

		ReadingJson(String patient_id, String reading_type, String reading_id, String reading_value,
				String reading_date) {
			this.patient_id = patient_id;
			this.reading_type = reading_type;
			this.reading_id = reading_id;
			this.reading_value = reading_value;
			this.reading_date = reading_date;
		}
	}

	/**
	 * PatientReadingsJson stores the ReadingJson class objects into an ArrayList
	 *
	 */
	private class PatientReadingsJson {
		// Arraylist to hold ReadingJson class objects
		private ArrayList<ReadingJson> patient_readings;
		
		PatientReadingsJson(ArrayList<ReadingJson> patient_readings){
			this.patient_readings = patient_readings;
		}
	}


	/**
	 * readJsonFile initializes the FileReader, creates a Gson object, and creates
	 * PatientReadingsJson object. It gets called from uploadFile method of GUI
	 * class and then it passes PatientReadingsJson object patient readings to
	 * AddReadingToPatient method.
	 * 
	 * @return true if file is successfully read and contents are added
	 *         appropriately
	 */
	public boolean readJsonFile() {
		
		// Create a Gson object
		JFileChooser fileChooser = new JFileChooser();
		// Open the file selection dialog at the current project directory
		fileChooser.setCurrentDirectory(new File("."));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile(); // Get the file
			String filePath = selectedFile.getAbsolutePath(); // Get the path
			Gson gson = new GsonBuilder().serializeNulls().create();
			// Try a FileReader
			try (Reader fileReader = new FileReader(filePath)) {
				// Create PatientReadingsJson object which creates an AarrayList
				PatientReadingsJson readingList = gson.fromJson(fileReader, PatientReadingsJson.class);
				/*
				 * TODO per phase 1 requirements readings from patients not in trial should be
				 * ignored. if we want to automatically add a patient we should add a check box
				 * to the gui.
				 */
				addPatientsToTrial(readingList.patient_readings);
				// Add readings from input file to Patient's readings ArrayList
				AddReadingToPatient(readingList.patient_readings);
				return true; // If file has been read and contents added
			} catch (IOException e) { // Catch if fileLocation doesn't exist
				e.printStackTrace();
				return false; // If exception occurs
			}
		}
		return false;
	}

	/**
	 * writeJsonFile writes to the output Json File.
	 * 
	 * @return true if file is successfully return and writer is closed
	 */
	public boolean writeJsonFile() {
		String fileName;
		// Print the info of selected patient id
		JFileChooser FileChooser = new JFileChooser(System.getProperty("user.dir"));
		int returnValue = FileChooser.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fileName = FileChooser.getSelectedFile().getAbsolutePath() + ".json";
			try {
				Writer writer = new FileWriter(fileName);
				Gson gson = new GsonBuilder().create();
				ArrayList<ReadingJson> jsonReadings = getJsonReadings();
				PatientReadingsJson allReadings = new PatientReadingsJson(jsonReadings);
				gson.toJson(allReadings, writer);
				writer.close();
				return true; // If file is written and writer closed
			} catch (IOException e) {
				e.printStackTrace();
				return false; // If exception occurs
			}

		}
		return false;

	}
	
	private ArrayList<ReadingJson> getJsonReadings() {
		ArrayList<Patient> allPatients = ClinicalTrial.getAllPatients();
		ArrayList<ReadingJson> allReadings = new ArrayList<ReadingJson>();
		for (Patient patient : allPatients) {
			ArrayList<Reading> patientReadings = patient.getReadings();
			for (Reading reading : patientReadings) {	
				String patient_id = patient.getPatientId();
				String reading_type = reading.getType();
				String reading_id = reading.getReadingId();
				String reading_date = Long.toString(reading.getDate());
				String reading_value = new String();
				if (reading_type.equals("blood_press")) {
					reading_value = reading.getBpValue();	
				}else {
					reading_value = Double.toString(reading.getValue());
				}		
				ReadingJson readingJson = new ReadingJson(patient_id, reading_type, reading_id, reading_value, reading_date);
				allReadings.add(readingJson);
			}
		}
		return allReadings;
	}

	private void addPatientsToTrial(ArrayList<ReadingJson> readings) {
		for (ReadingJson readingJson : readings) {
			if (ClinicalTrial.findPatient(readingJson.patient_id) == null) {
				Patient patient = new Patient(readingJson.patient_id);
				ClinicalTrial.getAllPatients().add(patient);
			}

		}
	}

	/**
	 * AddReadingToPatient adds the readings from the input file to the Patient's
	 * reading ArrayList
	 * 
	 * @param readings
	 *            the readings of the input file in an ArrayList
	 */
	private void AddReadingToPatient(ArrayList<ReadingJson> readings) {
		for (ReadingJson reading : readings) { // loop through the readings arrayList
			Patient patient = ClinicalTrial.findPatient(reading.patient_id); // Get a patient from the arrayList
			if (patient == null) {
				continue; // Continue if arrayList is empty
			}
			// Grab the readings into each String
			String readingId = reading.reading_id;
			String type = reading.reading_type;
			long date = Long.parseLong(reading.reading_date);
			try { // Try for every reading value except blood_pressure type
				double value = Integer.parseInt(reading.reading_value);
				patient.addReading(readingId, type, value, date);
			} catch (java.lang.NumberFormatException e) { // Do this for reading value if the reading type is of
															// blood_pressure
				String value = reading.reading_value; // blood_pressure reading value is of String type
				patient.addReading(readingId, type, value, date);
			}
		}
	}

}
