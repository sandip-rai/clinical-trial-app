package listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

public class CheckBoxAddClinics implements ItemListener{
	GuiController guiController;
	
	public CheckBoxAddClinics(GuiController guiController){
		this.guiController = guiController;
	}
	
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
