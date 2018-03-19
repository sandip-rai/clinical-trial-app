package listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import gui.PanelAndFrame;
import trial.ClinicalTrial;
import views.AddPatientView;
import views.MainMenuView;

//class for buttonStartTrail to perform actionPerformed(ActionEvent e)
public class ButtonStartTrialListener implements ActionListener {
	MainMenuView mainMenuView;
	AddPatientView addPatinetView;
	
	//constructor 
	public ButtonStartTrialListener(MainMenuView mainMenuView, AddPatientView addPatinetView){
		this.mainMenuView = mainMenuView;
		this.addPatinetView = addPatinetView;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if (mainMenuView.getComboBoxPatientsIds().getSelectedItem().toString() == "New patient") {
        	mainMenuView.getFrame().dispose();
        	addPatinetView.setupFrame();
    		addPatinetView.setVisible(true);// Selecting new patient will call addPatient to allow to add new patient
        } else {// already in trial
            if (ClinicalTrial.findPatient(mainMenuView.getComboBoxPatientsIds().getSelectedItem().toString()).isActive()) {
                JOptionPane.showMessageDialog(null, "This Patient is already active in trial");
            } else {// added to trail
                ClinicalTrial.findPatient(mainMenuView.getComboBoxPatientsIds().getSelectedItem().toString()).setActive(true);
                JOptionPane.showMessageDialog(null, "This patient is set to actve and started trial");
            }
        }
    }
}