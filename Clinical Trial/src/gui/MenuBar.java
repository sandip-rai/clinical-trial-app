package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
	// Create menu components
    JMenu menu = new JMenu("Menu");
    
    // Create and add menuItems to menu
    JMenuItem menuItemMainMenu = menu.add("Main Menu");
    JMenuItem menuItemPatientInfo = menu.add("Patient Info");
    JMenuItem menuItemManageFile = menu.add("Manage Files");
   
    //Contractor 
    public MenuBar(){
    	//Create a menuBar
    	super();
       
        // Add menu to menuBar
        this.add(menu);

        menuItemPatientInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //displayPatientList.displayPatientList();
            }
        });
    }
    void addButtonMainMenuListener(ActionListener listenForButtonMainMenu) {
    	menuItemMainMenu.addActionListener(listenForButtonMainMenu);
    }
    void addButtonManageFileListener(ActionListener listenForButtonManageFile) {
    	menuItemManageFile.addActionListener(listenForButtonManageFile);
    }
}
