package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.GuiController;
import trial.ClinicalTrial;

public class ButtonShowInfoListener implements ActionListener{
GuiController guiController; //Initialize
	
	/**
	 * Constructor 
	 * @param guiController the controller of the GUI components
	 */
	public ButtonShowInfoListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		try { // Handle the exception if no patient is selected to
			// resume the trial.
			
			guiController.getMainMenuView().getFrame().dispose();
			guiController.getAddPatientView().getFrame().dispose();
			guiController.getManageFileView().getFrame().dispose();
			guiController.getDisplayPatientListView().getFrame().dispose();
			guiController.getDisplayPatientInfoView().getFrame().dispose();
			
			//guiController.getDisplayPatientInfoView().setupFrame();
			
			
			guiController.getDisplayPatientInfoView().setSelectedPatient((
				ClinicalTrial.getAllPatients().get(guiController.getDisplayPatientListView().
						getComboBoxPatientsIds().getSelectedIndex()).getPatientId()));
			//Display the patient info
			guiController.getDisplayPatientInfoView().displayPatientInfo();
			guiController.getDisplayPatientInfoView().setVisible(true);
		} catch (ArrayIndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null,
					"Please select a patient from the list. Add a patient if list is empty.");
			//displayPatientList(); // Go back to the display frame again
		}
	}

}
