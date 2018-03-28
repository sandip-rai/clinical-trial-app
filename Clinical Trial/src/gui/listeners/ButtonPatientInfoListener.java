package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

/**
 * The listener interface for receiving buttonPatientInfo events.
 * The class that is interested in processing a buttonPatientInfo
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonPatientInfoListener<code> method. When
 * the buttonPatientInfo event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonPatientInfoEvent
 */
public class ButtonPatientInfoListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;

	/**
	 * Constructor.
	 *
	 * @param guiController            the class controlling the GUI components
	 */
	public ButtonPatientInfoListener(GuiController guiController) {
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.disposeAllViews();
		// Setup the DisplayPatientListView frame
		guiController.getDisplayPatientListView().setupFrame(guiController.getClinicalTrial());
		guiController.getDisplayPatientListView().setVisible(true);
	}

}
