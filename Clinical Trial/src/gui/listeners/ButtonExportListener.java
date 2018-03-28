package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.GuiController;

/**
 * The listener interface for receiving buttonExport events.
 * The class that is interested in processing a buttonExport
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonExportListener<code> method. When
 * the buttonExport event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonExportEvent
 */
public class ButtonExportListener implements ActionListener {
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new button export listener.
	 *
	 * @param guiController the gui controller
	 */
	//constructor
	public ButtonExportListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (guiController.getFileAdapter().writeFile(guiController.getClinicalTrial())) { // If file is saved, prompt the user
             // and display manage file interface
             JOptionPane.showMessageDialog(null, "File saved successfully.");
             
         } else { // If no file saved, prompt and display manage file
             // interface again.
             JOptionPane.showMessageDialog(null, "File not saved.");
         }
	}

}
