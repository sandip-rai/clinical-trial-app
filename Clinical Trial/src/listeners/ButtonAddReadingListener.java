package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import gui.GuiController;
import trial.Clinic;
import trial.Patient;

//inner class for buttonAddReading to perform actionPerformed(ActionEvent e)
public class ButtonAddReadingListener implements ActionListener {
	GuiController guiController;

	// constructor
	public ButtonAddReadingListener(GuiController guiController) {
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the new entered values
		Patient patient = (Patient) guiController.getMainMenuView().getComboBoxPatients().getSelectedItem();
		String readingId = guiController.getMainMenuView().getIdInput().getText();
		String readingType = (String) guiController.getMainMenuView().getComboBoxReadingType().getSelectedItem();
		String readingValue = guiController.getMainMenuView().getValueInput().getText();
		String readingDate = guiController.getMainMenuView().getDateInput().getText();
		String dateFormat = guiController.getClinicalTrial().getSettings().getDateFormat();
		Clinic clinic = (Clinic) guiController.getMainMenuView().getComboBoxClinics().getSelectedItem();
		try {
			// Prompt the user if reading values aren't filled
			if (readingId.equals("") || readingValue.equals("") || readingDate.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in the values for every field.");
			} else { // If all values are filled, add them to to corresponding Patient
				SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
				Date date = formatter.parse(readingDate); // Change date from String to Date
				// Get the patient from the guiController.getClinicalTrial() arraylist and
				// add the new readings to that patient
				patient.addNewReadings(readingId, readingType, readingValue, date, clinic);

				// Clear the textfields for new input
				guiController.getMainMenuView().getIdInput().setText("");
				guiController.getMainMenuView().getValueInput().setText("");
				guiController.getMainMenuView().getDateInput().setText("");
			}
		} catch (NullPointerException ex) { // Catch the error if no patient is selected for adding readings.
			guiController.getMainMenuView().displayErrorMessage(null, "Please select a Patient to add readings.");
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Please enter a valid date formated " + dateFormat);
			e1.printStackTrace();
		}
	}
}
