package trial;

import java.util.ArrayList;
import java.util.Date;

public class PatientStateFailed extends PatientState {

    private String stateName = "Failed";

    public PatientStateFailed(Patient p){
        super(p);
    }

    @Override
    public Boolean addReading(String readingId, String type, String value, Date date, Clinic clinic) {
        return false;
    }

    @Override
    public ArrayList<Reading> getReadings() {
        return null;
    }

    @Override
    public String toString() {
        return stateName;
    }
}
