package gui.listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.GuiController;



// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving JTextFieldDateFormat events.
 * The class that is interested in processing a JTextFieldDateFormat
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addJTextFieldDateFormatListener<code> method. When
 * the JTextFieldDateFormat event occurs, that object's appropriate
 * method is invoked.
 *
 *class for buttonBack to perform actionPerformed(ActionEvent e)
 *
 * @see JTextFieldDateFormatEvent
 */
public class JTextFieldDateFormatListener implements DocumentListener {
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new j text field date format listener.
	 *
	 * @param guiController the gui controller
	 */
	//constructor
	public JTextFieldDateFormatListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {	
		updateDateFormat();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {	
		updateDateFormat();
	
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {	
		updateDateFormat();
	}
	
	/**
	 * Update date format.
	 */
	private void updateDateFormat() {
		String dateFormat = guiController.getSystemSettingView().getDateFormat().getText();
		guiController.getClinicalTrial().getSettings().setDateFormat(dateFormat);
	}


}
