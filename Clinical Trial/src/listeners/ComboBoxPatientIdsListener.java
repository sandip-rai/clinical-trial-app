package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiController;

//class for buttonBack to perform actionPerformed(ActionEvent e)
public class ComboBoxPatientIdsListener implements ActionListener {
	GuiController guiController;
	//constructor
	public ComboBoxPatientIdsListener(GuiController guiController){
		this.guiController = guiController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(guiController.getMainMenuView().getComboBoxPatientsIds().getSelectedItem());
	}

}
