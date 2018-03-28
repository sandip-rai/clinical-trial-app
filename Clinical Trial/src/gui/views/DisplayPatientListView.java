package gui.views;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import gui.MenuBar;
import gui.PanelAndFrame;
import trial.*;

/**
 * The Class DisplayPatientListView.
 */
public class DisplayPatientListView {
	
	/** The combo box patients. */
	private JComboBox<Patient> comboBoxPatients = new JComboBox<Patient>();
	
	/** The patient is active. */
	// Create labels and buttons
	JCheckBox patientIsActive = new JCheckBox("Active");
	
	/** The patient info. */
	JTextArea patientInfo = new JTextArea();

	/** The number of panels. */
	// Create an ArrayList to hold all panels
	final int NUMBER_OF_PANELS = 1;
	
	/** The panels. */
	ArrayList<JPanel> panels;
	
	/** The menu bar. */
	MenuBar menuBar; // Initializing the menubar of the gui package

	/** The frame. */
	// Create JFrame
	private JFrame frame = new JFrame();

	/**
	 * Constructor.
	 *
	 * @param clinicalTrial the clinical trial
	 */
	public DisplayPatientListView(ClinicalTrial clinicalTrial) {
		// Create JPanels
		panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);

		
		panels.get(0).add(comboBoxPatients);
		panels.get(0).add(patientIsActive);
		panels.get(0).add(patientInfo);

	}

	/**
	 * Setter for menuBar.
	 *
	 * @param menuBar the new menu bar
	 */
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * Setup the frame for the view.
	 *
	 * @param clinicalTrial the new up frame
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
		if((Patient) comboBoxPatients.getSelectedItem() != null){
			patientIsActive.setSelected(((Patient)comboBoxPatients.getSelectedItem()).isActive());
			String format = clinicalTrial.getSettings().getDateFormat();
			String text =  ((Patient) comboBoxPatients.getSelectedItem()).toString(format);
			patientInfo.setText(text);
		}
		comboBoxPatients.setRenderer(new PatientRenderer());
		patientInfo.setEditable(false);
		// Setup the frames and panels
		PanelAndFrame.setupFrame(frame, panels, menuBar);
	}

	/**
	 * Getter for frame.
	 *
	 * @return the frame of this view
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Getter for the ArrayList having panels.
	 *
	 * @return the panels ArrayList
	 */
	public ArrayList<JPanel> getPanels() {
		return panels;
	}

	/**
	 * Getter for the menuBar.
	 *
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * Getter for the comboBoxPatientsIds.
	 *
	 * @return the comboBox having the patient ids
	 */
	public JComboBox<Patient> getComboBoxPatients() {
		return comboBoxPatients;
	}

	/**
	 * Adds the combo box patients listener.
	 *
	 * @param ListenForPatientIds the listen for patient ids
	 */
	public void addComboBoxPatientsListener(ActionListener ListenForPatientIds) {
		comboBoxPatients.addActionListener(ListenForPatientIds);
	}

	/**
	 * Adds the patient is active listener.
	 *
	 * @param listenForPatientIsActive the listen for patient is active
	 */
	public void addPatientIsActiveListener(ItemListener listenForPatientIsActive) {
		patientIsActive.addItemListener(listenForPatientIsActive);
	}

	/**
	 * Visibility setter for the frame.
	 *
	 * @param b            the boolean value to set visibility of the frame
	 */
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

	/**
	 * Sets the active.
	 *
	 * @param checked the new active
	 */
	public void setActive(boolean checked) {
		patientIsActive.setSelected(checked);
	}
	
	/**
	 * Sets the patient info.
	 *
	 * @param text the new patient info
	 */
	public void setPatientInfo(String text) {
		patientInfo.setText(text);
	}
}
