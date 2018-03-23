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

	/**
	 * readJsonFile initializes the FileReader, creates a Gson object, and creates
	 * PatientReadingsJson object. It gets called from uploadFile method of GUI
	 * class and then it passes PatientReadingsJson object patient readings to
	 * AddReadingToPatient method.
	 * 
	 * @return true if file is successfully read and contents are added
	 *         appropriately
	 */

	public boolean readFile(String filePath, boolean addToTrial, boolean activate) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		try (Reader fileReader = new FileReader(filePath)) {
			// Create PatientReadingsJson object which creates an AarrayList
			FileReadings readingList = gson.fromJson(fileReader, FileReadings.class);
			addPatientsToTrial(readingList.patient_readings);
			// Add readings from input file to Patient's readings ArrayList
			AddReadingToPatient(readingList.patient_readings);
			return true; // If file has been read and contents added
		} catch (IOException e) { // Catch if fileLocation doesn't exist
			e.printStackTrace();
		}
		return false;
	}

	public boolean WriteState() {
		Writer writer;
		try {
			writer = new FileWriter("state.json");
			Gson gson = new GsonBuilder().create();
			State state = new State();
			gson.toJson(state, writer);
			writer.close();// If file is written and writer closed
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;// If exception occurs
		}
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
			e.printStackTrace();
			return false; // If exception occurs
		}
	}

	private ArrayList<FileReading> getJsonReadings() {
		ArrayList<Patient> allPatients = ClinicalTrial.getAllPatients();
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

}
