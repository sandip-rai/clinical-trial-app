package gui;

import trial.ClinicalTrial;
import trial.Reading;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPatientInfo {
	public static void displayPatientInfo(String selectedPatient){
    	PanelAndFrame.disposeFrame();
    	
        JButton buttonBack = new JButton("Back");

        // Two textfields to show the PatientID and the patient info
        JTextField patientID = new JTextField(16);
        // set textfields
        patientID.setText("PatientID: " + selectedPatient);
        patientID.setEditable(false); // Textfield is read-only
       
        // Create two panels
        final int NUMBER_OF_PANELS = 2;
        PanelAndFrame.setupPanel(NUMBER_OF_PANELS + ClinicalTrial.findPatient(selectedPatient).getReadings().size());

        // Add elements to the panels
        PanelAndFrame.panels.get(0).add(patientID);
        // panel1.add(checkbox);
        PanelAndFrame.panels.get(0).add(buttonBack);
        int count = 1;
        for(Reading reading: ClinicalTrial.findPatient(selectedPatient).getReadings()){
        	JTextField readingTextField = new JTextField();
        	readingTextField.setText(reading.toString());
        	readingTextField.setEditable(false); // Textfield is read-only
        	PanelAndFrame.panels.get(count).add(readingTextField);
        	count++;
        }

        // Go back to previous menu to show list of patient ids if pressed back
        // button
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DisplayPatientList.displayPatientList();
            }
        });

    	PanelAndFrame.setupFrame();
    }
}
