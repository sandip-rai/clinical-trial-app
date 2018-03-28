package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

/**
 * The Class CheckBoxAddClinics.
 */
public class CheckBoxAddClinics implements ItemListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new check box add clinics.
	 *
	 * @param guiController the gui controller
	 */
	public CheckBoxAddClinics(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		if (e.getStateChange() == 1) {
			settings.setAddUnknownClinics(true);
		}else {
			settings.setAddUnknownClinics(false);
		}
	}	

}
