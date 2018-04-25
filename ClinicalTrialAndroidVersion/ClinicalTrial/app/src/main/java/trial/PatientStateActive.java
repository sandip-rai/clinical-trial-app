package trial;

import java.util.Date;

public class PatientStateActive extends PatientState {

    public PatientStateActive(Patient p) {
        super(p);
        stateName = "Active";
    }

    @Override
    public String toString() {
        return stateName;
    }
}
