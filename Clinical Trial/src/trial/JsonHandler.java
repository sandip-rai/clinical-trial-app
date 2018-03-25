package trial;
/**
 * FileHandler class handles the json file reading and writing the output to a new json file.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;
import com.google.gson.*;


public class JsonHandler extends FileHandler {
	private final String SAVE_STATE_PATH = "SaveState.json";
	
	public JsonHandler(ClinicalTrial clinicalTrial){
		this.clinicalTrial = clinicalTrial;
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

	public boolean readFile(String path, boolean addUnkownPatients, boolean addUnknownReadings) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		try (Reader fileReader = new FileReader(path)) {
			// Create PatientReadingsJson object which creates an AarrayList
			FileReadings readingList = gson.fromJson(fileReader, FileReadings.class);
			if (addUnkownPatients) {
				addPatientsToTrial(readingList.patient_readings, addUnknownReadings);
			}
			// Add readings from input file to Patient's readings ArrayList
			AddReadingToPatient(readingList.patient_readings);
			return true; // If file has been read and contents added
		} catch (IOException e) { // Catch if fileLocation doesn't exist
			e.printStackTrace();
		}
		return false;
	}

	public boolean WritePatientReadings(String fileName) {
		try {
			Writer writer = new FileWriter(fileName);
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

	private ArrayList<FileReading> getJsonReadings() {
		ArrayList<Patient> allPatients = clinicalTrial.getAllPatients();
		ArrayList<FileReading> allReadings = new ArrayList<FileReading>();
		for (Patient patient : allPatients) {
			ArrayList<Reading> patientReadings = patient.getReadings();
			for (Reading reading : patientReadings) {
				String patient_id = patient.getPatientId();
				String reading_type = reading.getType();
				String reading_id = reading.getReadingId();
				String reading_date = Long.toString(reading.getDate().getTime());
				String reading_value = new String();
				if (reading_type.equals("blood_press")) {
					reading_value = reading.getBpValue();
				} else {
					reading_value = Double.toString(reading.getValue());
				}
				FileReading readingJson = new FileReading(patient_id, reading_type, reading_id, reading_value,
						reading_date);
				allReadings.add(readingJson);
			}
		}
		return allReadings;
	}
	
	protected boolean saveState() {
		try {
			Writer writer = new FileWriter(SAVE_STATE_PATH);
			Gson gson = new GsonBuilder().create();
			gson.toJson(clinicalTrial, writer);
			writer.close();
			return true; // If file is written and writer closed
		} catch (IOException e) {
			e.printStackTrace();
			return false; // If exception occurs
		}
	}
	
	protected ClinicalTrial loadState() {
		Gson gson = new GsonBuilder().serializeNulls().create();
		try (Reader fileReader = new FileReader(SAVE_STATE_PATH)) {
			// Create PatientReadingsJson object which creates an AarrayList
			ClinicalTrial fileTrial = gson.fromJson(fileReader, ClinicalTrial.class);			
			return fileTrial; // If file has been read return the ClinicalTrial
		} catch (IOException e) { // Catch if fileLocation doesn't exist
			return new ClinicalTrial();
		}		
	}
}
