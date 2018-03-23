package listeners;

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
		guiController.getMainMenuView().getFrame().dispose();
		guiController.getAddPatientView().getFrame().dispose();
		guiController.getManageFileView().getFrame().dispose();
		guiController.getDisplayPatientInfoView().getFrame().dispose();
		guiController.getDisplayPatientListView().getFrame().dispose();
		guiController.getMainMenuView().setupFrame(guiController.getClinicalTrial());
		guiController.getMainMenuView().setVisible(true);
	}

}
