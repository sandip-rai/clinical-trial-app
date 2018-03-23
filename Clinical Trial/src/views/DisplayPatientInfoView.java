package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.MenuBar;
import gui.PanelAndFrame;
import trial.ClinicalTrial;
import trial.Patient;
import trial.Reading;

public class DisplayPatientInfoView implements View {
	private String selectedPatient = ""; // Initialize
	JButton buttonBack = new JButton("Back");
	// Two textFields to show the PatientID and the patient info
	JTextField patientID = new JTextField(16);

	// Create an ArrayList to hold all panels
	final int NUMBER_OF_PANELS = 2;
	ArrayList<JPanel> panels;
	MenuBar menuBar; // Initializing the menubar of the gui package

	// Create JFrame
	private JFrame frame = new JFrame();

	/**
	 * Constructor
	 */
	public DisplayPatientInfoView() {

	}

	/**
	 * Getter for selectedPatient to show the patient info
	 * 
	 * @return selectedPatient the patient of whose to display info of
	 */
	public String getSelectedPatient() {
		return selectedPatient;
	}

	/**
	 * Setter for selectedPatient to show the patient info
	 * 
	 * @param selectedPatient
	 *            selectedPatient the patient of whose to display info of
	 */
	public void setSelectedPatient(String selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	/**
	 * Display the patient info of the selected patient
	 */
	public void displayPatientInfo(ClinicalTrial clinicalTrial) {

		// Create JPanels
		panels = PanelAndFrame
				.setupPanels(NUMBER_OF_PANELS + clinicalTrial.findPatient(selectedPatient).getReadings().size());

		// Add elements to the panels
		panels.get(0).add(patientID);
		// panel1.add(checkbox);
		panels.get(0).add(buttonBack);
		int count = 1;
		for (Reading reading : clinicalTrial.findPatient(selectedPatient).getReadings()) {
			JTextField readingTextField = new JTextField();
			readingTextField.setText(reading.toString());
			readingTextField.setEditable(false); // Textfield is read-only
			panels.get(count).add(readingTextField);
			count++;
		}

		PanelAndFrame.setupFrame(frame, panels, menuBar);
	}

	/**
	 * Setter for menuBar
	 * 
	 * @param menuBar
	 */
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * Setup the frame for the view
	 */
	public void setupFrame() {
		// Setup the frames and panels
		PanelAndFrame.setupFrame(frame, panels, menuBar);
	}

	/**
	 * Getter for frame
	 * 
	 * @return the frame of this view
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Getter for the ArrayList having panels
	 * 
	 * @return the panels ArrayList
	 */
	public ArrayList<JPanel> getPanels() {
		return panels;
	}

	/**
	 * Getter for the menuBar
	 * 
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * Listener for the back button
	 * 
	 * @param listenForButtonShowInfo
	 *            the actionListener to listen for showInfo button
	 */
	public void addButtonBackInfoListener(ActionListener listenForButtonBack) {
		buttonBack.addActionListener(listenForButtonBack);
	}

	/**
	 * Visibility setter for the frame
	 * 
	 * @param b
	 *            the boolean value to set visibility of the frame
	 */
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

}
