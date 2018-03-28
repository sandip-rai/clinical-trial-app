package gui.listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import gui.GuiController;

/**
 * The listener interface for receiving buttonImport events.
 * The class that is interested in processing a buttonImport
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addButtonImportListener<code> method. When
 * the buttonImport event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ButtonImportEvent
 */
public class ButtonImportListener implements ActionListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new button import listener.
	 *
	 * @param guiController the gui controller
	 */
	public ButtonImportListener(GuiController guiController){
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (guiController.getFileAdapter().readFile(guiController.getClinicalTrial())) { 
			 // If file is read, prompt the user and display the patient list\
             JOptionPane.showMessageDialog(null, "File uploaded successfully.");
             guiController.disposeAllViews();
			 guiController.getDisplayPatientListView().setupFrame(guiController.getClinicalTrial());
			 guiController.getDisplayPatientListView().setVisible(true);
         } else { // If no file read, prompt the user and show the manage
            // file interface
            JOptionPane.showMessageDialog(null, "File upload failed.");
         }

	}

}
