package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;
import gui.views.SystemSettingsView;
import trial.SystemSettings;

//inner class for buttonAddReading to perform actionPerformed(ActionEvent e)
public class ButtonResetAllSettingsListener implements ActionListener {
	GuiController guiController;

	// constructor
	public ButtonResetAllSettingsListener(GuiController guiController) {
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		settings.setDateFormat("ddMMMyyyy HH:mm");
		settings.setAddUnknownClinics(true);
		settings.setJsonAddUnknownPatients(false);
		settings.setJsonAddUnknownReadings(false);
		settings.setXmlAddUnknownPatients(true);
		settings.setXmlAddUnknownReadings(true);
		SystemSettingsView view = guiController.getSystemSettingView();
		view.getDateFormat().setText("ddMMMyyyy HH:mm");
		view.getCheckBoxAddClinics().setSelected(true);
		view.getCheckBoxJsonPatients().setSelected(false);
		view.getCheckBoxJsonReadings().setSelected(false);
		view.getCheckBoxXmlPatients().setSelected(true);
		view.getCheckBoxXmlReadings().setSelected(true);	
	}
}
