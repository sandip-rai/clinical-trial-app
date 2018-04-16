package trial;

/**
 * ClinicalTrial class has the arrayList of patients present in the trial.
 */
import java.util.ArrayList;

/**
 * The Class ClinicalTrial.
 */
public class ClinicalTrial {

	/** The all patients. */
	// Creating an arrayList to hold the Patients in the trial
	private ArrayList<Patient> allPatients = new ArrayList<Patient>();
	
	/** The all clinics. */
	private ArrayList<Clinic> allClinics = new ArrayList<Clinic>();// array to hold every created clinic object
	
	/** The settings. */
	private SystemSettings settings = new SystemSettings();
	
	/** The clinic count. */
	private int clinicCount = 1;

	/**
	 * ClinicalTrial Getter for the allPatients arrayList.
	 *
	 * @return allPatients the arrayList holding the Patients in the trial
	 */

	public ArrayList<Patient> getAllPatients() {
		return allPatients;
	}

	/**
	 * findPatient finds if a patient is currently in a trial or not.
	 *
	 * @param patientId            the Id of the patient
	 * @return patient the patient if it exists in the allPatients arrayList
	 */
	public Patient findPatient(String patientId) {
		for (Patient patient : allPatients) { // loop through the allPatients arrayList
			if (patientId.equals(patient.getPatientId())) {
				return patient; // if patient exists in the trial
			}
		}
		return null; // if patient doesn't exist in the trial
	}

	/**
	 * Adds a Patient to the Clinical trial if that patient has not yet been added.
	 * 
	 * @param patientId
	 *            the Id of the patient
	 * @return boolean true if patient was added. False if another patient with the
	 *         same ID was found
	 */
	public Boolean addPatient(String patientId) {
		if (findPatient(patientId) == null) {
			// if no patient was found then add a new patient to the trial
			Patient patient = new Patient(patientId);
			allPatients.add(patient);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * finds if a clinic exists in the array list of clinics.
	 *
	 * @param id the id
	 * @return clinic object if it exists in the allPatients arrayList else null is
	 *         returned
	 */
	public Clinic findClinic(String id) {
		if (id == null) {
			return null;
		} else {
			for (Clinic clinic : allClinics) {
				boolean idMatches = id.equals(clinic.getId());
				if (idMatches) {
					return clinic;
				}
			}
		}
		return null;
	}

	/**
	 * Generate unique id.
	 *
	 * @return the string
	 */
	public String generateUniqueId() {
		String id = "Clinic" + clinicCount++;
		if (idIsUnique(id)) {
			return id;
		} else
			return generateUniqueId();
	}

	/**
	 * Id is unique.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean idIsUnique(String id) {
		if (id == null) {
			return false;
		} else {
			for (Clinic clinic : allClinics) {
				if (id.equals(clinic.getId())) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * method that adds a new clinic to the list of clinics.
	 *
	 * @param name the name
	 * @param id the id
	 * @return true if the clinic is added or return false if the clinic already
	 *         exists in the list
	 */
	public Clinic addClinic(String name, String id) {	
		Clinic clinic;
		//Check name and id for null, an empty string or unknown
		name = getValidString(name);
		id = getValidString(id);
		boolean hasName = !(name == null);
		boolean hasId = !(name == null);
		boolean InTrial = !(findClinic(id) == null);
		//If there is no name and no ID add a empty clinic but do not add it to the trial
		if (!hasName && !hasId){
			return clinic = new Clinic(null, null);
		} else if (hasName && !hasId) {
			//If there is a name but no id generate a unique ID
			id = generateUniqueId();
			clinic = new Clinic(name, id);
			allClinics.add(clinic);
			return clinic;
		}	else if (!InTrial) {
			//If the clinic is not already in the trial add it to the trial 
			clinic = new Clinic(name, id);
			allClinics.add(clinic);
			return clinic;
		} else {
			//if clinic is already in the trial return null
			return null;
		}
	}
	
	/**
	 * Gets the valid string.
	 *
	 * @param string the string
	 * @return the valid string
	 */
	private String getValidString(String string) {
		//Check string for null, an empty string or unknown
		boolean valid = !(string == null || string.equals("") || string.toLowerCase().equals("unknown"));
		if (valid) {
			return string;
		}
		return null;
	}

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public SystemSettings getSettings() {
		return settings;
	}
	
	/**
	 * Gets the all clinics.
	 *
	 * @return the all clinics
	 */
	public ArrayList<Clinic> getAllClinics(){
		return allClinics;
	}

}
