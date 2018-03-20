package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

public class ButtonManageFileListener implements ActionListener{
	GuiController guiController;
	
	//constructor
	public ButtonManageFileListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.getMainMenuView().getFrame().dispose();
		guiController.getAddPatientView().getFrame().dispose();
		guiController.getManageFileView().getFrame().dispose();
		
		guiController.getManageFileView().setupFrame();
		guiController.getManageFileView().setVisible(true);
	}

}
