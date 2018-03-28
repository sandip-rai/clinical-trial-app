package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;

/**
 * The listener interface for receiving buttonAddPatient events.
 * The class that is interested in processing a buttonAddPatient
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonAddPatientListener<code> method. When
 * the buttonAddPatient event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonAddPatientEvent
 */
//class for buttonAddPatient to perform actionPerformed(ActionEvent e)
public class ButtonAddPatientListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;

	/**
	 * Instantiates a new button add patient listener.
	 *
	 * @param guiController the gui controller
	 */
	// constructor
	public ButtonAddPatientListener(GuiController guiController) {
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// assign the PatientId that user inputs
		String tempId = guiController.getAddPatientView().getInputText().getText(); 
		if (tempId == null || tempId.equals("")) {// make sure the user has entered a  patient ID
			guiController.getAddPatientView().getAddPatientState().setText("Please enter a patient ID");
		} else if (guiController.getClinicalTrial().addPatient(tempId)) {
			guiController.getClinicalTrial().findPatient(tempId).setActive(true);
			guiController.getAddPatientView().getAddPatientState().setText("Added! Ready for next patient. ");
			guiController.getAddPatientView().getInputText().setText("");
		} else {
			guiController.getAddPatientView().getAddPatientState().setText("That patient is already in this trial.");
		}
	}

}
