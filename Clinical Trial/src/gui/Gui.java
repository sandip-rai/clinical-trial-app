package gui;

/**
 * Gui class to show options to add, show patients list, and get input file from the user.
 */
import javax.swing.*;

import trial.ClinicalTrial;
import trial.FileHandler;
import trial.Patient;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.GridLayout;

public class Gui extends JPanel {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	JFrame frame;

	// Adding buttons to the GUI interface; these buttons are later called in
	// actionPerformed event.

	JButton buttonPatientsList = new JButton("Show Patient info");
	JButton buttonUploadFile = new JButton("Upload File");

	// Initializing
	JComboBox<String> comboBoxPatientsIds;
	FileHandler fh = new FileHandler();
	ArrayList<JPanel> panels;

	int NUMBER_OF_PANELS;
	final int PANEL_ROWS = 0;
	final int PANEL_COLS = 3;
	final int PANEL_HGAP = 10;
	final int PANEL_VGAP = 10;

	final int FRAME_ROWS = 10;
	final int FRAME_COLS = 10;
	final int FRAME_HGAP = 50;
	final int FRAME_VGAP = 50;

	public void mainMenu() {
		// Create menu components
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");

		// Add menus to menu bar
		menuBar.add(menu);

		// Create and add menuItems to menu
		JMenuItem patientInfo = menu.add("Patient Info");
		JMenuItem manageFile = menu.add("Manage Files");

		patientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				displayPatientList();
			}
		});

		manageFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				manageFile();
			}
		});

		// ComboBox to hold the patient id from the patients
		comboBoxPatientsIds = new JComboBox<String>();
		comboBoxPatientsIds.addItem("New patient"); // Display New Patient for
													// the dropdown list in the
													// first place
		for (Patient patient : ClinicalTrial.getAllPatients()) {
			comboBoxPatientsIds.addItem(patient.getPatientId()); // Fill the
																	// comboBox
																	// from the
																	// ClinicalTrial
																	// arrayList
		}

		JButton buttonStartTrial = new JButton("Start Patient Trial"); // Button
		buttonStartTrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxPatientsIds.getSelectedItem().toString() == "New patient") {
					frame.dispose();
					addPatient(); // Selecting new patient will call addPatient
									// to allow to add new patient
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

		JButton buttonAddReading = new JButton("Add");

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
					} else { // If all values are filled, add them to to
								// corresponding Patient
						long date = Long.parseLong(readingDate); // Change date
																	// from
																	// String to
																	// long
						// Get the patient from the ClinicalTrial arraylist and
						// add the new readings to that patient
						ClinicalTrial.findPatient(comboBoxPatientsIds.getSelectedItem().toString())
								.addNewReadings(readingId, readingType, readingValue, date);

						// Clear the textfields for new input
						idInput.setText("");
						valueInput.setText("");
						dateInput.setText("");
					}
				} catch (NullPointerException ex) { // Catch the error if no
													// patient is selected to
													// for adding readings.
					JOptionPane.showMessageDialog(null, "Please select a Patient to add readings.");
				}
			};
		});

		// Set all labels not editable
		pastReadingDisplay.setEditable(false);
		// Create JPanels
		NUMBER_OF_PANELS = 7;
		setupPanel(NUMBER_OF_PANELS);
		panels.get(0).add(comboBoxPatientsIds);
		panels.get(0).add(buttonStartTrial);
		panels.get(1).add(addReading);
		panels.get(2).add(id);
		panels.get(2).add(idInput);
		panels.get(3).add(date);
		panels.get(3).add(dateInput);
		panels.get(4).add(type);
		panels.get(4).add(comboBoxReadingType);
		panels.get(5).add(value);
		panels.get(5).add(valueInput);
		panels.get(6).add(buttonAddReading);

		// Frame setup

		setupFrame(menuBar, FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
	}

	public void setupPanel(int numberOfPanels) {
		panels = new ArrayList<JPanel>();
		for (int i = 0; i < numberOfPanels; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(PANEL_ROWS, PANEL_COLS, PANEL_HGAP, PANEL_VGAP));
			panels.add(panel);
		}
	}

	/**
	 * use it to setup frame
	 */
	public void setupFrame(JMenuBar menuBar, int rows, int cols, int hagp, int vgap) {
		frame = new JFrame();
		frame.setLayout(new GridLayout(rows, cols, hagp, vgap));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (menuBar != null) {
			frame.setJMenuBar(menuBar);
		}
		for (JPanel panel : panels) {
			frame.add(panel);
		}

		frame.pack();
		frame.setLocation(150, 150);
		frame.setVisible(true);
	}

	/**
	 * GUI to implement the File management for input and output.
	 */
	public void manageFile() {
		JButton buttonUpload = new JButton("Upload a json file");
		JButton buttonSave = new JButton("Save as a json file");

		// Creating JPanels
		NUMBER_OF_PANELS = 1;
		setupPanel(NUMBER_OF_PANELS);

		// Create menu components
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");

		// Add menus to menu bar
		menuBar.add(menu);

		// Create and add menuItems to menu
		JMenuItem back = menu.add("Back");

		// Back button
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mainMenu();
			}
		});

		// Adding the textField and upload button to the panels
		panels.get(0).add(buttonUpload);
		panels.get(0).add(buttonSave);

		// Upload button functionality
		buttonUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if (fh.readJsonFile()) { // If file is read, prompt the user and
											// display the patient list
											// interface
					JOptionPane.showMessageDialog(null, "File uploaded successfully.");
					displayPatientList();
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
				if (fh.writeJsonFile()) { // If file is saved, prompt the user
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

		setupFrame(menuBar, FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
	}

	/**
	 * uploadFile gets called from actionPerformed method, gets the input file
	 * and passes the filePath to readJsonFile in FileHandler class
	 */

	public void addPatient() {
		JLabel label = new JLabel("PatientID:");
		JTextField inputText = new JTextField("");
		JButton buttonAdd = new JButton("Add");
		JTextField addPatientState = new JTextField("Click Add button to add new Patient");
		addPatientState.setEditable(false);
		JButton back = new JButton("Back");

		// Creating JPanels
		NUMBER_OF_PANELS = 3;
		setupPanel(NUMBER_OF_PANELS);

		// Create menu components
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");

		// Add menus to menu bar
		menuBar.add(menu);

		// Create and add menuItems to menu
		JMenuItem patientInfo = menu.add("Patient Info");
		JMenuItem manageFile = menu.add("Manage Files");

		patientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				displayPatientList();
			}
		});

		manageFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				manageFile();
			}
		});

		// Adding the textField and upload button to the panels
		panels.get(0).add(addPatientState);
		panels.get(1).add(label);
		panels.get(1).add(inputText);
		panels.get(2).add(buttonAdd);
		panels.get(2).add(back);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mainMenu();
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

		// Create a frame and add the two panels created
		setupFrame(menuBar, FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
	}

	/**
	 * displayPatientList shows the list of patients present in the Clinical
	 * Trial and gives option to show info or start a trial for a patient
	 */
	public void displayPatientList() {
		JComboBox<String> comboBoxPatientsIds = new JComboBox<String>();
		for (Patient patient : ClinicalTrial.getAllPatients()) {
			comboBoxPatientsIds.addItem(patient.getPatientId());
		}

		JLabel label = new JLabel("Patients List: Select a Patient");

		JButton buttonShowInfo = new JButton("Show Patient's Info");
		JButton buttonResumeTrial = new JButton("Resume Patient Trial");
		JButton buttonEndTrial = new JButton("End Patient Trial");

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");

		// Add menus to menu bar
		menuBar.add(menu);
		JMenuItem back = menu.add("Back");

		// set up JPanels
		NUMBER_OF_PANELS = 2;
		setupPanel(NUMBER_OF_PANELS);
		panels.get(0).add(label);
		panels.get(1).add(comboBoxPatientsIds);
		panels.get(1).add(buttonResumeTrial);
		panels.get(1).add(buttonEndTrial);
		panels.get(1).add(buttonShowInfo);

		// Select a patient id from the dropdown menu and display the
		// corresponding patient info
		buttonShowInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {// Handle the exception by prompting a user to select a
						// patient or add a patient if list is empty
						// Print the info of selected patient id
					displayPatientInfo(
							ClinicalTrial.getAllPatients().get(comboBoxPatientsIds.getSelectedIndex()).getPatientId());
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,
							"Please select a patient from the list. Add a patient if list is empty.");
					displayPatientList(); // Go back to the display frame again
				}
			};
		});

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mainMenu();
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

		// Create a frame and add the two panels created
		setupFrame(menuBar, FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
	}

	/**
	 * displayPatientInfo shows the patient info of the corresponding patient id
	 *
	 * @param selectedPatient
	 *            patientID of the called patient
	 */
	public void displayPatientInfo(String selectedPatient) {
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
		NUMBER_OF_PANELS = 2;
		setupPanel(NUMBER_OF_PANELS);

		// Add elements to the panels
		panels.get(0).add(patientID);
		// panel1.add(checkbox);
		panels.get(0).add(buttonBack);
		panels.get(1).add(reading);

		// Go back to previous menu to show list of patient ids if pressed back
		// button
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				displayPatientList();
			}
		});
		// Create the frame and add the panels to it
		setupFrame(null, FRAME_COLS, FRAME_COLS, FRAME_COLS, FRAME_COLS);
	}
}
