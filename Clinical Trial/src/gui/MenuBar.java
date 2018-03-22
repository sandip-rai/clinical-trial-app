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
    
    /**
     * Listens to the main menuItem being clicked in the menu
     * @param listenForButtonMainMenu the actionListener to listen for the MainMenu in the menu
     */
    void addButtonMainMenuListener(ActionListener listenForButtonMainMenu) {
    	menuItemMainMenu.addActionListener(listenForButtonMainMenu);
    }
    
    /**
     * Listens to the manageFile item being clicked in the menu
     * @param listenForButtonManageFile the actionListener to listen for the manageFile in the menu
     */
    void addButtonManageFileListener(ActionListener listenForButtonManageFile) {
    	menuItemManageFile.addActionListener(listenForButtonManageFile);
    }
    
    /**
     * Listens to the patientInfo item being clicked in the menu
     * @param listenForPatientInfoMenuItem the actionListener to listen for the PatientInfo in the menu
     */
    void addButtonPatientInfoListener(ActionListener listenForPatientInfoMenuItem){
    	menuItemPatientInfo.addActionListener(listenForPatientInfoMenuItem);
    }
}
