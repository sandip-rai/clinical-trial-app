package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

/**
 * The Class CheckBoxXmlAddPatients.
 */
public class CheckBoxXmlAddPatients implements ItemListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new check box xml add patients.
	 *
	 * @param guiController the gui controller
	 */
	public CheckBoxXmlAddPatients(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		// If setXmlAddUnknownPatients was checked
		if (e.getStateChange() == 1) {
			//set the SystemSetting for setXmlAddUnknownPatients to true
			settings.setXmlAddUnknownPatients(true);
			//Enable the  check box to add readings and activate new patients
			guiController.getSystemSettingView().getCheckBoxXmlReadings().setEnabled(true);
		}else {
			//If setXmlAddUnknownPatients was unchecked set all XML settings to false
			settings.setXmlAddUnknownPatients(false);
			settings.setXmlAddUnknownReadings(false);
			//Uncheck setXmlAddUnknownReadings and disabled it
			guiController.getSystemSettingView().getCheckBoxXmlReadings().setEnabled(false);
			guiController.getSystemSettingView().getCheckBoxXmlReadings().setSelected(false);
		}
	}		

}