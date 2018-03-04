package gui;
import trial.ClinicalTrial;
import trial.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
	public static void mainMenu(){
		
		JComboBox<String> comboBoxPatientsIds = new JComboBox<String>();
		 comboBoxPatientsIds.addItem("New patient"); // Display New Patient for the dropdown list in the first place
			for (Patient patient : ClinicalTrial.getAllPatients()) {
	            comboBoxPatientsIds.addItem(patient.getPatientId()); // Fill the comboBox from the ClinicalTrial arrayList
			}

			JButton buttonStartTrial = new JButton("Start Patient Trial"); // Button
			buttonStartTrial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBoxPatientsIds.getSelectedItem().toString() == "New patient") {
	                    AddPatient.addPatient(); // Selecting new patient will call addPatient to allow to add new patient
					} else {// already in trial
						if (ClinicalTrial.findPatient(comboBoxPatientsIds.getSelectedItem().toString()).isActive()) {
							JOptionPane.showMessageDialog(null, "This Patient is already active in trial");
						} else {// added to trail
							ClinicalTrial.findPatient(comboBoxPatientsIds.getSelectedItem().toString()).setActive(true);
							JOptionPane.showMessageDialog(null, "This patient is set to actve and started trial");
						}
					}
				}
			});

			// Array to hold the reading types which will be showed in the comboBox
			String[] readingTypes = new String[] { "Weight", "Steps", "Temp", "Blood Pressure" };
			JComboBox<String> comboBoxReadingType = new JComboBox<String>(readingTypes);

			// Creates labels and user input textFeild
			JLabel addReading = new JLabel("Add a new reading:");
			JLabel id = new JLabel("Reading ID:");
			JLabel date = new JLabel("Reading Date:");
			JLabel type = new JLabel("Reading Type:");
			JLabel value = new JLabel("Reading Value:");
			JTextField valueInput = new JTextField(16);
			JTextField idInput = new JTextField(16);
			JTextField dateInput = new JTextField(16);
			JTextField pastReadingDisplay = new JTextField(16);

			// When Add button is pressed
	        JButton buttonAddReading = new JButton("Add");
			buttonAddReading.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Get the new entered values in the textfield
					String readingId = idInput.getText();
					String readingType = (String) comboBoxReadingType.getSelectedItem();
					String readingValue = valueInput.getText();
					String readingDate = dateInput.getText();
					try {
						// Prompt the user if reading values aren't filled
						if (readingId.equals("") || readingValue.equals("") || readingDate.equals("")) {
							JOptionPane.showMessageDialog(null, "Please fill in the values for every field.");
	                    } else { // If all values are filled, add them to to corresponding Patient
	                        long date = Long.parseLong(readingDate); // Change date from String to long
							// Get the patient from the ClinicalTrial arraylist and
							// add the new readings to that patient
							ClinicalTrial.findPatient(comboBoxPatientsIds.getSelectedItem().toString())
									.addNewReadings(readingId, readingType, readingValue, date);

							// Clear the textfields for new input
							idInput.setText("");
							valueInput.setText("");
							dateInput.setText("");
						}
	                } catch (NullPointerException ex) { // Catch the error if no patient is selected for adding readings.
						JOptionPane.showMessageDialog(null, "Please select a Patient to add readings.");
					}
				};
			});

			// Set all labels not editable
			pastReadingDisplay.setEditable(false);
			// Create JPanels
			final int NUMBER_OF_PANELS = 7;
			PanelAndFrame.setupPanel(NUMBER_OF_PANELS);
			PanelAndFrame.panels.get(0).add(comboBoxPatientsIds);
			PanelAndFrame.panels.get(0).add(buttonStartTrial);
			PanelAndFrame.panels.get(1).add(addReading);
			PanelAndFrame.panels.get(2).add(id);
			PanelAndFrame.panels.get(2).add(idInput);
			PanelAndFrame.panels.get(3).add(date);
			PanelAndFrame.panels.get(3).add(dateInput);
			PanelAndFrame.panels.get(4).add(type);
			PanelAndFrame.panels.get(4).add(comboBoxReadingType);
			PanelAndFrame.panels.get(5).add(value);
			PanelAndFrame.panels.get(5).add(valueInput);
			PanelAndFrame.panels.get(6).add(buttonAddReading);
			PanelAndFrame.setupFrame();
	}
}
