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
 

	//Constructor
    GuiController(MainMenuView mainMenuView, AddPatientView addPatientView, SystemSettingsView systemSettingsView, FileAdapter fileAdapter, ClinicalTrial clinicalTrial,
    	    DisplayPatientListView displayPatientListView) {
        this.mainMenuView = mainMenuView;
        this.addPatientView = addPatientView;
        this.systemSettingsView = systemSettingsView;
        this.fileAdapter = fileAdapter;
        this.clinicalTrial = clinicalTrial;
        this.displayPatientListView = displayPatientListView;
        
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
		this.displayPatientListView.addComboBoxPatientsListener(new ComboBoxPatientsListener(this));
		this.displayPatientListView.addPatientIsActiveListener(new CheckBoxPatientIsActive(this));
    
    
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

	public SystemSettingsView getSystemSettingView() {
		return systemSettingsView;
	}

	public DisplayPatientListView getDisplayPatientListView() {
		return displayPatientListView;
	}


	public ClinicalTrial getClinicalTrial() {
		return clinicalTrial;
	}
	
}
