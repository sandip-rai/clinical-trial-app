package gui.views;

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

/**
 * The Class MainMenuView.
 */
public class MainMenuView implements View {
    
    /** The combo box patients. */
    private JComboBox<Patient> comboBoxPatients = new JComboBox<>();
    
    /** The button start trial. */
    // buttons for the view
    private JButton buttonStartTrial = new JButton("Add new Patient");
    
    /** The button add reading. */
    private JButton buttonAddReading = new JButton("Save Reading");
    
    /** The button add clinic. */
    private JButton buttonAddClinic = new JButton("Add new Clinic");

    /** The reading types. */
    // Array to hold the reading types which will be showed in the comboBox
    private final String[] readingTypes = new String[]{"Weight", "Steps", "Temp", "Blood Pressure"};
    
    /** The combo box reading type. */
    private JComboBox<String> comboBoxReadingType = new JComboBox<String>(readingTypes);
    
    /** The combo box clinics. */
    private JComboBox<Clinic> comboBoxClinics = new JComboBox<Clinic>();

	/** The add reading. */
	// Creates labels and user input textFeild
    private JLabel addReading = new JLabel("Add a new reading:");
    
    /** The date. */
    private JLabel date = new JLabel("Date: ");
    
    /** The type. */
    private JLabel type = new JLabel("Type: ");
    
    /** The value. */
    private JLabel value = new JLabel("Value: ");
    
    /** The value input. */
    private JTextField valueInput = new JTextField(16);
	
	/** The date input. */
	private JTextField dateInput = new JTextField(16);
	
	/** The past reading display. */
	private JTextField pastReadingDisplay = new JTextField(16);

    /** The number of panels. */
    //create a array list to hold all the panels
    final int NUMBER_OF_PANELS = 7;
    
    /** The panels. */
    ArrayList<JPanel> panels;
    
    /** The menu bar. */
    MenuBar menuBar;
    
    /** The frame. */
    //Create JFrame
    private JFrame frame = new JFrame();


   /**
    * Instantiates a new main menu view.
    */
   public MainMenuView() {      
        // Set all labels not editable
        pastReadingDisplay.setEditable(false);
        
		// Create JPanels
        panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
        //add components to panels
        panels.get(0).add(addReading);
        panels.get(1).add(comboBoxPatients);
        panels.get(1).add(buttonStartTrial);
        panels.get(2).add(date);
        panels.get(2).add(dateInput);
        panels.get(3).add(type);
        panels.get(3).add(comboBoxReadingType);
        panels.get(4).add(value);
        panels.get(4).add(valueInput);
        panels.get(5).add(comboBoxClinics);
        panels.get(5).add(buttonAddClinic);
        panels.get(6).add(buttonAddReading);
        
    }
    
   /**
    * Sets the menu bar.
    *
    * @param menuBar the new menu bar
    */
   //setter for menuBar
   public void setMenuBar(MenuBar menuBar){
   	this.menuBar = menuBar;
   }
   
   /**
    * Sets the up frame.
    *
    * @param clinicalTrial the new up frame
    */
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
   
   /**
    * Gets the frame.
    *
    * @return the frame
    */
   //getter for frame
   public JFrame getFrame() {
		return frame;
	}
   
   /**
    * Gets the panels.
    *
    * @return the panels
    */
   //getter for panels
   public ArrayList<JPanel> getPanels() {
		return panels;
	}
   
   /**
    * Gets the menu bar.
    *
    * @return the menu bar
    */
   //getter for menuBar
   public MenuBar getMenuBar() {
		return menuBar;
	}
   
    /**
     * Gets the date input.
     *
     * @return the date input
     */
    //getter for dataInput
    public JTextField getDateInput() {
		return dateInput;
	}
    
    /**
     * Gets the value input.
     *
     * @return the value input
     */
    //getter for validInput
    public JTextField getValueInput() {
  		return valueInput;
  	}
    
    /**
     * Gets the combo box reading type.
     *
     * @return the combo box reading type
     */
    //getter for comboBoxReadingType
    public JComboBox<String> getComboBoxReadingType() {
		return comboBoxReadingType;
	}
    
    /**
     * Gets the combo box patients.
     *
     * @return the combo box patients
     */
    //getter for comboBoxPatientsIds
    public JComboBox<Patient> getComboBoxPatients(){
    	return comboBoxPatients;
    }

    /**
     * Adds the button start trial listener.
     *
     * @param listenForButtonStartTrial the listen for button start trial
     */
    public void addButtonStartTrialListener(ActionListener listenForButtonStartTrial) {
        buttonStartTrial.addActionListener(listenForButtonStartTrial);
    }

    /**
     * Adds the button add reading listener.
     *
     * @param listenForButtonAddReading the listen for button add reading
     */
    public void addButtonAddReadingListener(ActionListener listenForButtonAddReading) {
        buttonAddReading.addActionListener(listenForButtonAddReading);
    }
    
    /**
     * Adds the button add clinic listener.
     *
     * @param listenForButtonAddClinic the listen for button add clinic
     */
    public void addButtonAddClinicListener(ActionListener listenForButtonAddClinic) {
    	buttonAddClinic.addActionListener(listenForButtonAddClinic);
    }

    /**
     * Display error message.
     *
     * @param component the component
     * @param errorMessage the error message
     */
    public void displayErrorMessage(Component component, String errorMessage) {
        JOptionPane.showMessageDialog(component, errorMessage);
    }

	/* (non-Javadoc)
	 * @see gui.views.View#setVisible(java.lang.Boolean)
	 */
	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

	/**
	 * Gets the combo box clinics.
	 *
	 * @return the combo box clinics
	 */
	public JComboBox<Clinic> getComboBoxClinics() {
		return comboBoxClinics;
	}
}
