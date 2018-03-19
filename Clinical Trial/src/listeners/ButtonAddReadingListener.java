package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import views.MainMenuView;
import trial.ClinicalTrial;

//inner class for buttonAddReading to perform actionPerformed(ActionEvent e)
public class ButtonAddReadingListener implements ActionListener {
	MainMenuView mainMenuView;
	
	//constructor
	public ButtonAddReadingListener(MainMenuView mainMenuView){
		this.mainMenuView = mainMenuView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        // Get the new entered values in the textfield
        String readingId = mainMenuView.getIdInput().getText();
        String readingType = (String) mainMenuView.getComboBoxReadingType().getSelectedItem();
        String readingValue = mainMenuView.getValueInput().getText();
        String readingDate = mainMenuView.getDateInput().getText();
        try {
            // Prompt the user if reading values aren't filled
            if (readingId.equals("") || readingValue.equals("") || readingDate.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in the values for every field.");
            } else { // If all values are filled, add them to to corresponding Patient
                long date = Long.parseLong(readingDate); // Change date from String to long
                // Get the patient from the ClinicalTrial arraylist and
                // add the new readings to that patient
                ClinicalTrial.findPatient(mainMenuView.getComboBoxPatientsIds().getSelectedItem().toString())
                        .addNewReadings(readingId, readingType, readingValue, date);

                // Clear the textfields for new input
                mainMenuView.getIdInput().setText("");
                mainMenuView.getValueInput().setText("");
                mainMenuView.getDateInput().setText("");
            }
        } catch (NullPointerException ex) { // Catch the error if no patient is selected for adding readings.
        	mainMenuView.displayErrorMessage(null, "Please select a Patient to add readings.");
        }	
	}
}
