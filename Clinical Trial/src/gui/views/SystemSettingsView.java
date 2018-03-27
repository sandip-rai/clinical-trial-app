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

public class SystemSettingsView implements View {
	private JLabel globalLable = new JLabel("Global Settings");
	private JLabel dateFormatLable = new JLabel("Date Format");
	private JTextField dateFormat = new JTextField(16);
	private JCheckBox checkBoxAddClinics = new JCheckBox(
			"Add unkown Clinics and Readings from unknown Clinics to the trial when importing from files.");

	private JLabel jsonLable = new JLabel("JSON Settings");
	private JCheckBox checkBoxJsonPatients = new JCheckBox("Add patients to the trial when importing from JSON files.");
	private JCheckBox checkBoxJsonReadings = new JCheckBox(
			"Add Readings from unkown patients imported from JSON files.");

	private JLabel xmlLable = new JLabel("XML Settings");
	private JCheckBox checkBoxXmlPatients = new JCheckBox(
			"Add unknown patients to the trial when importing from XML files.");
	private JCheckBox checkBoxXmlReadings = new JCheckBox("Add Readings from unkown patients imported from XML files.");
	private JButton buttonReset = new JButton("Reset to Default Settings");
	// number of panels
	final int NUMBER_OF_PANELS = 12;
	ArrayList<JPanel> panels;
	MenuBar menuBar;

	// Create JFrame
	private JFrame frame = new JFrame();

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

	// setter for menuBar
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	// setup Frame
	public void setupFrame(ClinicalTrial clinicalTrial) {
		// initialize check boxes
		SystemSettings settings = clinicalTrial.getSettings();
		boolean addClinic = settings.addUnknownClinics();
		boolean jsonPatients = settings.jsonAddUnknownPatients();
		boolean jsonReadings = settings.jsonAddUnknownReadings();
		boolean xmlPatients = settings.xmlAddUnknownPatients();
		boolean xmlReadings = settings.xmlAddUnknownReadings();
		checkBoxAddClinics.setSelected(addClinic);
		checkBoxJsonPatients.setSelected(jsonPatients);
		checkBoxJsonReadings.setSelected(jsonReadings);
		checkBoxXmlPatients.setSelected(xmlPatients);
		checkBoxXmlReadings.setSelected(xmlReadings);
		String dateFormat = settings.getDateFormat();
		this.dateFormat.setText(dateFormat);
		if (!jsonPatients) {
			checkBoxJsonReadings.setEnabled(false);
		}
		if (!xmlPatients) {
			checkBoxXmlReadings.setEnabled(false);
		}
		PanelAndFrame.setupFrame(frame, panels, menuBar);
	}

	// getter for frame
	public JFrame getFrame() {
		return frame;
	}

	// getter for panels
	public ArrayList<JPanel> getPanels() {
		return panels;
	}

	// getter for menuBar
	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void displayErrorMessage(Component component, String listener) {
		JOptionPane.showMessageDialog(component, listener);
	}

	public void jsonAddPatientListener(ItemListener listener) {
		checkBoxJsonPatients.addItemListener(listener);
	}

	public void jsonAddReadingListener(ItemListener listener) {
		checkBoxJsonReadings.addItemListener(listener);
	}

	public void xmlAddPatientListener(ItemListener listener) {
		checkBoxXmlPatients.addItemListener(listener);
	}

	public void xmlAddReadingListener(ItemListener listener) {
		checkBoxXmlReadings.addItemListener(listener);
	}
	
	public void addClinicsListener(ItemListener listener) {
		checkBoxAddClinics.addItemListener(listener);
	}
	
	public void dateFormatListener(DocumentListener listener) {
		dateFormat.getDocument().addDocumentListener(listener);
	}
	
	public void buttonResetListener(ActionListener listener) {
        buttonReset.addActionListener(listener);
    }

	public JCheckBox getCheckBoxJsonReadings() {
		return checkBoxJsonReadings;
	}
	
	public JCheckBox getCheckBoxJsonPatients() {
		return checkBoxJsonPatients;
	}
	
	public JCheckBox getCheckBoxXmlPatients() {
		return checkBoxXmlPatients;
	}

	public JCheckBox getCheckBoxXmlReadings() {
		return checkBoxXmlReadings;
	}

	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

	public JCheckBox getCheckBoxAddClinics() {
		return checkBoxAddClinics;
	}
	
	public JTextField getDateFormat() {
		return dateFormat;
		
	}
	
}
