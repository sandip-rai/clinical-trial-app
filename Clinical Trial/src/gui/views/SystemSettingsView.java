package gui.views;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentListener;

import gui.MenuBar;
import gui.PanelAndFrame;
import trial.ClinicalTrial;
import trial.SystemSettings;

/**
 * The Class SystemSettingsView.
 */
public class SystemSettingsView implements View {
	
	/** The global lable. */
	private JLabel globalLable = new JLabel("Global Settings");
	
	/** The date format lable. */
	private JLabel dateFormatLable = new JLabel("Date Format");
	
	/** The date format. */
	private JTextField dateFormat = new JTextField(16);
	
	/** The check box add clinics. */
	private JCheckBox checkBoxAddClinics = new JCheckBox(
			"Add clinics and readings from unknown clinics to the trial when importing.");

	/** The json lable. */
	private JLabel jsonLable = new JLabel("JSON Settings");
	
	/** The check box json patients. */
	private JCheckBox checkBoxJsonPatients = new JCheckBox("Add patients to the trial when importing from JSON files.");
	
	/** The check box json readings. */
	private JCheckBox checkBoxJsonReadings = new JCheckBox(
			"Add Readings from unkown patients imported from JSON files.");

	/** The xml lable. */
	private JLabel xmlLable = new JLabel("XML Settings");
	
	/** The check box xml patients. */
	private JCheckBox checkBoxXmlPatients = new JCheckBox(
			"Add unknown patients to the trial when importing from XML files.");
	
	/** The check box xml readings. */
	private JCheckBox checkBoxXmlReadings = new JCheckBox("Add readings from unkown patients imported from XML files.");
	
	/** The button reset. */
	private JButton buttonReset = new JButton("Reset to Default Settings");
	
	/** The number of panels. */
	// number of panels
	final int NUMBER_OF_PANELS = 12;
	
	/** The panels. */
	ArrayList<JPanel> panels;
	
	/** The menu bar. */
	MenuBar menuBar;

	/** The frame. */
	// Create JFrame
	private JFrame frame = new JFrame();

	/**
	 * Instantiates a new system settings view.
	 */
	public SystemSettingsView() {
		// Create JPanels
		panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
		// Adding the textField and upload button to the panels
		panels.get(0).add(buttonReset);
		panels.get(1).add(globalLable);
		panels.get(2).add(dateFormatLable);
		panels.get(2).add(dateFormat);
		panels.get(3).add(checkBoxAddClinics);
		panels.get(5).add(jsonLable);
		panels.get(6).add(checkBoxJsonPatients);
		panels.get(7).add(checkBoxJsonReadings);
		panels.get(9).add(xmlLable);
		panels.get(10).add(checkBoxXmlPatients);
		panels.get(11).add(checkBoxXmlReadings);

	}

	/**
	 * Sets the menu bar.
	 *
	 * @param menuBar the new menu bar
	 */
	// setter for menuBar
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * Sets the up frame.
	 *
	 * @param clinicalTrial the new up frame
	 */
	// setup Frame
	public void setupFrame(ClinicalTrial clinicalTrial) {
		//Get SystemSettings and use them to initialize local variables
		SystemSettings settings = clinicalTrial.getSettings();
		boolean addClinic = settings.addUnknownClinics();
		boolean jsonPatients = settings.jsonAddUnknownPatients();
		boolean jsonReadings = settings.jsonAddUnknownReadings();
		boolean xmlPatients = settings.xmlAddUnknownPatients();
		boolean xmlReadings = settings.xmlAddUnknownReadings();
		String dateFormat = settings.getDateFormat();
		//Initiate the check boxes based on current SystemSettings
		checkBoxAddClinics.setSelected(addClinic);
		checkBoxJsonPatients.setSelected(jsonPatients);
		checkBoxJsonReadings.setSelected(jsonReadings);
		checkBoxXmlPatients.setSelected(xmlPatients);
		checkBoxXmlReadings.setSelected(xmlReadings);
		if (!jsonPatients) {
			checkBoxJsonReadings.setEnabled(false);
		}
		if (!xmlPatients) {
			checkBoxXmlReadings.setEnabled(false);
		}
		//Set the date format based on system settings
		this.dateFormat.setText(dateFormat);
		PanelAndFrame.setupFrame(frame, panels, menuBar);
	}

	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	// getter for frame
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Gets the panels.
	 *
	 * @return the panels
	 */
	// getter for panels
	public ArrayList<JPanel> getPanels() {
		return panels;
	}

	/**
	 * Gets the menu bar.
	 *
	 * @return the menu bar
	 */
	// getter for menuBar
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * Display error message.
	 *
	 * @param component the component
	 * @param listener the listener
	 */
	public void displayErrorMessage(Component component, String listener) {
		JOptionPane.showMessageDialog(component, listener);
	}

	/**
	 * Json add patient listener.
	 *
	 * @param listener the listener
	 */
	public void jsonAddPatientListener(ItemListener listener) {
		checkBoxJsonPatients.addItemListener(listener);
	}

	/**
	 * Json add reading listener.
	 *
	 * @param listener the listener
	 */
	public void jsonAddReadingListener(ItemListener listener) {
		checkBoxJsonReadings.addItemListener(listener);
	}

	/**
	 * Xml add patient listener.
	 *
	 * @param listener the listener
	 */
	public void xmlAddPatientListener(ItemListener listener) {
		checkBoxXmlPatients.addItemListener(listener);
	}

	/**
	 * Xml add reading listener.
	 *
	 * @param listener the listener
	 */
	public void xmlAddReadingListener(ItemListener listener) {
		checkBoxXmlReadings.addItemListener(listener);
	}
	
	/**
	 * Adds the clinics listener.
	 *
	 * @param listener the listener
	 */
	public void addClinicsListener(ItemListener listener) {
		checkBoxAddClinics.addItemListener(listener);
	}
	
	/**
	 * Date format listener.
	 *
	 * @param listener the listener
	 */
	public void dateFormatListener(DocumentListener listener) {
		dateFormat.getDocument().addDocumentListener(listener);
	}
	
	/**
	 * Button reset listener.
	 *
	 * @param listener the listener
	 */
	public void buttonResetListener(ActionListener listener) {
        buttonReset.addActionListener(listener);
    }

	/**
	 * Gets the check box json readings.
	 *
	 * @return the check box json readings
	 */
	public JCheckBox getCheckBoxJsonReadings() {
		return checkBoxJsonReadings;
	}
	
	/**
	 * Gets the check box json patients.
	 *
	 * @return the check box json patients
	 */
	public JCheckBox getCheckBoxJsonPatients() {
		return checkBoxJsonPatients;
	}
	
	/**
	 * Gets the check box xml patients.
	 *
	 * @return the check box xml patients
	 */
	public JCheckBox getCheckBoxXmlPatients() {
		return checkBoxXmlPatients;
	}

	/**
	 * Gets the check box xml readings.
	 *
	 * @return the check box xml readings
	 */
	public JCheckBox getCheckBoxXmlReadings() {
		return checkBoxXmlReadings;
	}

	/* (non-Javadoc)
	 * @see gui.views.View#setVisible(java.lang.Boolean)
	 */
	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

	/**
	 * Gets the check box add clinics.
	 *
	 * @return the check box add clinics
	 */
	public JCheckBox getCheckBoxAddClinics() {
		return checkBoxAddClinics;
	}
	
	/**
	 * Gets the date format.
	 *
	 * @return the date format
	 */
	public JTextField getDateFormat() {
		return dateFormat;
		
	}
	
}
