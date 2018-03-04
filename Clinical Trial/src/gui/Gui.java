package gui;

/**
 * Gui class to show options to add, show patients list, and get input file from the user.
 */

import trial.ClinicalTrial;
import trial.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JPanel {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	JFrame frame;
    MenuBar menuBar = new MenuBar(); //Create the MenuBar

	// Adding buttons to the GUI interface; these buttons are later called in
	// actionPerformed event.
	JButton buttonPatientsList = new JButton("Show Patient info");
	JButton buttonUploadFile = new JButton("Upload File");

	// Initializing
	JComboBox<String> comboBoxPatientsIds;

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
		// ComboBox to hold the patient id from the patients
		comboBoxPatientsIds = new JComboBox<String>();
        comboBoxPatientsIds.addItem("New patient"); // Display New Patient for the dropdown list in the first place
		for (Patient patient : ClinicalTrial.getAllPatients()) {
            comboBoxPatientsIds.addItem(patient.getPatientId()); // Fill the comboBox from the ClinicalTrial arrayList
		}

		JButton buttonStartTrial = new JButton("Start Patient Trial"); // Button
		buttonStartTrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxPatientsIds.getSelectedItem().toString() == "New patient") {
					frame.dispose();
                    addPatient(); // Selecting new patient will call addPatient to allow to add new patient
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
        setupFrame(menuBar.makeMenuBar(), FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
    }

    public ArrayList<JPanel> setupPanel(int numberOfPanels) {
		panels = new ArrayList<JPanel>();
		for (int i = 0; i < numberOfPanels; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(PANEL_ROWS, PANEL_COLS, PANEL_HGAP, PANEL_VGAP));
			panels.add(panel);
		}
        return panels;
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
        ManageFile manageFile = new ManageFile();
        panels = manageFile.manageFile();
        setupFrame(menuBar.makeMenuBar(), FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
	}

	/**
	 * uploadFile gets called from actionPerformed method, gets the input file
	 * and passes the filePath to readJsonFile in FileHandler class
	 */

	public void addPatient() {
        AddPatient addPatient = new AddPatient();
        panels = addPatient.addPatient();
        setupFrame(menuBar.makeMenuBar(), FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
	}

	/**
	 * displayPatientList shows the list of patients present in the Clinical
	 * Trial and gives option to show info or start a trial for a patient
	 */
	public void displayPatientList() {
        DisplayPatientList displayPatientList = new DisplayPatientList();
        panels = displayPatientList.displayPatientList();
        setupFrame(menuBar.makeMenuBar(), FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP);
	}

	/**
	 * displayPatientInfo shows the patient info of the corresponding patient id
	 *
	 * @param selectedPatient
	 *            patientID of the called patient
	 */
	public void displayPatientInfo(String selectedPatient) {
        DisplayPatientInfo displayPatientInfo = new DisplayPatientInfo();
        panels = displayPatientInfo.displayPatientInfo(selectedPatient);
		setupFrame(null, FRAME_COLS, FRAME_COLS, FRAME_COLS, FRAME_COLS);
	}

    public void disposeFrame() {
        frame.dispose();
    }
}
