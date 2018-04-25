package com.file;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.file.json.JsonHandler;
import com.file.xml.XmlHandler;

import java.io.File;
import java.util.ArrayList;
import trial.ClinicalTrial;

import static java.security.AccessController.getContext;

/**
 * The Class FileAdapter.
 */
public class FileAdapter extends AppCompatActivity {
	Context context = getApplicationContext();
	/** The save state path. */
	private final String SAVE_STATE_PATH = context.getFilesDir().getAbsolutePath() +"SaveState.json";
	private final String OUT_PATH = context.getFilesDir().getAbsolutePath() +"out.json";

	/**
	 * Gets the path from the user for file importing and exporting.
	 *
	 * @param directory the directory
	 * @return the path
	 */
	private void getAllFiles(File directory, ArrayList<String> filePaths) {
			File files[] = directory.listFiles();
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						getAllFiles(files[i], filePaths);
					} else {
						if (files[i].getName().toLowerCase().endsWith(".json")
								|| files[i].getName().toLowerCase().endsWith(".xml"))
						{
							filePaths.add(files[i].getAbsolutePath());
						}
					}

				}
			}
			return;
	}

	/**
	 * Write file.
	 *
	 * @param clinicalTrial the clinical trial
	 * @return true, if successful
	 */
	public boolean writeFile(ClinicalTrial clinicalTrial) {
		JsonHandler json = new JsonHandler(clinicalTrial);
			return json.WritePatientReadings(OUT_PATH);
	}

	/**
	 *  Parses file extension, calls json or xml reading method accordingly
	 *
	 * @param clinicalTrial the clinical trial
	 * @return true, if successful
	 */
	public boolean readFile(ClinicalTrial clinicalTrial) {
		ArrayList<String> filePaths = new ArrayList<>();
		//get the path from the file reader and set save to false
		getAllFiles(context.getExternalFilesDir(null), filePaths);
		for (String path : filePaths){
			String fileType;
			//find the file extension
			try {
				int i = path.lastIndexOf('.');
				fileType = path.substring(i);
			} catch (NullPointerException e) {
				// if no file was chosen return false
				continue;
			}
			if (fileType.equals(".json")) {
				//if the file was JSON use the JsonHandler
				JsonHandler json = new JsonHandler(clinicalTrial);
				json.readFile(path);
				continue;
			} else if (fileType.equals(".xml")) {
				//if the file was XML use the XmlHandler
				XmlHandler xml = new XmlHandler(clinicalTrial);
				try {
					return xml.readXMLFile(path);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else
				//if the file type was not recognized continue to the next file
				continue;
		}

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
		if (json.saveState(SAVE_STATE_PATH)) {
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
		return json.loadState(SAVE_STATE_PATH);
	}

}
