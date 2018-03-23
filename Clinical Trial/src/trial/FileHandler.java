package trial;

import java.util.ArrayList;
import java.util.Date;


public class FileHandler {	
	
	/**
	 * ReadingJson class handles the objects with the specified parameters that are
	 * present in the input Json File.
	 *
	 */
	protected class FileReading {
		// Initializing parameters
		protected String patient_id;
		protected String reading_type;
		protected String reading_id;
		protected String reading_value;
		protected String reading_date;
		protected String clinic_id, clinic_name;

		FileReading(String patient_id, String reading_type, String reading_id, String reading_value,
				String reading_date) {
			this.patient_id = patient_id;
			this.reading_type = reading_type;
			this.reading_id = reading_id;
			this.reading_value = reading_value;
			this.reading_date = reading_date;
		}
		
		FileReading(String id, String type, String rid, String rval, String rdate, String cid, String cn){
		    patient_id = id;
		    reading_type = type;
		    reading_id = rid;
		    reading_value = rval;
		    reading_date = rdate;
		    clinic_id = cid;
		    clinic_name = cn;
        }
	}

	/**
	 * PatientReadingsJson stores the ReadingJson class objects into an ArrayList
	 *
	 */
	protected class FileReadings {
		// Arraylist to hold ReadingJson class objects
		protected ArrayList<FileReading> patient_readings;
		
		FileReadings(ArrayList<FileReading> patient_readings){
			this.patient_readings = patient_readings;
		}
	}
	
	@SuppressWarnings("unused")
	protected class State {
		private ArrayList<Patient> allPatients = ClinicalTrial.getAllPatients();;
		// private ArrayList<Clinic> allClinics = new ArrayList<Clinic>();
	}
	
	protected void addPatientsToTrial(ArrayList<FileReading> readings) {
		for (FileReading readingJson : readings) {
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
	protected void AddReadingToPatient(ArrayList<FileReading> readings) {
		for (FileReading reading : readings) { // loop through the readings arrayList
			Patient patient = ClinicalTrial.findPatient(reading.patient_id); // Get a patient from the arrayList
			if (patient == null) {
				continue; // Continue if arrayList is empty
			}
			// Grab the readings into each String
			String readingId = reading.reading_id;
			String type = reading.reading_type;
			Date date = new Date(Long.parseLong(reading.reading_date));
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
