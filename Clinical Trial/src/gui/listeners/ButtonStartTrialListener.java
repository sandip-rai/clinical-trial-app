package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;

//class for buttonStartTrail to perform actionPerformed(ActionEvent e)
public class ButtonStartTrialListener implements ActionListener {
	GuiController guiController;

	// constructor
	public ButtonStartTrialListener(GuiController guiController) {
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.disposeAllViews();
		guiController.getAddPatientView().setupFrame();
		guiController.getAddPatientView().setVisible(true);// Selecting new patient will call addPatient to allow to add
															// new patient
	}
}