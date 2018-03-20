package gui;

import trial.*;
import views.*;
import listeners.*;

public class GuiController {
    private MainMenuView mainMenuView;
	private AddPatientView addPatientView;
    private ManageFileView manageFileView;
    private FileHandler fileHandler;

	//Constructor
    GuiController(MainMenuView mainMenuView, AddPatientView addPatientView, ManageFileView manageFileView, FileHandler fileHandler) {
        this.mainMenuView = mainMenuView;
        this.addPatientView = addPatientView;
        this.manageFileView =manageFileView;
        this.fileHandler = fileHandler;
        
        //Tell the mainMenuView to listen for their buttons
        this.mainMenuView.addButtonStartTrialListener(new ButtonStartTrialListener(this));
        this.mainMenuView.addButtonAddReadingListener(new ButtonAddReadingListener(this));
        
        this.addPatientView.addButtonAddListener(new ButtonAddPatientListener(this));
		this.addPatientView.addButtonBackListener(new ButtonMainMenuListener(this));
		
		//this.manageFileView.addButtonSaveListener(new);
		this.manageFileView.addButtonUploadListener(new ButtonUploadListener(this));
		this.manageFileView.addButtonSaveListener(new ButtonSaveListener(this));
    }
    
    void run(View view){
    	view.setVisible(true);
    }
    

    public FileHandler getFileHandler() {
		return fileHandler;
	}
    
    public MainMenuView getMainMenuView() {
		return mainMenuView;
	}

	public AddPatientView getAddPatientView() {
		return addPatientView;
	}

	public ManageFileView getManageFileView() {
		return manageFileView;
	}
}
