package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.GuiController;

public class ButtonSaveState implements ActionListener{
	GuiController guiController;
	
	public ButtonSaveState(GuiController guiController){
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (guiController.getFileAdapter().saveState(guiController.getClinicalTrial())) {
			 JOptionPane.showMessageDialog(null, "Save Successful");
		}else {
			 JOptionPane.showMessageDialog(null, "WARNING: Save not Successful");
		}
	}

}
