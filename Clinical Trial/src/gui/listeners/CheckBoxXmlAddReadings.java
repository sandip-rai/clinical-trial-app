package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

/**
 * The Class CheckBoxXmlAddReadings.
 */
public class CheckBoxXmlAddReadings implements ItemListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new check box xml add readings.
	 *
	 * @param guiController the gui controller
	 */
	public CheckBoxXmlAddReadings(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		Boolean addPatients = settings.xmlAddUnknownPatients();
		if (e.getStateChange() == 1 && addPatients) {
			//If setXmlAddUnknownReadings was checked set the SystemSetting to true
			settings.setXmlAddUnknownReadings(true);
		}else {
			//If setXmlAddUnknownReadings was unchecked set the SyStemSetting to false
			settings.setXmlAddUnknownReadings(false);
		}
	}	

}