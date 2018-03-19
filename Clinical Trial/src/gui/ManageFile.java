package gui;

import trial.FileHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ManageFile {
	static FileHandler fileHandler = new FileHandler();

	public static void manageFile() {
		PanelAndFrame.disposeFrame();

		JButton buttonUpload = new JButton("Upload a json file");
		JButton buttonSave = new JButton("Save as a json file");

		// Creating JPanels
		final int NUMBER_OF_PANELS = 1;
		PanelAndFrame.setupPanel(NUMBER_OF_PANELS);

		// Adding the textField and upload button to the panels
		PanelAndFrame.panels.get(0).add(buttonUpload);
		PanelAndFrame.panels.get(0).add(buttonSave);

		// Upload button functionality
		buttonUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = getPath();
				if (filePath != null) {
					fileHandler.readJsonFile(filePath, true, false);
					JOptionPane.showMessageDialog(null, "File uploaded successfully.");
					DisplayPatientList.displayPatientList();
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
				String filePath = getPath();
				if (filePath != null) {
					fileHandler.WritePatientReadings(filePath); // If file is saved, prompt the user
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
		PanelAndFrame.setupFrame();
	}

	private static String getPath() {
		JFileChooser fileChooser = new JFileChooser();
		// Open the file selection dialog at the current project directory
		fileChooser.setCurrentDirectory(new File("."));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile(); // Get the file
			String filePath = selectedFile.getAbsolutePath(); // Get the path
			return filePath;
		}
		return null;
	}
}
