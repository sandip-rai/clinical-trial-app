package gui;

import trial.*;
import views.*;
import listeners.*;

public class GuiController {
    private MainMenuView mainMenuView;
	private AddPatientView addPatientView;
    private ManageFileView manageFileView;
    private FileAdapter fileAdapter;
    private ClinicalTrial clinicalTrial;
    private DisplayPatientListView displayPatientListView;
    private DisplayPatientInfoView displayPatientInfoView;
 

	//Constructor
    GuiController(MainMenuView mainMenuView, AddPatientView addPatientView, ManageFileView manageFileView, FileAdapter fileAdapter, ClinicalTrial clinicalTrial,
    	    DisplayPatientListView displayPatientListView, DisplayPatientInfoView displayPatientInfoView) {
        this.mainMenuView = mainMenuView;
        this.addPatientView = addPatientView;
        this.manageFileView =manageFileView;
        this.fileAdapter = fileAdapter;
        this.clinicalTrial = clinicalTrial;
        this.displayPatientListView = displayPatientListView;
        this.displayPatientInfoView = displayPatientInfoView;
        
        //Tell the mainMenuView to listen for their buttons
        this.mainMenuView.addButtonStartTrialListener(new ButtonStartTrialListener(this));
        this.mainMenuView.addButtonAddReadingListener(new ButtonAddReadingListener(this));
        
        this.addPatientView.addButtonAddListener(new ButtonAddPatientListener(this));
		this.addPatientView.addButtonBackListener(new ButtonMainMenuListener(this));
		
		//this.manageFileView.addButtonSaveListener(new);
		this.manageFileView.addButtonUploadListener(new ButtonUploadListener(this));
		this.manageFileView.addButtonSaveListener(new ButtonSaveListener(this));
		
		//Adding listeners to the buttons in DisplayPatientListView
		this.displayPatientListView.addButtonResumeTrialListener(new ButtonResumeTrialListener(this));
		this.displayPatientListView.addButtonEndTrialListener(new ButtonEndTrialListener(this));
		this.displayPatientListView.addButtonShowInfoListener(new ButtonShowInfoListener(this));
		
		//Adding listeners to the buttons in DisplayPatientInfoView
		this.displayPatientInfoView.addButtonBackInfoListener(new ButtonPatientInfoListener(this));
    
    
    }
    
    void run(View view){
    	view.setVisible(true);
    }
    

    public FileAdapter getFileAdapter() {
		return fileAdapter;
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

	public DisplayPatientListView getDisplayPatientListView() {
		return displayPatientListView;
	}

	public DisplayPatientInfoView getDisplayPatientInfoView() {
		return displayPatientInfoView;
	}

	public ClinicalTrial getClinicalTrial() {
		return clinicalTrial;
	}
	
}
