package listeners;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import gui.GuiController;
import trial.Patient;

public class CheckBoxPatientIsActive implements ItemListener{
	GuiController guiController;
	
	public CheckBoxPatientIsActive(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Patient patient = guiController.getDisplayPatientListView().getSelectedPatient();
		if (e.getStateChange() == 1) {
			patient.setActive(true);
		}else {
			patient.setActive(false);			
		}
	}		

}