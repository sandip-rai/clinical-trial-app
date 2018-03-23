package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MenuBar;
import gui.PanelAndFrame;
import trial.ClinicalTrial;
import trial.Patient;

public class DisplayPatientListView {
	private JComboBox<String> comboBoxPatientsIds = new JComboBox<String>();
	private ArrayList<String> arrayListPatientsIds = new ArrayList<String>();
	// Create labels and buttons
	JLabel label = new JLabel("Patients List: Select a Patient");
	JButton buttonShowInfo = new JButton("Show Patient's Info");
	JButton buttonResumeTrial = new JButton("Resume Patient Trial");
	JButton buttonEndTrial = new JButton("End Patient Trial");

	// Create an ArrayList to hold all panels
	final int NUMBER_OF_PANELS = 2;
	ArrayList<JPanel> panels;
	MenuBar menuBar; // Initializing the menubar of the gui package

	// Create JFrame
	private JFrame frame = new JFrame();

	/**
	 * Constructor
	 */
	public DisplayPatientListView() {
		/**
		 * //Fill the comboBox with the list of patients in the ClinicalTrial
		 * for (Patient patient : ClinicalTrial.getAllPatients()) {
		 * comboBoxPatientsIds.addItem(patient.getPatientId()); }
		 **/

		// Create JPanels
		panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);

		// Add components to the panels
		panels.get(0).add(label);
		panels.get(1).add(comboBoxPatientsIds);
		panels.get(1).add(buttonResumeTrial);
		panels.get(1).add(buttonEndTrial);
		panels.get(1).add(buttonShowInfo);
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
	public void setupFrame(ClinicalTrial clinicalTrial){
		comboBoxPatientsIds.removeAllItems();
		for (Patient patient : clinicalTrial.getAllPatients()) {
			comboBoxPatientsIds.addItem(patient.getPatientId());
		}
		//Setup the frames and panels
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
	public JComboBox<String> getComboBoxPatientsIds() {
		return comboBoxPatientsIds;
	}

	/**
	 * Listener for the showInfo button
	 * 
	 * @param listenForButtonShowInfo
	 *            the actionListener to listen for showInfo button
	 */
	public void addButtonShowInfoListener(ActionListener listenForButtonShowInfo) {
		buttonShowInfo.addActionListener(listenForButtonShowInfo);
	}

	/**
	 * Listener for the resumeTrial button
	 * 
	 * @param listenForButtonResumeTrial
	 *            the actionListener to listen for resumeTrial button
	 */
	public void addButtonResumeTrialListener(ActionListener listenForButtonResumeTrial) {
		buttonResumeTrial.addActionListener(listenForButtonResumeTrial);
	}

	/**
	 * Listener for the endTrial Button
	 * 
	 * @param listenForButtonEndTrial
	 *            the actionListener to listen for endTrial button
	 */
	public void addButtonEndTrialListener(ActionListener listenForButtonEndTrial) {
		buttonEndTrial.addActionListener(listenForButtonEndTrial);
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
