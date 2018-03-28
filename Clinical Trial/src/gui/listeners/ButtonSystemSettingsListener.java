package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

/**
 * The listener interface for receiving buttonSystemSettings events.
 * The class that is interested in processing a buttonSystemSettings
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonSystemSettingsListener<code> method. When
 * the buttonSystemSettings event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonSystemSettingsEvent
 */
public class ButtonSystemSettingsListener implements ActionListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new button system settings listener.
	 *
	 * @param guiController the gui controller
	 */
	//constructor
	public ButtonSystemSettingsListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * changes view to SystemSettingsView
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.disposeAllViews();
		guiController.getSystemSettingView().setupFrame(guiController.getClinicalTrial());
		guiController.getSystemSettingView().setVisible(true);
	}

}
