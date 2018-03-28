package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import gui.GuiController;
import trial.Patient;

/**
 * The Class CheckBoxPatientIsActive.
 */
public class CheckBoxPatientIsActive implements ItemListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new check box patient is active.
	 *
	 * @param guiController the gui controller
	 */
	public CheckBoxPatientIsActive(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		//Find the currently selected patient
		Patient patient = (Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem();
		//If a patient wasw found
		if ( patient != null) {
			//If the box was checked activate the Patient
			if (e.getStateChange() == 1) {
				patient.setActive(true);
			}else {
				//If the box was unchecked set the patient to inactive
				patient.setActive(false);			
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select a valid patient");
		}
	}		

}