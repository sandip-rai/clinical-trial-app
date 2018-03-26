package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

//class for buttonBack to perform actionPerformed(ActionEvent e)
public class ButtonMainMenuListener implements ActionListener {
	GuiController guiController;
	//constructor
	public ButtonMainMenuListener(GuiController guiController){
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		guiController.disposeAllViews();
		guiController.getMainMenuView().setupFrame(guiController.getClinicalTrial());
		guiController.getMainMenuView().setVisible(true);
	}

}
