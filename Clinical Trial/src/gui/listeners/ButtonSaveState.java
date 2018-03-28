package gui.listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import gui.GuiController;

/**
 * The Class ButtonSaveState.
 */
public class ButtonSaveState implements ActionListener{
	
	/** The gui controller. */
	GuiController guiController;
	
	/**
	 * Instantiates a new button save state.
	 *
	 * @param guiController the gui controller
	 */
	public ButtonSaveState(GuiController guiController){
		this.guiController = guiController;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (guiController.getFileAdapter().saveState(guiController.getClinicalTrial())) {
			 JOptionPane.showMessageDialog(null, "Save Successful");
		}else {
			 JOptionPane.showMessageDialog(null, "WARNING: Save not Successful");
		}
	}

}
