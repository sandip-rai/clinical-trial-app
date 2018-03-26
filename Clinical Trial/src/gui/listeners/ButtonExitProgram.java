package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.GuiController;

public class ButtonExitProgram implements ActionListener{
	GuiController guiController;
	
	public ButtonExitProgram(GuiController guiController){
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 guiController.getFileAdapter().saveState(guiController.getClinicalTrial());		
		System.exit(0);
	}

}
