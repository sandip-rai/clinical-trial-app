package trial;
/**
 * ClinicalTrial class has the arrayList of patients present in the trial.
 */
//11111111111111111111111
import java.util.ArrayList;

public class ClinicalTrial {
	//Creating an arrayList to hold the Patients in the trial
	private static ArrayList<Patient> allPatients = new ArrayList<Patient>();
	private ArrayList<Clinic> clinicList = new ArrayList<Clinic>();//array to hold every created clinic object
	
	/**ClinicalTrial
	 * Getter for the allPatients arrayList
	 * @return allPatients the arrayList holding the Patients in the trial
	 */
	
	public static ArrayList<Patient> getAllPatients() {
		return allPatients;
	}

	/**
	 * findPatient finds if a patient is currently in a trial or not
	 * @param patientId the Id of the patient
	 * @return patient the patient if it exists in the allPatients arrayList
	 */
	public static Patient findPatient(String patientId){
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
	public static Boolean addPatient(String patientId){
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
	
	/** added by Oussama
	 * 
	 * @param Clinicid
	 * @return
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
	 * added by oussama
	 * method that adds a new clinic to the list of clinics
	 * 
	 * @param clinicName
	 * @param clinicid
	 * @return
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
	
}
