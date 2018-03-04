package gui;

import trial.ClinicalTrial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayPatientInfo {
    Gui gui = new Gui();

    public ArrayList<JPanel> displayPatientInfo(String selectedPatient){
        JButton buttonBack = new JButton("Back");

        // Two textfields to show the PatientID and the patient info
        JTextField patientID = new JTextField(16);
        JTextField reading = new JTextField();
        reading.setSize(200, 200);

        // set textfields
        patientID.setText("PatientID: " + selectedPatient);
        reading.setText(ClinicalTrial.findPatient(selectedPatient).getReadings().toString());
        patientID.setEditable(false); // Textfield is read-only
        reading.setEditable(false); // Textfield is read-only
        // Create two panels
        int NUMBER_OF_PANELS = 2;
        ArrayList<JPanel> panels = gui.setupPanel(NUMBER_OF_PANELS);

        // Add elements to the panels
        panels.get(0).add(patientID);
        // panel1.add(checkbox);
        panels.get(0).add(buttonBack);
        panels.get(1).add(reading);

        // Go back to previous menu to show list of patient ids if pressed back
        // button
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.displayPatientList();
            }
        });

        return panels;
    }
}
