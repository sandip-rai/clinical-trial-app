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
	
	//Parses file extension, calls json or xml reading method accordingly
	public boolean readFile(ClinicalTrial clinicalTrial) {
		String path = getPath();
		int i = path.lastIndexOf('.');
		String fileType = path.substring(i);
		if (fileType.equals(".json")) {
			System.out.println("success");
			Boolean addUnkownPatients = clinicalTrial.getSettings().jsonAddUnknownPatients();
			Boolean addUnknownReadings = clinicalTrial.getSettings().jsonAddUnknownReadings();
			JsonHandler json = new JsonHandler(clinicalTrial);
			return json.readFile(path, addUnkownPatients, addUnknownReadings);
		}
		else if (fileType.equals(".xml")) {
			Boolean addUnkownPatients = clinicalTrial.getSettings().xmlAddUnknownPatients();
			Boolean addUnknownReadings = clinicalTrial.getSettings().xmlAddUnknownPatients();
			XmlHandler xml = new XmlHandler();
			return xml.readXMLFile(path, addUnkownPatients, addUnknownReadings);
		}
		else
			return false;
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
