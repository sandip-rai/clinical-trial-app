package trial;

import java.io.File;

import javax.swing.JFileChooser;

public class FileAdapter {		
	
	private String getPath() {		
		JFileChooser fileChooser = new JFileChooser();
		// Open the file selection dialog at the current project directory
		fileChooser.setCurrentDirectory(new File("."));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile(); // Get the file
			String filePath = selectedFile.getAbsolutePath(); // Get the path
			return filePath;
		}
		return null;
	}	
	
	public boolean writeFile(ClinicalTrial clinicalTrial) {
		String path = getPath();
		JsonHandler json = new JsonHandler(clinicalTrial);
		return json.WritePatientReadings(path);		
	}
	
	//TODO Detect file type (regular expression to check for either *.json or *.xml) and send it to the correct handler
	public boolean readFile(ClinicalTrial clinicalTrial) {
		String path = getPath();
		JsonHandler json = new JsonHandler(clinicalTrial);
		return json.readFile(path, true, false);
	}
	
	public boolean saveState(ClinicalTrial clinicalTrial) {
		JsonHandler json = new JsonHandler(clinicalTrial);
		if(json.saveState()) {
			return true;
		}
		return false;
	}
	
	public ClinicalTrial loadState() {
		JsonHandler json = new JsonHandler(null);
		return json.loadState();
	}
	
}
