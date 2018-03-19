package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trial.ClinicalTrial;
import views.AddPatientView;

//class for buttonAddPatient to perform actionPerformed(ActionEvent e)
public class ButtonAddPatientListener implements ActionListener {
	AddPatientView addPatientView;
	
	//constructor
	public ButtonAddPatientListener(AddPatientView addPatientView){
		this.addPatientView = addPatientView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tempId = addPatientView.getInputText().getText(); // assign the PatientId
        // that user inputs
        if (tempId == null || tempId.equals("")) {// make sure the user
            // has entered a
            // patient ID
        	addPatientView.getAddPatientState().setText("Please enter a patient ID");
        } else if (ClinicalTrial.addPatient(tempId)) {
            ClinicalTrial.findPatient(tempId).setActive(true);
            addPatientView.getAddPatientState().setText("Added! Ready for next patient. ");
            addPatientView.getInputText().setText("");
        } else {
        	addPatientView.getAddPatientState().setText("That patient is already in this trial.");
        }
	}

}
