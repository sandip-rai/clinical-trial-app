package trial;

import java.util.Date;

public class PatientStateCompleted extends PatientState {

    String stateName = "Completed";

    public PatientStateCompleted(Patient p){
        super(p);
    }

    @Override
    public Boolean addReading(String readingId, String type, String value, Date date, Clinic clinic) {
        return false;
    }

    @Override
    public String toString() {
        return stateName;
    }
}
