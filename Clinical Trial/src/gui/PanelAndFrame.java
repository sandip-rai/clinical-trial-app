package gui;

/**
 * Gui class to show options to add, show patients list, and get input file from the user.
 */

import javax.swing.*;

import gui.listeners.*;
import gui.views.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * The Class PanelAndFrame.
 */
public class PanelAndFrame {

	/** The Constant FRAME_ROWS. */
	static final int FRAME_ROWS = 0;
	
	/** The Constant FRAME_COLS. */
	static final int FRAME_COLS = 1;

    /**
     * Setup panels.
     *
     * @param size the size
     * @return the array list
     */
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
	 * use it to setup frame.
	 *
	 * @param frame the frame
	 * @param panels the panels
	 * @param menuBar the menu bar
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

   /**
    * Hide frame.
    *
    * @param e the e
    */
   public static void hideFrame(ActionEvent e) {
	   JFrame frame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
	   frame.setVisible(false);
    }
   
   /**
    * Hide current frame and go to next frame.
    *
    * @param frame the frame
    * @param view the view
    */
   public static void hideCurrentFrameAndGoToNextFrame(JFrame frame, View view) {
	   frame.setVisible(false);
	   view.setVisible(true);
    }
   
   /**
    * Dispose frame.
    *
    * @param frame the frame
    */
   public static void disposeFrame(JFrame frame){
	   frame.dispose();
   }
   
   /**
    * Supply menu bar.
    *
    * @param guiController the gui controller
    * @return the menu bar
    */
   public static MenuBar supplyMenuBar(GuiController guiController){
	   MenuBar menuBar = new MenuBar();
	   menuBar.addButtonMainMenuListener(new ButtonMainMenuListener(guiController));
	   menuBar.addButtonPatientInfoListener(new ButtonPatientInfoListener(guiController));
	   menuBar.addButtonImportListener(new ButtonImportListener(guiController));
	   menuBar.addButtonExportListener(new ButtonExportListener(guiController));
	   menuBar.addButtonSaveState(new ButtonSaveState(guiController));
	   menuBar.addButtonSystemSettingsListener(new ButtonSystemSettingsListener(guiController));
	   menuBar.addButtonExitProgram(new ButtonExitProgram(guiController));
	   return menuBar;
   }
   
}
