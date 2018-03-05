package gui;

/**
 * Gui class to show options to add, show patients list, and get input file from the user.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelAndFrame extends JPanel {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame;
    static MenuBar menuBar = new MenuBar(); //Create the MenuBar


	static ArrayList<JPanel> panels;
	
	static final int PANEL_ROWS = 0;
	static final int PANEL_COLS = 3;
	static final int PANEL_HGAP = 10;
	static final int PANEL_VGAP = 10;

	static final int FRAME_ROWS = 6;
	static final int FRAME_COLS = 6;
	static final int FRAME_HGAP = 32;
	static final int FRAME_VGAP = 32;

    public static void setupPanel(int numberOfPanels) {
		panels = new ArrayList<JPanel>();
		for (int i = 0; i < numberOfPanels; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(PANEL_ROWS, PANEL_COLS, PANEL_HGAP, PANEL_VGAP));
			panels.add(panel);
		}
	}

	/**
	 * use it to setup frame
	 */
	public static void setupFrame() {
		frame = new JFrame();
		frame.setLayout(new GridLayout(FRAME_ROWS, FRAME_COLS, FRAME_HGAP, FRAME_VGAP));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar.makeMenuBar());
		for (JPanel panel : panels) {
			frame.add(panel);
		}
		frame.pack();
		frame.setLocation(150, 150);
		frame.setVisible(true);
	}

   public static void disposeFrame() {
        frame.dispose();
    }
}
