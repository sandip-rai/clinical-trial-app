package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
	/**
	 * default UID
	 */
	private static final long serialVersionUID = 1L;

	// Create menu components
    JMenu menu = new JMenu("Menu");
    
    // Create and add menuItems to menu
    JMenuItem menuItemMainMenu = menu.add("Main Menu");
    JMenuItem menuItemPatientInfo = menu.add("Patient Info");
    JMenuItem menuItemManageFile = menu.add("Manage Files");
    JMenuItem menuItemSaveState = menu.add("Save");
    JMenuItem menuItemExitProgram = menu.add("Exit");
   
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
    
    /**
     * Listens to the save item being clicked in the menu
     * @param listenForSaveState the actionListener to listen for the PatientInfo in the menu
     */
    void addButtonSaveState(ActionListener listenForSaveState){
    	menuItemSaveState.addActionListener(listenForSaveState);
    }
    
    /**
     * Listens to the Exit item being clicked in the menu
     * @param listenForExitProgram the actionListener to listen for the PatientInfo in the menu
     */
    void addButtonExitProgram(ActionListener listenForExitProgram){
    	menuItemExitProgram.addActionListener(listenForExitProgram);
    }
}
