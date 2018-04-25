package trial;

import java.util.Date;

public class PatientStateCompleted extends PatientState {
    public PatientStateCompleted(Patient p){
        super(p);
        stateName = "Completed";
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
