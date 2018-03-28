package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import gui.GuiController;
import trial.Clinic;
import trial.Patient;

/**
 * The listener interface for receiving buttonAddReading events.
 * The class that is interested in processing a buttonAddReading
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonAddReadingListener<code> method. When
 * the buttonAddReading event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonAddReadingEvent
 */
//inner class for buttonAddReading to perform actionPerformed(ActionEvent e)
public class ButtonAddReadingListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;

	/**
	 * Instantiates a new button add reading listener.
	 *
	 * @param guiController the gui controller
	 */
	// constructor
	public ButtonAddReadingListener(GuiController guiController) {
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the new entered values
		Patient patient = (Patient) guiController.getMainMenuView().getComboBoxPatients().getSelectedItem();
		String readingType = (String) guiController.getMainMenuView().getComboBoxReadingType().getSelectedItem();
		String readingValue = guiController.getMainMenuView().getValueInput().getText();
		String readingDate = guiController.getMainMenuView().getDateInput().getText();
		String dateFormat = guiController.getClinicalTrial().getSettings().getDateFormat();
		Clinic clinic = (Clinic) guiController.getMainMenuView().getComboBoxClinics().getSelectedItem();
		try {
			// Prompt the user if reading values aren't filled
			if (readingValue.equals("") || readingDate.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in the values for every field.");
			} else { // If all values are filled, add them to to corresponding Patient
				SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
				Date date = formatter.parse(readingDate); // Change date from String to Date
				// Get the patient from the guiController.getClinicalTrial() arraylist and
				// add the new readings to that patient
				if(patient.addReading(null, readingType, readingValue, date, clinic)) {
					JOptionPane.showMessageDialog(null, "New reading has been added."); //Prompt if the reading is added
				}else {
					JOptionPane.showMessageDialog(null, "Invalid reading."); //Prompt if patient is not active in trial
				}

				// Clear the textfields for new input
				guiController.getMainMenuView().getValueInput().setText("");
			}
		} catch (NullPointerException ex) { // Catch the error if no patient is selected for adding readings.
			guiController.getMainMenuView().displayErrorMessage(null, "Please select a Patient to add readings.");
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Please enter a valid date formated " + dateFormat);
			e1.printStackTrace();
		}
	}
}
