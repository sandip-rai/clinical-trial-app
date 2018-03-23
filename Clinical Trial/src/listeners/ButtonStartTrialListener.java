package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import gui.GuiController;

//class for buttonStartTrail to perform actionPerformed(ActionEvent e)
public class ButtonStartTrialListener implements ActionListener {
	GuiController guiController;
	
	//constructor
	public ButtonStartTrialListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if (guiController.getMainMenuView().getComboBoxPatientsIds().getSelectedItem().toString() == "New patient") {
        	guiController.getMainMenuView().getFrame().dispose();
        	guiController.getAddPatientView().setupFrame();
        	guiController.getAddPatientView().setVisible(true);// Selecting new patient will call addPatient to allow to add new patient
        } else {// already in trial
            if (guiController.getClinicalTrial().findPatient(guiController.getMainMenuView().getComboBoxPatientsIds().getSelectedItem().toString()).isActive()) {
                JOptionPane.showMessageDialog(null, "This Patient is already active in trial");
            } else {// added to trail
                guiController.getClinicalTrial().findPatient(guiController.getMainMenuView().getComboBoxPatientsIds().getSelectedItem().toString()).setActive(true);
                JOptionPane.showMessageDialog(null, "This patient is set to actve and started trial");
            }
        }
    }
}