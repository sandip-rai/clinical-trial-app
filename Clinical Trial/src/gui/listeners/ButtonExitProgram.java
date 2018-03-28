package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;

/**
 * The Class ButtonExitProgram.
 */
public class ButtonExitProgram implements ActionListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new button exit program.
	 *
	 * @param guiController the gui controller
	 */
	public ButtonExitProgram(GuiController guiController){
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 guiController.getFileAdapter().saveState(guiController.getClinicalTrial());		
		System.exit(0);
	}

}
