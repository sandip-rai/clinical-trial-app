package file;

import java.io.File;

import javax.swing.JFileChooser;

import file.json.JsonHandler;
import file.xml.XmlHandler;
import trial.ClinicalTrial;

public class FileAdapter {

	private String getPath(boolean showSave) {
		JFileChooser fileChooser = new JFileChooser();
		// Open the file selection dialog at the current project directory
		fileChooser.setCurrentDirectory(new File("."));
		if (showSave) {
			fileChooser.showSaveDialog(null);
			File selectedFile = fileChooser.getSelectedFile(); // Get the file
			if (selectedFile != null) {
				String filePath = selectedFile.getAbsolutePath(); // Get the path
				return filePath;
			}
		} else {
			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile(); // Get the file
				String filePath = selectedFile.getAbsolutePath(); // Get the path
				return filePath;
			}
		}
		return null;
	}

	public boolean writeFile(ClinicalTrial clinicalTrial) {
		String path = getPath(true);
		JsonHandler json = new JsonHandler(clinicalTrial);
		if (path != null) {
			return json.WritePatientReadings(path);
		} else {
			return false;
		}
	}

	// Parses file extension, calls json or xml reading method accordingly
	public boolean readFile(ClinicalTrial clinicalTrial) {
		String path = getPath(false);
		String fileType;
		try {
			int i = path.lastIndexOf('.');
			fileType = path.substring(i);
		} catch (NullPointerException e) {
			// if no file was chosen return false
			return false;
		}

		if (fileType.equals(".json")) {
			Boolean addUnkownPatients = clinicalTrial.getSettings().jsonAddUnknownPatients();
			Boolean addUnknownReadings = clinicalTrial.getSettings().jsonAddUnknownReadings();
			JsonHandler json = new JsonHandler(clinicalTrial);
			return json.readFile(path, addUnkownPatients, addUnknownReadings);
		} else if (fileType.equals(".xml")) {
			Boolean addUnkownPatients = clinicalTrial.getSettings().xmlAddUnknownPatients();
			Boolean addUnknownReadings = clinicalTrial.getSettings().xmlAddUnknownPatients();
			XmlHandler xml = new XmlHandler(clinicalTrial);
			return xml.readXMLFile(path, addUnkownPatients, addUnknownReadings);
		} else
			return false;
	}

	public boolean saveState(ClinicalTrial clinicalTrial) {
		JsonHandler json = new JsonHandler(clinicalTrial);
		if (json.saveState()) {
			return true;
		}
		return false;
	}

	public ClinicalTrial loadState() {
		JsonHandler json = new JsonHandler(null);
		return json.loadState();
	}

}
