package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    public JMenuBar makeMenuBar(){
        // Create menu components
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        // Add menus to menu bar
        menuBar.add(menu);

        // Create and add menuItems to menu
        JMenuItem mainMenu = menu.add("Main Menu");
        JMenuItem patientInfo = menu.add("Patient Info");
        JMenuItem manageFile = menu.add("Manage Files");

        mainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //gui.disposeFrame();
                MainMenu.mainMenu();
            }
        });

        patientInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DisplayPatientList.displayPatientList();
            }
        });

        manageFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManageFile.manageFile();
            }
        });

        return menuBar;
    }
}
