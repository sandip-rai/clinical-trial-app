package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;
import trial.ClinicalTrial;
import views.AddPatientView;

//class for buttonAddPatient to perform actionPerformed(ActionEvent e)
public class ButtonAddPatientListener implements ActionListener {
	GuiController guiController;

	// constructor
	public ButtonAddPatientListener(GuiController guiController) {
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tempId = guiController.getAddPatientView().getInputText().getText(); // assign the PatientId
		// that user inputs
		if (tempId == null || tempId.equals("")) {// make sure the user has entered a  patient ID
			guiController.getAddPatientView().getAddPatientState().setText("Please enter a patient ID");
		} else if (ClinicalTrial.addPatient(tempId)) {
			ClinicalTrial.findPatient(tempId).setActive(true);
			guiController.getAddPatientView().getAddPatientState().setText("Added! Ready for next patient. ");
			guiController.getAddPatientView().getInputText().setText("");
		} else {
			guiController.getAddPatientView().getAddPatientState().setText("That patient is already in this trial.");
		}
	}

}
