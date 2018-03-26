package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

public class ButtonPatientInfoListener implements ActionListener {
	GuiController guiController;

	/**
	 * Constructor
	 * 
	 * @param guiController
	 *            the class controlling the GUI components
	 */
	public ButtonPatientInfoListener(GuiController guiController) {
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.disposeAllViews();
		// Setup the DisplayPatientListView frame
		guiController.getDisplayPatientListView().setupFrame(guiController.getClinicalTrial());
		guiController.getDisplayPatientListView().setVisible(true);
	}

}
