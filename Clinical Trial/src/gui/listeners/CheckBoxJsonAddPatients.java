package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

/**
 * The Class CheckBoxJsonAddPatients.
 */
public class CheckBoxJsonAddPatients implements ItemListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new check box json add patients.
	 *
	 * @param guiController the gui controller
	 */
	public CheckBoxJsonAddPatients(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		//If JsonAddUnknownPatients was checked
		if (e.getStateChange() == 1) {
			//Set JsonAddUnknownPatients to true
			settings.setJsonAddUnknownPatients(true);
			//Enable the  check box to add readings and activate new patients
			guiController.getSystemSettingView().getCheckBoxJsonReadings().setEnabled(true);
		}else {
			//If the check box was unchecked set all json SystemSettings to false
			settings.setJsonAddUnknownPatients(false);
			settings.setJsonAddUnknownReadings(false);
			//Uncheck the JSON reading box as well and disable it
			guiController.getSystemSettingView().getCheckBoxJsonReadings().setEnabled(false);
			guiController.getSystemSettingView().getCheckBoxJsonReadings().setSelected(false);
		}
	}	

}
