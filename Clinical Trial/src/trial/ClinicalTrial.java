package trial;
/**
 * ClinicalTrial class has the arrayList of patients present in the trial.
 */
import java.util.ArrayList;

public class ClinicalTrial {
	
	//Creating an arrayList to hold the Patients in the trial
	private ArrayList<Patient> allPatients = new ArrayList<Patient>();
	private ArrayList<Clinic> clinicList = new ArrayList<Clinic>();//array to hold every created clinic object
	private SystemSettings settings = new SystemSettings();
	
	/**ClinicalTrial
	 * Getter for the allPatients arrayList
	 * @return allPatients the arrayList holding the Patients in the trial
	 */
	
	public ArrayList<Patient> getAllPatients() {
		return allPatients;
	}

	/**
	 * findPatient finds if a patient is currently in a trial or not
	 * @param patientId the Id of the patient
	 * @return patient the patient if it exists in the allPatients arrayList
	 */
	public Patient findPatient(String patientId){
		for (Patient patient : allPatients) { //loop through the allPatients arrayList
			if (patientId.equals(patient.getPatientId())) {
				return patient; //if patient exists in the trial
			}
		}
		return null; //if patient doesn't exist in the trial
	}


	
	/**
	 * Adds a Patient to the Clinical trial if that patient has not yet been added.
	 * @param patientId the Id of the patient
	 * @return boolean true if patient was added. False if another patient with the same ID was found
	 */
	public Boolean addPatient(String patientId){
		for (Patient patient : allPatients) { //loop through the allPatients arrayList
			if (patientId.equals(patient.getPatientId())) {
				//a patient with that ID was found return false without adding a new patient
				return false;
			}
		}
		
		
		//if no patient was found then add a new patient to the trial
		Patient patient = new Patient(patientId);
		allPatients.add(patient);
		return true;
	}
	
	/** 
	 * finds if a clinic exists in the array list of clinics
	 * @param Clinicid the id number for the clinic 
	 * @return clinic object if it exists in the allPatients arrayList else null is returned
	 */
	public Clinic findClinic(String ClinicName){
			
	for(Clinic clinic : clinicList){
		if(ClinicName.equals(clinic.getName())){
			return clinic;
			}		
		}
		return null;
	}
	/**
	 * method that adds a new clinic to the list of clinics 
	 * @param clinicName
	 * @param clinicid
	 * @return true if the clinic is added or return false if the clinic already exists in the list 
	 */
	public boolean addClinic(String clinicName , String clinicid){
		
		for(Clinic clinic : clinicList ){
			if(clinicName.equals(clinic.getName())){
				return false;
			}
			
		}
			Clinic clinic = new Clinic(clinicName,clinicid);
			clinicList.add(clinic);
			return true;
		
	}

	public SystemSettings getSettings() {
		return settings;
	}
}
