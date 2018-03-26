package gui;

import trial.*;
import file.FileAdapter;
import gui.listeners.*;
import gui.views.*;

public class GuiController {
	private MainMenuView mainMenuView;
	private AddPatientView addPatientView;
	private SystemSettingsView systemSettingsView;
	private FileAdapter fileAdapter;
	private ClinicalTrial clinicalTrial;
	private DisplayPatientListView displayPatientListView;
	private ClinicView clinicView;

	// Constructor
	GuiController(MainMenuView mainMenuView, AddPatientView addPatientView, SystemSettingsView systemSettingsView,
			FileAdapter fileAdapter, ClinicalTrial clinicalTrial, DisplayPatientListView displayPatientListView,
			ClinicView clinicView) {
		this.mainMenuView = mainMenuView;
		this.addPatientView = addPatientView;
		this.systemSettingsView = systemSettingsView;
		this.fileAdapter = fileAdapter;
		this.clinicalTrial = clinicalTrial;
		this.displayPatientListView = displayPatientListView;
		this.clinicView = clinicView;

		// mainMenuView to listeners
		this.mainMenuView.addButtonStartTrialListener(new ButtonStartTrialListener(this));
		this.mainMenuView.addButtonAddReadingListener(new ButtonAddReadingListener(this));
		this.mainMenuView.addButtonAddClinicListener(new ButtonClinicViewListener(this));
		
		//patientView Listeners
		this.addPatientView.addButtonAddListener(new ButtonAddPatientListener(this));
		this.addPatientView.addButtonBackListener(new ButtonMainMenuListener(this));

		//systemSettingsView listeners
		this.systemSettingsView.jsonAddPatientListener(new CheckBoxJsonAddPatients(this));
		this.systemSettingsView.jsonAddReadingListener(new CheckBoxJsonAddReadings(this));
		this.systemSettingsView.xmlAddPatientListener(new CheckBoxXmlAddPatients(this));
		this.systemSettingsView.xmlAddReadingListener(new CheckBoxXmlAddReadings(this));
		this.systemSettingsView.dateFormatListener(new JTextFieldDateFormatListener(this));
		this.systemSettingsView.addClinicsListener(new CheckBoxAddClinics(this));
		this.systemSettingsView.buttonResetListener(new ButtonResetAllSettingsListener(this));

		//displayPatientListView listeners
		this.displayPatientListView.addComboBoxPatientsListener(new ComboBoxPatientsListener(this));
		this.displayPatientListView.addPatientIsActiveListener(new CheckBoxPatientIsActive(this));

		// Add listeners for ClinicView
		this.clinicView.addButtonBackListener(new ButtonMainMenuListener(this));
		this.clinicView.addButtonAddClinicListener(new ButtonAddClinicListener(this));

	}

	void run(View view) {
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

	public ClinicView getClinicView() {
		return clinicView;
	}

	public void disposeAllViews() {
		mainMenuView.getFrame().dispose();
		addPatientView.getFrame().dispose();
		systemSettingsView.getFrame().dispose();
		displayPatientListView.getFrame().dispose();
		clinicView.getFrame().dispose();
	}

}
