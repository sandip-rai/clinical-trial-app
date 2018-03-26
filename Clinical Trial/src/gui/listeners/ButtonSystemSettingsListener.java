package gui.listeners;

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
		guiController.disposeAllViews();
		guiController.getSystemSettingView().setupFrame(guiController.getClinicalTrial());
		guiController.getSystemSettingView().setVisible(true);
	}

}
