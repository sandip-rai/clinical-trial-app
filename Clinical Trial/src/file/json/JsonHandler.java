package file.json;
import java.io.*;
import java.util.*;
import com.google.gson.*;
import file.Handler;
import trial.*;


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
		boolean addPatients = clinicalTrial.getSettings().jsonAddUnknownPatients();
		boolean addReadings = clinicalTrial.getSettings().jsonAddUnknownReadings();
		Gson gson = new GsonBuilder().serializeNulls().create();
		try (Reader fileReader = new FileReader(path)) {
			// Create PatientReadingsJson object which creates an AarrayList
			FileReadings readingList = gson.fromJson(fileReader, FileReadings.class);
			addClinicToTrial(readingList.patient_readings);
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
	 * Gets the json readings.
	 *
	 * @return the json readings
	 */
	private ArrayList<FileReading> getJsonReadings() {
		ArrayList<Patient> allPatients = clinicalTrial.getAllPatients();
		ArrayList<FileReading> allReadings = new ArrayList<FileReading>();
		for (Patient patient : allPatients) {
			ArrayList<Reading> patientReadings = patient.getReadings();
			for (Reading reading : patientReadings) {
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
				FileReading readingJson = new FileReading(patient_id, reading_type, reading_id, reading_value,
						reading_date, clinic_id, clinic_name);
				allReadings.add(readingJson);
			}
		}
		return allReadings;
	}

	/**
	 * Save state.
	 *
	 * @return true, if successful
	 */
	public boolean saveState() {
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

	/**
	 * Load state.
	 *
	 * @return the clinical trial
	 */
	public ClinicalTrial loadState() {
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
