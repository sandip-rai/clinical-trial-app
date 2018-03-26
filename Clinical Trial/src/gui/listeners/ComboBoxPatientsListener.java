package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.GuiController;
import gui.views.DisplayPatientListView;
import trial.Patient;

//class for buttonBack to perform actionPerformed(ActionEvent e)
public class ComboBoxPatientsListener implements ActionListener {
	GuiController guiController;
	//constructor
	public ComboBoxPatientsListener(GuiController guiController){
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String format = guiController.getClinicalTrial().getSettings().getDateFormat();
		DisplayPatientListView view = guiController.getDisplayPatientListView();
		if((Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem() != null){
			Patient patient = (Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem();
			boolean active = patient.isActive();
			String text = patient.toString(format);
			view.setActive(active);
			view.setPatientInfo(text);
		} else {
			  JOptionPane.showMessageDialog(null, "Please select a valid patient");
		}
		view.getFrame().pack();
	}

}
