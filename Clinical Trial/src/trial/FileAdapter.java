package trial;

import java.io.File;

import javax.swing.JFileChooser;

public class FileAdapter {
	JsonHandler json = new JsonHandler();
	XmlHandler xml = new XmlHandler();	
	
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
	
	public boolean writeFile() {
		String path = getPath();
		return json.WritePatientReadings(path);		
	}
	
	//TODO Detect file type (regular expression to check for either *.json or *.xml) and send it to the correct handler
	public boolean readFile() {
		String path = getPath();
		return json.readFile(path, true, false);
	}
	
}
