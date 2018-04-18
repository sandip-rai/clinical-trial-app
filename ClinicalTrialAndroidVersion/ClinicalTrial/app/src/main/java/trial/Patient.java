package trial;
/**
 * Patient class contains patient Id, a boolean active for being in the trial, and an arraylist of corresponding readings.
 */

import java.util.ArrayList;
import java.util.Date;

/**
 * The Class Patient.
 */
public class Patient {
	
	/** The patient id. */
        // Initialization
        private String patientId;

        /** The active. */
        private PatientState state = new PatientStateActive(this);

        /** The readings. */
        private ArrayList<Reading> readings;

        /** The reading count. */
        private int readingCount = 1;

        /**
         * Class Constructor specifying the patient Id.
         *
         * @param patientId            the id of the patient
         */
	    public Patient(String patientId) {
            this.patientId = patientId;
            this.readings = new ArrayList<Reading>(); // Creates an arrayList of reading
        }

        public int getReadingCount() {
            return readingCount;
        }

        public String getPatientId(){
	        return patientId;
        }

        public ArrayList<Reading> getReadings() {
            return readings;
        }

        public PatientState getState(){
            return state;
        }

        protected void changeState(PatientState newState){
            state = newState;
        }

        public void setState(PatientState newState){
            state.setState(newState);
        }

        public Boolean addReading(String readingId, String type, String value, Date d, Clinic c){
	        return state.addReading(readingId, type, value, d, c);
        }

        /**
         * @param dateFormat the date format
         * @return the string
         */
        public String toString(String dateFormat) {
            String string = new String();
            for (Reading reading : readings) {
                string += reading.toString(dateFormat);
            }
            return string;
        }

        public String toString(){
	        return patientId;
        }
}
