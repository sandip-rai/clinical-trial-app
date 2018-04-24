package com.file;

import com.file.json.JsonHandler;
import com.file.xml.XmlHandler;
import trial.ClinicalTrial;

/**
 * The Class FileAdapter.
 */
public class FileAdapter {

	/**
	 * Gets the path from the user for file importing and exporting.
	 *
	 * @param showSave the show save
	 * @return the path
	 */
	private String getPath(boolean showSave) {
		String path = "./";
		return path;
	}

	/**
	 * Write file.
	 *
	 * @param clinicalTrial the clinical trial
	 * @return true, if successful
	 */
	public boolean writeFile(ClinicalTrial clinicalTrial) {
		//get the path to write the file and set save to true
		String path = getPath(true);
		//instantiate a new JsonHandler
		JsonHandler json = new JsonHandler(clinicalTrial);
		//if a path was returned write the file with the JSonHandler
		if (path != null) {
			return json.WritePatientReadings(path);
		} else {
			return false;
		}
	}

	/**
	 *  Parses file extension, calls json or xml reading method accordingly
	 *
	 * @param clinicalTrial the clinical trial
	 * @return true, if successful
	 */
	public boolean readFile(ClinicalTrial clinicalTrial) {
		//get the path from the file reader and set save to false
		String path = getPath(false);
		String fileType;
		//find the file extension
		try {
			int i = path.lastIndexOf('.');
			fileType = path.substring(i);
		} catch (NullPointerException e) {
			// if no file was chosen return false
			return false;
		}
		if (fileType.equals(".json")) {
			//if the file was JSON use the JsonHandler
			JsonHandler json = new JsonHandler(clinicalTrial);
			return json.readFile(path);
		} else if (fileType.equals(".xml")) {
			//if the file was XML use the XmlHandler
			XmlHandler xml = new XmlHandler(clinicalTrial);
			try {
				return xml.readXMLFile(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			//if the file type was not recognized return false
			return false;
		return false;
	}

	/**
	 * Saves the current system state.
	 *
	 * @param clinicalTrial the clinical trial
	 * @return true, if successful
	 */
	public boolean saveState(ClinicalTrial clinicalTrial) {
		//Instantiate new JsonHandler
		JsonHandler json = new JsonHandler(clinicalTrial);
		//Save the current state 
		if (json.saveState()) {
			return true;
		}
		return false;
	}

	/**
	 * Loads a SaveState.json file.
	 *
	 * @return the clinical trial
	 */
	public ClinicalTrial loadState() {
		//Instantiate new JsonHandler
		JsonHandler json = new JsonHandler(null);
		//Load the save file
		return json.loadState();
	}

}