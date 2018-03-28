package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

/**
 * The Class CheckBoxJsonAddReadings.
 */
public class CheckBoxJsonAddReadings implements ItemListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new check box json add readings.
	 *
	 * @param guiController the gui controller
	 */
	public CheckBoxJsonAddReadings(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		Boolean addPatients = settings.jsonAddUnknownPatients();
		if (e.getStateChange() == 1 && addPatients) {
			//if JsonAddUnknownReadings was checked set the SystemSetting to true
			settings.setJsonAddUnknownReadings(true);
		}else {
			//if JsonAddUnknownReadings was unchecked set the SyStemSetting to false
			settings.setJsonAddUnknownReadings(false);
		}
	}	

}