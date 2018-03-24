package gui;

/**
 * Gui class to show options to add, show patients list, and get input file from the user.
 */

import javax.swing.*;
import listeners.*;
import views.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PanelAndFrame {

	static final int FRAME_ROWS = 0;
	static final int FRAME_COLS = 1;

    public static ArrayList<JPanel> setupPanels(int size) {
    	ArrayList<JPanel> tempPanels = new ArrayList<JPanel>();
		for (int i = 0; i <size; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());
			tempPanels.add(panel);
		}
		return tempPanels;
	}

	/**
	 * use it to setup frame
	 */
	public static void setupFrame(JFrame frame, ArrayList<JPanel> panels, MenuBar menuBar) {
		frame.setLayout(new GridLayout(FRAME_ROWS, FRAME_COLS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		for (JPanel panel : panels) {
			frame.add(panel);
		}
		frame.pack();
		frame.setLocation(150, 150);
		frame.setVisible(false);
	}

   public static void hideFrame(ActionEvent e) {
	   JFrame frame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
	   frame.setVisible(false);
    }
   
   public static void hideCurrentFrameAndGoToNextFrame(JFrame frame, View view) {
	   frame.setVisible(false);
	   view.setVisible(true);
    }
   
   public static void diposeFrame(JFrame frame){
	   frame.dispose();
   }
   
   public static MenuBar supplyMenuBar(GuiController guiController){
	   MenuBar menuBar = new MenuBar();
	   menuBar.addButtonMainMenuListener(new ButtonMainMenuListener(guiController));
	   menuBar.addButtonManageFileListener(new ButtonManageFileListener(guiController));
	   menuBar.addButtonPatientInfoListener(new ButtonPatientInfoListener(guiController));
	   menuBar.addButtonSaveState(new ButtonSaveState(guiController));
	   menuBar.addButtonImportListener(new ButtonExitProgram(guiController));
	   menuBar.addButtonExportListener(new ButtonExportListener(guiController));
	   menuBar.addButtonExitProgram(new ButtonExitProgram(guiController));
	   return menuBar;
   }
   
}
