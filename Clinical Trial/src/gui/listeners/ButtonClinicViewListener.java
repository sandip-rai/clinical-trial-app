package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;

/**
 * The listener interface for receiving buttonClinicView events.
 * The class that is interested in processing a buttonClinicView
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonClinicViewListener<code> method. When
 * the buttonClinicView event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonClinicViewEvent
 */
//class for buttonStartTrail to perform actionPerformed(ActionEvent e)
public class ButtonClinicViewListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new button clinic view listener.
	 *
	 * @param guiController the gui controller
	 */
	//constructor
	public ButtonClinicViewListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
    public void actionPerformed(ActionEvent e) {
        	guiController.disposeAllViews();
        	guiController.getClinicView().setupFrame();
        	guiController.getClinicView().setVisible(true);// Selecting new patient will call addPatient to allow to add new patient
    }
}