package listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.PanelAndFrame;
import views.AddPatientView;
import views.MainMenuView;

//class for buttonBack to perform actionPerformed(ActionEvent e)
public class ButtonMainMenuListener implements ActionListener {
	MainMenuView mainMenuView;
	AddPatientView addPatientView;
	
	//constructor
	public ButtonMainMenuListener(MainMenuView mainMenuView, AddPatientView addPatientView){
		this.mainMenuView = mainMenuView;
		this.addPatientView = addPatientView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainMenuView.getFrame().dispose();
		addPatientView.getFrame().dispose();
		mainMenuView.setupFrame();
		mainMenuView.setVisible(true);
	}

}
