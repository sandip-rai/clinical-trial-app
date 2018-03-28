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

/**
 * The Class AddPatientView.
 */
public class AddPatientView implements View {
	
	/** The label. */
	//create labels buttons and textfields
	JLabel label = new JLabel("PatientID:");
    
    /** The input text. */
    JTextField inputText = new JTextField(16);
    
    /** The button add. */
    JButton buttonAdd = new JButton("Add");
    
    /** The add patient state. */
    JTextField addPatientState = new JTextField("Click Add button to add new Patient");
	
	/** The button back. */
	JButton buttonBack = new JButton("Back");
    
    /** The number of panels. */
    //create a array list to hold all the panels
    private final int NUMBER_OF_PANELS = 3;
    
    /** The panels. */
    private ArrayList<JPanel> panels;
    
    /** The menu bar. */
    MenuBar menuBar;
    
    /** The frame. */
    //Create JFrame
    private JFrame frame = new JFrame();
    
    /**
     * Instantiates a new adds the patient view.
     */
    public AddPatientView(){
    	addPatientState.setEditable(false);
    	// Create JPanels
    	panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
    	// Adding the textField and upload button to the panels
        panels.get(0).add(addPatientState);
        panels.get(1).add(label);
        panels.get(1).add(inputText);
        panels.get(2).add(buttonAdd);
        panels.get(2).add(buttonBack);
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
     * Gets the input text.
     *
     * @return the input text
     */
    //getter for inputText
    public JTextField getInputText() {
		return inputText;
	}
    
    /**
     * Gets the adds the patient state.
     *
     * @return the adds the patient state
     */
    //getter for addPatientState
    public JTextField getAddPatientState() {
		return addPatientState;
	}

    /**
     * Adds the button add listener.
     *
     * @param listenForButtonAdd the listen for button add
     */
    public void addButtonAddListener(ActionListener listenForButtonAdd) {
    	buttonAdd.addActionListener(listenForButtonAdd);
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
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

}
