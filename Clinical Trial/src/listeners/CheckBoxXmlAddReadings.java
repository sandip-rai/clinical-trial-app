package listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.SystemSettings;

public class CheckBoxXmlAddReadings implements ItemListener{
	GuiController guiController;
	
	public CheckBoxXmlAddReadings(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		SystemSettings settings = guiController.getClinicalTrial().getSettings();
		if (e.getStateChange() == 1) {
			settings.setXmlAddUnknownReadings(true);
		}else {
			settings.setXmlAddUnknownReadings(false);
		}
	}	

}