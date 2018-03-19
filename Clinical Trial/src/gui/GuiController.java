package gui;

import views.AddPatientView;
import views.*;
import listeners.*;

public class GuiController {
    private MainMenuView mainMenuView;
    private AddPatientView addPatientView;
    
    //Constructor
    GuiController(MainMenuView mainMenuView, AddPatientView addPatientView) {
        this.mainMenuView = mainMenuView;
        this.addPatientView = addPatientView;
        
        //Tell the mainMenuView to listen for their buttons
        this.mainMenuView.addButtonStartTrialListener(new ButtonStartTrialListener(mainMenuView, addPatientView));
        this.mainMenuView.addButtonAddReadingListener(new ButtonAddReadingListener(mainMenuView));
        
        this.addPatientView.addButtonAddListener(new ButtonAddPatientListener(addPatientView));
        this.addPatientView.addButtonBackListener(new ButtonMainMenuListener(mainMenuView, addPatientView));
    }
    
    void run(View view){
    	view.setVisible(true);
    }
}
