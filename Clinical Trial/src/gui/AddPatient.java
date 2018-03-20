package gui;

import trial.ClinicalTrial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatient {
    public static void addPatient(){
    	PanelAndFrame.disposeFrame();
    	
        JLabel label = new JLabel("PatientID:");
        JTextField inputText = new JTextField("");
        JButton buttonAdd = new JButton("Add");
        JTextField addPatientState = new JTextField("Click Add button to add new Patient");
        addPatientState.setEditable(false);
        JButton back = new JButton("Back");

        // Creating JPanels
        final int NUMBER_OF_PANELS = 3;
        PanelAndFrame.setupPanel(NUMBER_OF_PANELS);

        // Adding the textField and upload button to the panels
        PanelAndFrame.panels.get(0).add(addPatientState);
        PanelAndFrame.panels.get(1).add(label);
        PanelAndFrame.panels.get(1).add(inputText);
        PanelAndFrame.panels.get(2).add(buttonAdd);
        PanelAndFrame.panels.get(2).add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PanelAndFrame.disposeFrame();
                MainMenu.mainMenu();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tempId = inputText.getText(); // assign the PatientId
                // that user inputs
                if (tempId == null || tempId.equals("")) {// make sure the user
                    // has entered a
                    // patient ID
                    addPatientState.setText("Please enter a patient ID");
                } else if (ClinicalTrial.addPatient(tempId)) {
                    ClinicalTrial.findPatient(tempId).setActive(true);
                    addPatientState.setText("Added! Ready for next patient. ");
                    inputText.setText("");
                } else {
                    addPatientState.setText("That patient is already in this trial.");
                }
            }
        });
        PanelAndFrame.updatePatientList();
    }
}
