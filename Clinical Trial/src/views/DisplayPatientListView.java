package views;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import gui.MenuBar;
import gui.PanelAndFrame;
import trial.*;

public class DisplayPatientListView {
	private JComboBox<Patient> comboBoxPatients = new JComboBox<Patient>();
	// Create labels and buttons
	JLabel label = new JLabel("Patients List: Select a Patient");
	JCheckBox patientIsActive = new JCheckBox("Active");
	JTextArea patientInfo = new JTextArea();

	// Create an ArrayList to hold all panels
	final int NUMBER_OF_PANELS = 3;
	ArrayList<JPanel> panels;
	MenuBar menuBar; // Initializing the menubar of the gui package

	// Create JFrame
	private JFrame frame = new JFrame();

	/**
	 * Constructor
	 */
	public DisplayPatientListView(ClinicalTrial clinicalTrial) {
		// Create JPanels
		panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);

		// Add components to the panels
		panels.get(0).add(label);
		panels.get(1).add(comboBoxPatients);
		panels.get(1).add(patientIsActive);
		panels.get(2).add(patientInfo);

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
	@SuppressWarnings("unchecked")
	public void setupFrame(ClinicalTrial clinicalTrial) {
		ArrayList<Patient> allPatients = clinicalTrial.getAllPatients();
		comboBoxPatients.removeAllItems();
		for (Patient patient : allPatients) {
			comboBoxPatients.addItem(patient);
		}
		// initialize patient data
		patientIsActive.setHorizontalTextPosition(SwingConstants.LEFT);
		patientIsActive.setSelected(((Patient)comboBoxPatients.getSelectedItem()).isActive());
		comboBoxPatients.setRenderer(new PatientRenderer());
		patientInfo.setText(comboBoxPatients.getSelectedItem().toString());
		patientInfo.setEditable(false);
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
	 * Getter for the comboBoxPatientsIds
	 * 
	 * @return the comboBox having the patient ids
	 */
	public JComboBox<Patient> getComboBoxPatients() {
		return comboBoxPatients;
	}

//	/**
//	 * Listener for the showInfo button
//	 * 
//	 * @param listenForButtonShowInfo
//	 *            the actionListener to listen for showInfo button
//	 */
//	public void addButtonShowInfoListener(ActionListener listenForButtonShowInfo) {
//		buttonShowInfo.addActionListener(listenForButtonShowInfo);
//	}

	public void addComboBoxPatientsListener(ActionListener ListenForPatientIds) {
		comboBoxPatients.addActionListener(ListenForPatientIds);
	}

	public void addPatientIsActiveListener(ItemListener listenForPatientIsActive) {
		patientIsActive.addItemListener(listenForPatientIsActive);
	}

	//
	// /**
	// * Listener for the endTrial Button
	// *
	// * @param listenForButtonEndTrial
	// * the actionListener to listen for endTrial button
	// */
	// public void addButtonEndTrialListener(ActionListener listenForButtonEndTrial)
	// {
	// buttonEndTrial.addActionListener(listenForButtonEndTrial);
	// }

	/**
	 * Visibility setter for the frame
	 * 
	 * @param b
	 *            the boolean value to set visibility of the frame
	 */
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

	public void setActive(boolean checked) {
		patientIsActive.setSelected(checked);
	}
	
	public void setPatientInfo(String text) {
		patientInfo.setText(text);
	}
}
