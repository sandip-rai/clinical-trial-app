package views;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.MenuBar;
import gui.PanelAndFrame;
import trial.ClinicalTrial;

public class ClinicView implements View {
	//create labels buttons and textfields
	private JLabel clinicNameLabel = new JLabel("Clinic Name:");
    private JTextField clinicName = new JTextField(16);
	private JLabel clinicIdLabel = new JLabel("Clinic Id (optional):");
    private JTextField clinicId = new JTextField(16);
    private JButton buttonAddClinic = new JButton("Add Clinic");
    private JTextField addClinicText = new JTextField("Click Add button to add new Patient");
	private JButton buttonBack = new JButton("Back");
    
    //create a array list to hold all the panels
    private final int NUMBER_OF_PANELS = 4;
    private ArrayList<JPanel> panels;
    
    MenuBar menuBar;
    //Create JFrame
    private JFrame frame = new JFrame();
    
    public ClinicView(ClinicalTrial clinicalTrial){
    	addClinicText.setEditable(false);
    	// Create JPanels
    	panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
    	// Adding the textField and upload button to the panels
        panels.get(0).add(addClinicText);
        panels.get(1).add(clinicNameLabel);
        panels.get(1).add(clinicName);
        panels.get(2).add(clinicIdLabel);
        panels.get(2).add(clinicId);
        panels.get(3).add(buttonAddClinic);
        panels.get(3).add(buttonBack);
        //Setup Frame
        PanelAndFrame.setupFrame(frame, panels, menuBar);
    }
    
    public void setupFrame(){
        //setup Frame
        PanelAndFrame.setupFrame(frame, panels, menuBar);
    }
    
    //getter for frame
	public JFrame getFrame() {
		return frame;
	}
    
    //setter for menuBar
    public void setMenuBar(MenuBar menuBar){
    	this.menuBar = menuBar;
    }    
    
    public void addButtonAddClinicListener(ActionListener listenForButtonAdd) {
    	buttonAddClinic.addActionListener(listenForButtonAdd);
    }

    public void addButtonBackListener(ActionListener listenForButtonBack) {
    	buttonBack.addActionListener(listenForButtonBack);
    }

    public void displayErrorMessage(Component component, String errorMessage) {
        JOptionPane.showMessageDialog(component, errorMessage);
    }
    
	@Override
	public void setVisible(Boolean visible) {
		frame.setVisible(visible);
	}

	public JLabel getClinicNameLabel() {
		return clinicNameLabel;
	}

	public void setClinicNameLabel(JLabel clinicNameLabel) {
		this.clinicNameLabel = clinicNameLabel;
	}

	public JTextField getClinicName() {
		return clinicName;
	}

	public void setClinicName(JTextField clinicName) {
		this.clinicName = clinicName;
	}

	public JLabel getClinicIdLabel() {
		return clinicIdLabel;
	}

	public void setClinicIdLabel(JLabel clinicIdLabel) {
		this.clinicIdLabel = clinicIdLabel;
	}

	public JTextField getClinicId() {
		return clinicId;
	}

	public void setClinicId(JTextField clinicId) {
		this.clinicId = clinicId;
	}

}
