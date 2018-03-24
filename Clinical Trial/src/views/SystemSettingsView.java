package views;

import java.awt.Component;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.MenuBar;
import gui.PanelAndFrame;
import trial.ClinicalTrial;
import trial.SystemSettings;

public class SystemSettingsView implements View {
	//Check boxes
    JCheckBox checkBoxJsonPatients = new JCheckBox("Add patients to the trial when importing from JSON files.");
    JCheckBox checkBoxJsonReadings = new JCheckBox("Add Readings from unkown patients importing from JSON files");
    JCheckBox checkBoxXmlPatients= new JCheckBox("Add unknown patients to the trial when importing from XML files");
    JCheckBox checkBoxXmlReadings = new JCheckBox("Add Readings from unkown patients importing from XML files");
    
    //number of panels
    final int NUMBER_OF_PANELS = 4;
    ArrayList<JPanel> panels;
    MenuBar menuBar;
    
    //Create JFrame
    private JFrame frame = new JFrame();
    
    public SystemSettingsView(ClinicalTrial clinicalTrial){
    	//initialize check boxes
    	SystemSettings settings = clinicalTrial.getSettings();
    	boolean jsonPatients = settings.jsonAddUnknownPatients();
    	boolean jsonReadings = settings.jsonAddUnknownReadings();
    	boolean xmlPatients = settings.xmlAddUnknownPatients();
    	boolean xmlReadings = settings.xmlAddUnknownReadings();
    	 checkBoxJsonPatients.setSelected(jsonPatients);
    	 checkBoxJsonReadings.setSelected(jsonReadings);
    	 checkBoxXmlPatients.setSelected(xmlPatients);
    	 checkBoxXmlReadings.setSelected(xmlReadings);
    	 //All check boxes appear the the right of their description.
    	 checkBoxJsonPatients.setHorizontalTextPosition(SwingConstants.LEFT);
    	 checkBoxJsonReadings.setHorizontalTextPosition(SwingConstants.LEFT);
    	 checkBoxXmlPatients.setHorizontalTextPosition(SwingConstants.LEFT);
    	 checkBoxXmlReadings.setHorizontalTextPosition(SwingConstants.LEFT);
    	// Create JPanels
        panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
    	// Adding the textField and upload button to the panels
        panels.get(0).add(checkBoxJsonPatients);
        panels.get(1).add(checkBoxJsonReadings);
        panels.get(2).add(checkBoxXmlPatients);
        panels.get(3).add(checkBoxXmlReadings);
    }
    
    //setter for menuBar
    public void setMenuBar(MenuBar menuBar){
    	this.menuBar = menuBar;
    }
    
    //setup Frame
    public void setupFrame(){
       PanelAndFrame.setupFrame(frame, panels, menuBar);
    }
    
    //getter for frame
    public JFrame getFrame() {
 		return frame;
 	}
    
    //getter for panels
    public ArrayList<JPanel> getPanels() {
 		return panels;
 	}
    
    //getter for menuBar
    public MenuBar getMenuBar() {
 		return menuBar;
 	}

    public void displayErrorMessage(Component component, String errorMessage) {
        JOptionPane.showMessageDialog(component, errorMessage);
    }
    
    public void jsonAddPatientListener(ItemListener listenForAddPatient) {
    	checkBoxJsonPatients.addItemListener(listenForAddPatient);
    }
    
    public void jsonAddReadingListener(ItemListener listenForAddPatient) {
    	checkBoxJsonReadings.addItemListener(listenForAddPatient);
    }
    
    public void xmlAddPatientListener(ItemListener listenForAddPatient) {
    	checkBoxXmlPatients.addItemListener(listenForAddPatient);
    }
    
    public void xmlAddReadingListener(ItemListener listenForAddPatient) {
    	checkBoxXmlReadings.addItemListener(listenForAddPatient);
    }
    
	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

}
