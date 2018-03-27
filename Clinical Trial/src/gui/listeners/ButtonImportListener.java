package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.GuiController;

public class ButtonImportListener implements ActionListener{
	GuiController guiController;
	
	public ButtonImportListener(GuiController guiController){
		this.guiController = guiController;
	}

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
