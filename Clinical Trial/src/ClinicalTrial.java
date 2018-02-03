import java.util.ArrayList;

public class ClinicalTrial {
	private static ArrayList<Patient> allPatients = new ArrayList<Patient>();

	protected static ArrayList<Patient> getAllPatients() {
		return allPatients;
	}

	protected static Patient findPatient(String patientId){
		for (Patient patient : allPatients) {
			if (patientId.equals(patient.getPatientId())) {
				return patient;
			}
		}
		return null;
	}
}
