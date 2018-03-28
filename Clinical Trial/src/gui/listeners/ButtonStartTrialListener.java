package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;

/**
 * The listener interface for receiving buttonStartTrial events.
 * The class that is interested in processing a buttonStartTrial
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonStartTrialListener<code> method. When
 * the buttonStartTrial event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonStartTrialEvent
 */
//class for buttonStartTrail to perform actionPerformed(ActionEvent e)
public class ButtonStartTrialListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;

	/**
	 * Instantiates a new button start trial listener.
	 *
	 * @param guiController the gui controller
	 */
	// constructor
	public ButtonStartTrialListener(GuiController guiController) {
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.disposeAllViews();
		guiController.getAddPatientView().setupFrame();
		guiController.getAddPatientView().setVisible(true);// Selecting new patient will call addPatient to allow to add
															// new patient
	}
}