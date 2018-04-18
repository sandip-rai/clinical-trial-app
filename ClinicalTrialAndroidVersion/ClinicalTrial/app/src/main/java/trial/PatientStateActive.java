package trial;

import java.util.Date;

public class PatientStateActive extends PatientState {

    String stateName = "Active";

    public PatientStateActive(Patient p) {
        super(p);
    }

    @Override
    public String toString() {
        return stateName;
    }
}
