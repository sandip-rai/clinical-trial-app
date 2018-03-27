package file;

import java.util.ArrayList;
import java.util.Date;

import trial.Clinic;
import trial.ClinicalTrial;
import trial.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class FileHandler.
 */
public class Handler {
	protected ClinicalTrial clinicalTrial;

	/**
	 * ReadingJson class handles the objects with the specified parameters that are
	 * present in the input Json File.
	 *
	 */
	public class FileReading {
		private String patient_id;
		private String reading_type;
		private String reading_id;
		private String reading_value;
		private String reading_date;
		private String clinic_id;
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

	/**
	 * PatientReadingsJson stores the ReadingJson class objects into an ArrayList.
	 */
	public class FileReadings {

		/** The patient readings. */
		// Arraylist to hold ReadingJson class objects
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
	 * Adds the patients to trial.
	 *
	 * @param readings
	 *            the readings
	 * @param active
	 *            the active
	 */
	public void addPatientsToTrial(ArrayList<FileReading> readings, boolean active) {
		for (FileReading reading : readings) {
			if (validReading(reading) && clinicalTrial.findPatient(reading.patient_id) == null) {
				Patient patient = new Patient(reading.patient_id);
				patient.setActive(active);
				clinicalTrial.getAllPatients().add(patient);
			}
		}
	}

	/**
	 * AddReadingToPatient adds the readings from the input file to the Patient's
	 * reading ArrayList.
	 *
	 * @param readings
	 *            the readings of the input file in an ArrayList
	 */
	public void AddReadingToPatient(ArrayList<FileReading> readings) {
		for (FileReading reading : readings) {
			if (validReading(reading)) {
				// set reading variables
				String readingId = reading.reading_id;
				String type = reading.reading_type;
				Date date = null;
				if (reading.reading_date != null) {
					date = new Date(Long.parseLong(reading.reading_date));
				}
				String clinicId = reading.clinic_id;
				Patient patient = clinicalTrial.findPatient(reading.patient_id); // Get a patient from the arrayList
				Clinic clinic = clinicalTrial.findClinic(clinicId);
				String value = reading.reading_value;
				if (patient != null) {
					patient.addReading(readingId, type, value, date, clinic);
				}
			}
		}
	}

	/**
	 * Validate reading.
	 *
	 * @param reading
	 *            from a file
	 * @return true, if reading is valid
	 */
	private boolean validReading(FileReading reading) {
		String type = reading.reading_type;
		String value = reading.reading_value;
		Patient patient = clinicalTrial.findPatient(reading.patient_id);
		String clinicId = reading.clinic_id;
		String clinicName = reading.clinic_name;
		Clinic clinic = clinicalTrial.findClinic(clinicId);
		boolean addClinic = clinicalTrial.getSettings().addUnknownClinics();
		if (clinic == null && addClinic) {
			clinic = clinicalTrial.addClinic(clinicName, clinicId);
		}
		if (type != null || value != null || patient != null || clinic != null) {
			System.out.println("valid");
			return true;
		} else {
			System.out.println("invalid");
			return false;
		}
	}
}
