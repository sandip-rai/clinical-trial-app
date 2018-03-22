package views;

import trial.ClinicalTrial;
import trial.Patient;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.*;

import gui.MenuBar;
import gui.PanelAndFrame;

import java.util.ArrayList;

public class MainMenuView implements View {
    private JComboBox<String> comboBoxPatientsIds = new JComboBox<>();
    // buttons for the view
    private JButton buttonStartTrial = new JButton("Start Patient Trial");
    private JButton buttonAddReading = new JButton("Add");

    // Array to hold the reading types which will be showed in the comboBox
    private final String[] readingTypes = new String[]{"Weight", "Steps", "Temp", "Blood Pressure"};
    private JComboBox<String> comboBoxReadingType = new JComboBox<String>(readingTypes);

	// Creates labels and user input textFeild
    private JLabel addReading = new JLabel("Add a new reading:");
    private JLabel id = new JLabel("Reading ID:");
    private JLabel date = new JLabel("Reading Date:");
    private JLabel type = new JLabel("Reading Type:");
    private JLabel value = new JLabel("Reading Value:");
    private JTextField valueInput = new JTextField(16);
	private JTextField idInput = new JTextField(16);
	private JTextField dateInput = new JTextField(16);
	private JTextField pastReadingDisplay = new JTextField(16);

    //create a array list to hold all the panels
    final int NUMBER_OF_PANELS = 7;
    ArrayList<JPanel> panels;
    MenuBar menuBar;
    //Create JFrame
    private JFrame frame = new JFrame();


   public MainMenuView() {
	    
        comboBoxPatientsIds.addItem("New patient"); // Display New Patient for the dropdown list in the first place
        /**
        for (Patient patient : ClinicalTrial.getAllPatients()) {
            comboBoxPatientsIds.addItem(patient.getPatientId()); // Fill the comboBox from the ClinicalTrial arrayList
        }
        **/
        
        // Set all labels not editable
        pastReadingDisplay.setEditable(false);
        
		// Create JPanels
        panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
        //add components to panels
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
        
    }
    
   //setter for menuBar
   public void setMenuBar(MenuBar menuBar){
   	this.menuBar = menuBar;
   }
   
   //setup Frame
   public void setupFrame(){
       comboBoxPatientsIds.removeAllItems();
       comboBoxPatientsIds.addItem("New patient");
	   for (Patient patient : ClinicalTrial.getAllPatients()) {
           comboBoxPatientsIds.addItem(patient.getPatientId()); // Fill the comboBox from the ClinicalTrial arrayList
       }
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
    public JComboBox<String> getComboBoxPatientsIds(){
    	return comboBoxPatientsIds;
    }

    public void addButtonStartTrialListener(ActionListener listenForButtonStartTrial) {
        buttonStartTrial.addActionListener(listenForButtonStartTrial);
    }

    public void addButtonAddReadingListener(ActionListener listenForButtonAddReading) {
        buttonAddReading.addActionListener(listenForButtonAddReading);
    }

    public void displayErrorMessage(Component component, String errorMessage) {
        JOptionPane.showMessageDialog(component, errorMessage);
    }

	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}
}
