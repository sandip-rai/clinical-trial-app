package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.GuiController;
import trial.Patient;
import views.DisplayPatientListView;

//class for buttonBack to perform actionPerformed(ActionEvent e)
public class ComboBoxPatientsListener implements ActionListener {
	GuiController guiController;
	//constructor
	public ComboBoxPatientsListener(GuiController guiController){
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DisplayPatientListView view = guiController.getDisplayPatientListView();
		if((Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem() != null){
			Patient patient = (Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem();
			boolean active = patient.isActive();
			String text = patient.toString();
			view.setActive(active);
			view.setPatientInfo(text);
		} else {
			  JOptionPane.showMessageDialog(null, "Please select a valid patient");
		}
		view.getFrame().pack();
	}

}
