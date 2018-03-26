package gui.listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

public class CheckBoxJsonAddPatients implements ItemListener{
	GuiController guiController;
	
	public CheckBoxJsonAddPatients(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		if (e.getStateChange() == 1) {
			settings.setJsonAddUnknownPatients(true);
			guiController.getSystemSettingView().getCheckBoxJsonReadings().setEnabled(true);
		}else {
			settings.setJsonAddUnknownPatients(false);
			settings.setJsonAddUnknownReadings(false);
			guiController.getSystemSettingView().getCheckBoxJsonReadings().setEnabled(false);
			guiController.getSystemSettingView().getCheckBoxJsonReadings().setSelected(false);
		}
	}	

}