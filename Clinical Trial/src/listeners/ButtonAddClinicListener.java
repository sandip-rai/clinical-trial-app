package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import gui.GuiController;
import trial.ClinicalTrial;
import views.ClinicView;

//inner class for buttonAddReading to perform actionPerformed(ActionEvent e)
public class ButtonAddClinicListener implements ActionListener {
	GuiController guiController;

	// constructor
	public ButtonAddClinicListener(GuiController guiController) {
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the new entered values
		String name = guiController.getClinicView().getClinicName().getText();
		String id = guiController.getClinicView().getClinicId().getText();
		// Prompt the user if reading values aren't filled
		if (name == "") {
			JOptionPane.showMessageDialog(null, "Please fill in the \"Clinic Name\" field");
		} else { // If all values are filled, add them to to corresponding Patient
			ClinicView view = guiController.getClinicView();
			ClinicalTrial clinicalTrial = guiController.getClinicalTrial();
			clinicalTrial.addClinic(name, id);
			view.getAddClinicText().setText("Clinic added, ready for next Clinic");
			view.getClinicId().setText("");
			view.getClinicName().setText("");
		}
	}
}
