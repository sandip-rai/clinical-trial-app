package gui;

import trial.FileHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManageFile {
    FileHandler fileHandler = new FileHandler();
    Gui gui = new Gui();

    public ArrayList<JPanel> manageFile() {
        JButton buttonUpload = new JButton("Upload a json file");
        JButton buttonSave = new JButton("Save as a json file");

        // Creating JPanels
        int NUMBER_OF_PANELS = 1;
        ArrayList<JPanel> panels = gui.setupPanel(NUMBER_OF_PANELS);

        // Adding the textField and upload button to the panels
        panels.get(0).add(buttonUpload);
        panels.get(0).add(buttonSave);

        // Upload button functionality
        buttonUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileHandler.readJsonFile()) { // If file is read, prompt the user and
                    // display the patient list
                    // interface
                    JOptionPane.showMessageDialog(null, "File uploaded successfully.");
                    gui.displayPatientList();
                } else { // If no file read, prompt the user and show the manage
                    // file interface
                    JOptionPane.showMessageDialog(null, "File not uploaded.");
                    manageFile();
                }

            }
        });

        // Save button functionality
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileHandler.writeJsonFile()) { // If file is saved, prompt the user
                    // and display manage file interface
                    JOptionPane.showMessageDialog(null, "File saved successfully.");
                    manageFile();
                } else { // If no file saved, prompt and display manage file
                    // interface again.
                    JOptionPane.showMessageDialog(null, "File not saved.");
                    manageFile();
                }
            }
        });

        return panels;
    }
}
