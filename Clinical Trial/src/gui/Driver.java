package gui;
import file.FileAdapter;
import gui.views.*;
import trial.ClinicalTrial;

/**
 * Driver class having the main method.
 */
public class Driver {

	public static void main(String[] args) {
		// Models
		FileAdapter fileAdapter = new FileAdapter();
		ClinicalTrial clinicalTrial = fileAdapter.loadState();

		// views
		MainMenuView mainMenuView = new MainMenuView();
		AddPatientView addPatientView = new AddPatientView();
		SystemSettingsView systemSettingsView = new SystemSettingsView();
		DisplayPatientListView displayPatientListView = new DisplayPatientListView(clinicalTrial);
		ClinicView clinicView = new ClinicView(clinicalTrial);
		
		//Controller
		GuiController guiController = new GuiController(mainMenuView, addPatientView, systemSettingsView, fileAdapter,
				clinicalTrial, displayPatientListView, clinicView);

		mainMenuView.setMenuBar(PanelAndFrame.supplyMenuBar(guiController));
		clinicView.setMenuBar(PanelAndFrame.supplyMenuBar(guiController));
		addPatientView.setMenuBar(PanelAndFrame.supplyMenuBar(guiController));
		systemSettingsView.setMenuBar(PanelAndFrame.supplyMenuBar(guiController));
		displayPatientListView.setMenuBar(PanelAndFrame.supplyMenuBar(guiController));
		
		mainMenuView.setupFrame(clinicalTrial);
		guiController.run(mainMenuView);
	}
}
