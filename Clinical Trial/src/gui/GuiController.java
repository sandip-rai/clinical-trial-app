package gui;

import trial.*;
import views.*;
import listeners.*;

public class GuiController {
    private MainMenuView mainMenuView;
	private AddPatientView addPatientView;
    private SystemSettingsView systemSettingsView;
    private FileAdapter fileAdapter;
    private ClinicalTrial clinicalTrial;
    private DisplayPatientListView displayPatientListView;
    private DisplayPatientInfoView displayPatientInfoView;
 

	//Constructor
    GuiController(MainMenuView mainMenuView, AddPatientView addPatientView, SystemSettingsView systemSettingsView, FileAdapter fileAdapter, ClinicalTrial clinicalTrial,
    	    DisplayPatientListView displayPatientListView, DisplayPatientInfoView displayPatientInfoView) {
        this.mainMenuView = mainMenuView;
        this.addPatientView = addPatientView;
        this.systemSettingsView = systemSettingsView;
        this.fileAdapter = fileAdapter;
        this.clinicalTrial = clinicalTrial;
        this.displayPatientListView = displayPatientListView;
        this.displayPatientInfoView = displayPatientInfoView;
        
        //Tell the mainMenuView to listen for their buttons
        this.mainMenuView.addButtonStartTrialListener(new ButtonStartTrialListener(this));
        this.mainMenuView.addButtonAddReadingListener(new ButtonAddReadingListener(this));
        
        this.addPatientView.addButtonAddListener(new ButtonAddPatientListener(this));
		this.addPatientView.addButtonBackListener(new ButtonMainMenuListener(this));
		
		//Tell the SystemSettingsView to listen for their Check boxes
		this.systemSettingsView.jsonAddPatientListener(new CheckBoxJsonAddPatients(this));
		this.systemSettingsView.jsonAddReadingListener(new CheckBoxJsonAddReadings(this));
		this.systemSettingsView.xmlAddPatientListener(new CheckBoxXmlAddPatients(this));
		this.systemSettingsView.xmlAddReadingListener(new CheckBoxXmlAddReadings(this));
		
		
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

	public SystemSettingsView getManageFileView() {
		return systemSettingsView;
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
