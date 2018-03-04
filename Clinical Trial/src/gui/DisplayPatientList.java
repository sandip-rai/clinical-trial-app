package gui;

import trial.ClinicalTrial;
import trial.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayPatientList {
    Gui gui = new Gui();

    public ArrayList<JPanel> displayPatientList(){
        JComboBox<String> comboBoxPatientsIds = new JComboBox<String>();
        for (Patient patient : ClinicalTrial.getAllPatients()) {
            comboBoxPatientsIds.addItem(patient.getPatientId());
        }

        JLabel label = new JLabel("Patients List: Select a Patient");

        JButton buttonShowInfo = new JButton("Show Patient's Info");
        JButton buttonResumeTrial = new JButton("Resume Patient Trial");
        JButton buttonEndTrial = new JButton("End Patient Trial");

        // set up JPanels
        int NUMBER_OF_PANELS = 2;
        ArrayList<JPanel> panels = gui.setupPanel(NUMBER_OF_PANELS);
        panels.get(0).add(label);
        panels.get(1).add(comboBoxPatientsIds);
        panels.get(1).add(buttonResumeTrial);
        panels.get(1).add(buttonEndTrial);
        panels.get(1).add(buttonShowInfo);

        // Select a patient id from the dropdown menu and display the
        // corresponding patient info
        buttonShowInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {// Handle the exception by prompting a user to select a
                    // patient or add a patient if list is empty
                    // Print the info of selected patient id
                    gui.displayPatientInfo(
                            ClinicalTrial.getAllPatients().get(comboBoxPatientsIds.getSelectedIndex()).getPatientId());
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Please select a patient from the list. Add a patient if list is empty.");
                    displayPatientList(); // Go back to the display frame again
                }
            };
        });

        buttonResumeTrial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try { // Handle the exception if no patient is selected to
                    // resume the trial.
                    ClinicalTrial.findPatient(
                            ClinicalTrial.getAllPatients().get(comboBoxPatientsIds.getSelectedIndex()).getPatientId())
                            .setActive(true);
                    JOptionPane.showMessageDialog(null, "Patient ID: "
                            + ClinicalTrial.getAllPatients().get(comboBoxPatientsIds.getSelectedIndex()).getPatientId()
                            + "\nTrial has been activated");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Please select a patient from the list. Add a patient if list is empty.");
                    displayPatientList(); // Go back to the display frame again
                }

            };
        });

        // sets active to false on click, displays confirmation message
        buttonEndTrial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {// Handle the exception if no patient is selected to end
                    // the trial.
                    // Set patient's active to false
                    ClinicalTrial.findPatient(
                            ClinicalTrial.getAllPatients().get(comboBoxPatientsIds.getSelectedIndex()).getPatientId())
                            .setActive(false);
                    JOptionPane.showMessageDialog(null, "Patient ID: "
                            + ClinicalTrial.getAllPatients().get(comboBoxPatientsIds.getSelectedIndex()).getPatientId()
                            + "\nTrial has ended");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Please select a patient from the list. Add a patient if list is empty.");
                    displayPatientList(); // Go back to the display frame again
                }

            };
        });
        return panels;
    }
}
