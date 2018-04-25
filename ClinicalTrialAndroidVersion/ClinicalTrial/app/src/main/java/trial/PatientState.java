package trial;

import java.util.ArrayList;
import java.util.Date;

public class PatientState {

    private String patientId;
    protected String stateName;
    private ArrayList<Reading> readings;
    private int readingCount = 1;
    private Patient patient = null;

    //constructor
    public PatientState(Patient p){
        this.patient = p;
        this.readings = p.getReadings();
        this.patientId = p.getPatientId();
        this.readingCount = p.getReadingCount();
    }

    public Patient getPatient() {
        return patient;
    }

    /**
     * Getter for patient Id.
     *
     * @return patientId
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * Getter for patient's readings.
     *
     * @return an arrayList of readings
     */
    public ArrayList<Reading> getReadings() { return readings; }

    /**
     * Gets the reading uid.
     *
     * @return the reading uid
     */
    private String getReadingUid() {
        String Uid = patientId + readingCount++;
        for (Reading reading : readings) {
            if (Uid.equals(reading.getReadingId())) {
                return getReadingUid();
            }
        }

        return Uid;
    }

    /**
     * Adds the new readings to the Patient object readings ArrayList if the patient
     * is active i.e on trial
     *
     * @param readingId            the reading Id number
     * @param type            the reading type
     * @param value            the reading value
     * @param date            the date of reading
     * @param clinic the clinic
     * @return the boolean
     */
    public Boolean addReading(String readingId, String type, String value, Date date, Clinic clinic) {
            try {
                if (readingId == null || readingId.equals("")) {
                    readingId = getReadingUid();
                } else {
                    // check for duplicate readings
                    for (Reading reading : readings) {
                        if (readingId.equals(reading.getReadingId())) {
                            return false;
                        }
                    }
                }
                Reading reading = new Reading(readingId, type, value, date, clinic); // create reading object
                readings.add(reading); // add the new reading to the reading ArrayList
                return true;
            } catch (IllegalArgumentException e) {
            }
            return false;
    }

    /**
     * Sets state
     *
     * @param newState
     */
    public void setState(PatientState newState) {
        if(newState.toString().equals("Active") || newState.toString().equals("Withdrawn")
                || newState.toString().equals("Failed")|| newState.toString().equals("Completed")) {
            this.patient.changeState(newState);
        }
        else
            System.out.println("Invalid entry");
    }

    /**
     * Shows just the patientState;
     * @return the patientState of the Patient object
     */
    public String toString(){
        return stateName;
    }
}
