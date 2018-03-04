package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    public JMenuBar makeMenuBar(){
        Gui gui = new Gui();
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
                gui.mainMenu();
            }
        });

        patientInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.displayPatientList();
            }
        });

        manageFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.manageFile();
            }
        });

        return menuBar;
    }
}
