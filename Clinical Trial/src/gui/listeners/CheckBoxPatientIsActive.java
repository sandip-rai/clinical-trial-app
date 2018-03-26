package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import gui.GuiController;
import trial.Patient;

public class CheckBoxPatientIsActive implements ItemListener{
	GuiController guiController;
	
	public CheckBoxPatientIsActive(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Patient patient = (Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem();
		if ( patient != null) {
			if (e.getStateChange() == 1) {
				patient.setActive(true);
			}else {
				patient.setActive(false);			
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select a valid patient");
		}
	}		

}