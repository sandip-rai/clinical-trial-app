package views;

import trial.Clinic;
import trial.ClinicRenderer;
import trial.ClinicalTrial;
import trial.Patient;
import trial.PatientRenderer;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;

import gui.MenuBar;
import gui.PanelAndFrame;

import java.util.ArrayList;
import java.util.Date;

public class MainMenuView implements View {
    private JComboBox<Patient> comboBoxPatients = new JComboBox<>();
    // buttons for the view
    private JButton buttonStartTrial = new JButton("Add new Patient");
    private JButton buttonAddReading = new JButton("Save Reading");
    private JButton buttonAddClinic = new JButton("Add new Clinic");

    // Array to hold the reading types which will be showed in the comboBox
    private final String[] readingTypes = new String[]{"Weight", "Steps", "Temp", "Blood Pressure"};
    private JComboBox<String> comboBoxReadingType = new JComboBox<String>(readingTypes);
    private JComboBox<Clinic> comboBoxClinics = new JComboBox<Clinic>();

	// Creates labels and user input textFeild
    private JLabel addReading = new JLabel("Add a new reading:");
    private JLabel id = new JLabel("Reading ID: ");
    private JLabel date = new JLabel("Date: ");
    private JLabel type = new JLabel("Type: ");
    private JLabel value = new JLabel("Value: ");
    private JTextField valueInput = new JTextField(16);
	private JTextField idInput = new JTextField(16);
	private JTextField dateInput = new JTextField(16);
	private JTextField pastReadingDisplay = new JTextField(16);

    //create a array list to hold all the panels
    final int NUMBER_OF_PANELS = 8;
    ArrayList<JPanel> panels;
    MenuBar menuBar;
    //Create JFrame
    private JFrame frame = new JFrame();


   public MainMenuView() {      
        // Set all labels not editable
        pastReadingDisplay.setEditable(false);
        
		// Create JPanels
        panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
        //add components to panels
        panels.get(0).add(addReading);
        panels.get(1).add(comboBoxPatients);
        panels.get(1).add(buttonStartTrial);
        panels.get(2).add(id);
        panels.get(2).add(idInput);
        panels.get(3).add(date);
        panels.get(3).add(dateInput);
        panels.get(4).add(type);
        panels.get(4).add(comboBoxReadingType);
        panels.get(5).add(value);
        panels.get(5).add(valueInput);
        panels.get(6).add(comboBoxClinics);
        panels.get(6).add(buttonAddClinic);
        panels.get(7).add(buttonAddReading);
        
    }
    
   //setter for menuBar
   public void setMenuBar(MenuBar menuBar){
   	this.menuBar = menuBar;
   }
   
   //setup Frame
   @SuppressWarnings("unchecked")
public void setupFrame(ClinicalTrial clinicalTrial){
       comboBoxPatients.removeAllItems();
	   for (Patient patient : clinicalTrial.getAllPatients()) {
           comboBoxPatients.addItem(patient); // Fill the comboBox from the ClinicalTrial arrayList
       }
	   for (Clinic clinic : clinicalTrial.getAllClinics()) {
		   comboBoxClinics.addItem(clinic); // Fill the comboBox from the ClinicalTrial arrayList
       }
	   comboBoxPatients.setRenderer(new PatientRenderer());
	   comboBoxClinics.setRenderer(new ClinicRenderer());
	   Date date = new Date();
	   String dateFormat = clinicalTrial.getSettings().getDateFormat();
	   SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
	   dateInput.setText(formatter.format(date));
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
   
    //getter for dataInput
    public JTextField getDateInput() {
		return dateInput;
	}
    
    //getter for validInput
    public JTextField getValueInput() {
  		return valueInput;
  	}

    //getter for idInput
    public JTextField getIdInput() {
		return idInput;
	}
    
    //getter for comboBoxReadingType
    public JComboBox<String> getComboBoxReadingType() {
		return comboBoxReadingType;
	}
    
    //getter for comboBoxPatientsIds
    public JComboBox<Patient> getComboBoxPatients(){
    	return comboBoxPatients;
    }

    public void addButtonStartTrialListener(ActionListener listenForButtonStartTrial) {
        buttonStartTrial.addActionListener(listenForButtonStartTrial);
    }

    public void addButtonAddReadingListener(ActionListener listenForButtonAddReading) {
        buttonAddReading.addActionListener(listenForButtonAddReading);
    }
    
    public void addButtonAddClinicListener(ActionListener listenForButtonAddClinic) {
    	buttonAddClinic.addActionListener(listenForButtonAddClinic);
    }

    public void displayErrorMessage(Component component, String errorMessage) {
        JOptionPane.showMessageDialog(component, errorMessage);
    }

	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

	public JComboBox<Clinic> getComboBoxClinics() {
		return comboBoxClinics;
	}
}
