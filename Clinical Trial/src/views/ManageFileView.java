package views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.MenuBar;
import gui.PanelAndFrame;

public class ManageFileView implements View {
	//buttons
	JButton buttonUpload = new JButton("Upload a json file");
    JButton buttonSave = new JButton("Save as a json file");
    
    //number of panels
    final int NUMBER_OF_PANELS = 1;
    ArrayList<JPanel> panels;
    MenuBar menuBar;
    
    //Create JFrame
    private JFrame frame = new JFrame();
    
    public ManageFileView(){
    	// Create JPanels
        panels = PanelAndFrame.setupPanels(NUMBER_OF_PANELS);
    	// Adding the textField and upload button to the panels
        panels.get(0).add(buttonUpload);
        panels.get(0).add(buttonSave);
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
    
    public void addButtonUploadListener(ActionListener listenForButtonUploadl) {
    	buttonUpload.addActionListener(listenForButtonUploadl);
    }

    public void addButtonSaveListener(ActionListener listenForButtonSave) {
    	buttonSave.addActionListener(listenForButtonSave);
    }

    public void displayErrorMessage(Component component, String errorMessage) {
        JOptionPane.showMessageDialog(component, errorMessage);
    }
    
	@Override
	public void setVisible(Boolean b) {
		frame.setVisible(b);
	}

}
