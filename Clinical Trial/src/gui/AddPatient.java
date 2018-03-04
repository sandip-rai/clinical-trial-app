package gui;

import trial.ClinicalTrial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPatient {
    Gui gui = new Gui();

    public ArrayList<JPanel> addPatient(){
        JLabel label = new JLabel("PatientID:");
        JTextField inputText = new JTextField("");
        JButton buttonAdd = new JButton("Add");
        JTextField addPatientState = new JTextField("Click Add button to add new Patient");
        addPatientState.setEditable(false);
        JButton back = new JButton("Back");

        // Creating JPanels
        int NUMBER_OF_PANELS = 3;
        ArrayList<JPanel> panels = gui.setupPanel(NUMBER_OF_PANELS);

        // Adding the textField and upload button to the panels
        panels.get(0).add(addPatientState);
        panels.get(1).add(label);
        panels.get(1).add(inputText);
        panels.get(2).add(buttonAdd);
        panels.get(2).add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.mainMenu();
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
    return panels;
    }
}
