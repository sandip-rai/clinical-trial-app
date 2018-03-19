package gui;

import listeners.ButtonMainMenuListener;
import views.*;

/**
 * Driver class having the main method.
 */
public class Driver {

    public static void main(String[] args) {
    	MainMenuView mainMenuView = new MainMenuView();
    	AddPatientView addPatientView = new AddPatientView();
    	mainMenuView.setMenuBar(PanelAndFrame.supplyMenuBar(mainMenuView, addPatientView));
    	addPatientView.setMenuBar(PanelAndFrame.supplyMenuBar(mainMenuView, addPatientView));
    	mainMenuView.setupFrame();
    	addPatientView.setupFrame();
    	GuiController guiController =new GuiController(mainMenuView, addPatientView);
    	guiController.run(mainMenuView);
    }
    
    
    

}

