package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

/**
 * The listener interface for receiving buttonMainMenu events.
 * The class that is interested in processing a buttonMainMenu
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonMainMenuListener<code> method. When
 * the buttonMainMenu event occurs, that object's appropriate
 * method is invoked.
 *
 *class for buttonBack to perform actionPerformed(ActionEvent e)
 *
 * @see ButtonMainMenuEvent
 */

public class ButtonMainMenuListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new button main menu listener.
	 *
	 * @param guiController the gui controller
	 */
	//constructor
	public ButtonMainMenuListener(GuiController guiController){
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.disposeAllViews();
		guiController.getMainMenuView().setupFrame(guiController.getClinicalTrial());
		guiController.getMainMenuView().setVisible(true);
	}

}
