package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;
import gui.views.SystemSettingsView;
import trial.SystemSettings;

/**
 * The listener interface for receiving buttonResetAllSettings events.
 * The class that is interested in processing a buttonResetAllSettings
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonResetAllSettingsListener<code> method. When
 * the buttonResetAllSettings event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonResetAllSettingsEvent
 */
//inner class for buttonAddReading to perform actionPerformed(ActionEvent e)
public class ButtonResetAllSettingsListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;

	/**
	 * Instantiates a new button reset all settings listener.
	 *
	 * @param guiController the gui controller
	 */
	// constructor
	public ButtonResetAllSettingsListener(GuiController guiController) {
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
