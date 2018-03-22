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

public class AddPatientView implements View {
	//create labels buttons and textfields
	JLabel label = new JLabel("PatientID:");
    JTextField inputText = new JTextField(16);
    JButton buttonAdd = new JButton("Add");
    JTextField addPatientState = new JTextField("Click Add button to add new Patient");
	JButton buttonBack = new JButton("Back");
    
    //create a array list to hold all the panels
    private final int NUMBER_OF_PANELS = 3;
    private ArrayList<JPanel> panels;
    
    MenuBar menuBar;
    //Create JFrame
    private JFrame frame = new JFrame();
    
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
    
    //getter for inputText
    public JTextField getInputText() {
		return inputText;
	}
    
    //getter for addPatientState
    public JTextField getAddPatientState() {
		return addPatientState;
	}

    public void addButtonAddListener(ActionListener listenForButtonAdd) {
    	buttonAdd.addActionListener(listenForButtonAdd);
    }

    public void addButtonBackListener(ActionListener listenForButtonBack) {
    	buttonBack.addActionListener(listenForButtonBack);
    }

    public void displayErrorMessage(Component component, String errorMessage) {
        JOptionPane.showMessageDialog(component, errorMessage);
    }
    
	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

}
