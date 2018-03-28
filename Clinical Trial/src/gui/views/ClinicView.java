package gui.views;

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

/**
 * The Class ClinicView.
 */
public class ClinicView implements View {
	
	/** The clinic name label. */
	//create labels buttons and textfields
	private JLabel clinicNameLabel = new JLabel("Clinic Name:");
    
    /** The clinic name. */
    private JTextField clinicName = new JTextField(16);
	
	/** The clinic id label. */
	private JLabel clinicIdLabel = new JLabel("Clinic Id (optional):");
    
    /** The clinic id. */
    private JTextField clinicId = new JTextField(16);
    
    /** The button add clinic. */
    private JButton buttonAddClinic = new JButton("Add Clinic");
    
    /** The add clinic text. */
    private JTextField addClinicText = new JTextField("Click Add button to add new Clinic");
	
	/** The button back. */
	private JButton buttonBack = new JButton("Back");
    
    /** The number of panels. */
    //create a array list to hold all the panels
    private final int NUMBER_OF_PANELS = 4;
    
    /** The panels. */
    private ArrayList<JPanel> panels;
    
    /** The menu bar. */
    MenuBar menuBar;
    
    /** The frame. */
    //Create JFrame
    private JFrame frame = new JFrame();
    
    /**
     * Instantiates a new clinic view.
     *
     * @param clinicalTrial the clinical trial
     */
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
    
    /**
     * Setup frame.
     */
    public void setupFrame(){
        //setup Frame
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
     * Sets the menu bar.
     *
     * @param menuBar the new menu bar
     */
    //setter for menuBar
    public void setMenuBar(MenuBar menuBar){
    	this.menuBar = menuBar;
    }    
    
    /**
     * Adds the button add clinic listener.
     *
     * @param listenForButtonAdd the listen for button add
     */
    public void addButtonAddClinicListener(ActionListener listenForButtonAdd) {
    	buttonAddClinic.addActionListener(listenForButtonAdd);
    }

    /**
     * Adds the button back listener.
     *
     * @param listenForButtonBack the listen for button back
     */
    public void addButtonBackListener(ActionListener listenForButtonBack) {
    	buttonBack.addActionListener(listenForButtonBack);
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
	public void setVisible(Boolean visible) {
		frame.setVisible(visible);
	}

	/**
	 * Gets the clinic name label.
	 *
	 * @return the clinic name label
	 */
	public JLabel getClinicNameLabel() {
		return clinicNameLabel;
	}

	/**
	 * Sets the clinic name label.
	 *
	 * @param clinicNameLabel the new clinic name label
	 */
	public void setClinicNameLabel(JLabel clinicNameLabel) {
		this.clinicNameLabel = clinicNameLabel;
	}

	/**
	 * Gets the clinic name.
	 *
	 * @return the clinic name
	 */
	public JTextField getClinicName() {
		return clinicName;
	}

	/**
	 * Sets the clinic name.
	 *
	 * @param clinicName the new clinic name
	 */
	public void setClinicName(JTextField clinicName) {
		this.clinicName = clinicName;
	}

	/**
	 * Gets the clinic id label.
	 *
	 * @return the clinic id label
	 */
	public JLabel getClinicIdLabel() {
		return clinicIdLabel;
	}

	/**
	 * Sets the clinic id label.
	 *
	 * @param clinicIdLabel the new clinic id label
	 */
	public void setClinicIdLabel(JLabel clinicIdLabel) {
		this.clinicIdLabel = clinicIdLabel;
	}

	/**
	 * Gets the clinic id.
	 *
	 * @return the clinic id
	 */
	public JTextField getClinicId() {
		return clinicId;
	}

	/**
	 * Sets the clinic id.
	 *
	 * @param clinicId the new clinic id
	 */
	public void setClinicId(JTextField clinicId) {
		this.clinicId = clinicId;
	}
	
	/**
	 * Gets the adds the clinic text.
	 *
	 * @return the adds the clinic text
	 */
	public JTextField getAddClinicText() {
		return addClinicText;
	}

}
