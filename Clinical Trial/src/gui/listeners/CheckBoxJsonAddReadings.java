package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

public class CheckBoxJsonAddReadings implements ItemListener{
	GuiController guiController;
	
	public CheckBoxJsonAddReadings(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		Boolean addPatients = settings.jsonAddUnknownPatients();
		if (e.getStateChange() == 1 && addPatients) {
			settings.setJsonAddUnknownReadings(true);
		}else {
			settings.setJsonAddUnknownReadings(false);
		}
	}	

}