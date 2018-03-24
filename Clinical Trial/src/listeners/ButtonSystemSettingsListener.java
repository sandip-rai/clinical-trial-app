package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

public class ButtonSystemSettingsListener implements ActionListener{
	GuiController guiController;
	
	//constructor
	public ButtonSystemSettingsListener(GuiController guiController){
		this.guiController = guiController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.getMainMenuView().getFrame().dispose();
		guiController.getAddPatientView().getFrame().dispose();
		guiController.getSystemSettingView().getFrame().dispose();
		
		guiController.getSystemSettingView().setupFrame();
		guiController.getSystemSettingView().setVisible(true);
	}

}
