package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import gui.GuiController;
import gui.views.ClinicView;
import trial.ClinicalTrial;

/**
 * The listener interface for receiving buttonAddClinic events.
 * The class that is interested in processing a buttonAddClinic
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonAddClinicListener<code> method. When
 * the buttonAddClinic event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonAddClinicEvent
 */
//inner class for buttonAddReading to perform actionPerformed(ActionEvent e)
public class ButtonAddClinicListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;

	/**
	 * Instantiates a new button add clinic listener.
	 *
	 * @param guiController the gui controller
	 */
	// constructor
	public ButtonAddClinicListener(GuiController guiController) {
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
