package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;
import gui.views.DisplayPatientListView;
import trial.Patient;


// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving comboBoxPatients events.
 * The class that is interested in processing a comboBoxPatients
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addComboBoxPatientsListener<code> method. When
 * the comboBoxPatients event occurs, that object's appropriate
 * method is invoked.
 * 
 * class for buttonBack to perform actionPerformed(ActionEvent e)
 *
 * @see ComboBoxPatientsEvent
 */
public class ComboBoxPatientsListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new combo box patients listener.
	 *
	 * @param guiController the gui controller
	 */
	//constructor
	public ComboBoxPatientsListener(GuiController guiController){
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String format = guiController.getClinicalTrial().getSettings().getDateFormat();
		DisplayPatientListView view = guiController.getDisplayPatientListView();
		if((Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem() != null){
			Patient patient = (Patient) guiController.getDisplayPatientListView().getComboBoxPatients().getSelectedItem();
			boolean active = patient.isActive();
			String text = patient.toString(format);
			view.setActive(active);
			view.setPatientInfo(text);
		} else {
		}
		view.getFrame().pack();
	}

}
