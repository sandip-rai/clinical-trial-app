package gui;

import trial.*;
import file.FileAdapter;
import gui.listeners.*;
import gui.views.*;

/**
 * The Class GuiController.
 */
public class GuiController {
	
	/** The main menu view. */
	private MainMenuView mainMenuView;
	
	/** The add patient view. */
	private AddPatientView addPatientView;
	
	/** The system settings view. */
	private SystemSettingsView systemSettingsView;
	
	/** The file adapter. */
	private FileAdapter fileAdapter;
	
	/** The clinical trial. */
	private ClinicalTrial clinicalTrial;
	
	/** The display patient list view. */
	private DisplayPatientListView displayPatientListView;
	
	/** The clinic view. */
	private ClinicView clinicView;

	/**
	 * Instantiates a new GUI controller.
	 *
	 * @param mainMenuView the main menu view
	 * @param addPatientView the add patient view
	 * @param systemSettingsView the system settings view
	 * @param fileAdapter the file adapter
	 * @param clinicalTrial the clinical trial
	 * @param displayPatientListView the display patient list view
	 * @param clinicView the clinic view
	 */
	// Constructor
	public GuiController(MainMenuView mainMenuView, AddPatientView addPatientView, SystemSettingsView systemSettingsView,
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

	/**
	 * Run.
	 *
	 * @param view the view
	 */
	void run(View view) {
		view.setVisible(true);
	}

	/**
	 * Gets the file adapter.
	 *
	 * @return the file adapter
	 */
	public FileAdapter getFileAdapter() {
		return fileAdapter;
	}

	/**
	 * Gets the main menu view.
	 *
	 * @return the main menu view
	 */
	public MainMenuView getMainMenuView() {
		return mainMenuView;
	}

	/**
	 * Gets the adds the patient view.
	 *
	 * @return the adds the patient view
	 */
	public AddPatientView getAddPatientView() {
		return addPatientView;
	}

	/**
	 * Gets the system setting view.
	 *
	 * @return the system setting view
	 */
	public SystemSettingsView getSystemSettingView() {
		return systemSettingsView;
	}

	/**
	 * Gets the display patient list view.
	 *
	 * @return the display patient list view
	 */
	public DisplayPatientListView getDisplayPatientListView() {
		return displayPatientListView;
	}

	/**
	 * Gets the clinical trial.
	 *
	 * @return the clinical trial
	 */
	public ClinicalTrial getClinicalTrial() {
		return clinicalTrial;
	}

	/**
	 * Gets the clinic view.
	 *
	 * @return the clinic view
	 */
	public ClinicView getClinicView() {
		return clinicView;
	}

	/**
	 * Dispose all views.
	 */
	public void disposeAllViews() {
		mainMenuView.getFrame().dispose();
		addPatientView.getFrame().dispose();
		systemSettingsView.getFrame().dispose();
		displayPatientListView.getFrame().dispose();
		clinicView.getFrame().dispose();
	}

}
