package com.file;

import android.content.Context;
import com.file.json.JsonHandler;
import com.file.xml.XmlHandler;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import trial.ClinicalTrial;
import android.os.Environment;


/**
 * The Class FileAdapter.
 */
public class FileAdapter {

	/** The save state path. */
	private final String SAVE_STATE_NAME = "SaveState.json";
	private final String OUT_NAME = "out.json";
	private ArrayList<String> filePaths = new ArrayList<>();

	/**
	 * Gets the paths from the user for file importing and exporting.
	 *
	 * @param directoryPath the directory
	 */
	private void getAllFiles(String directoryPath) {
		File directory = new File(directoryPath);
		File files[] = directory.listFiles();
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					getAllFiles(files[i].getAbsolutePath());
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
		String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		String fileName =  OUT_NAME + date;
		JsonHandler json = new JsonHandler(clinicalTrial);
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File (sdCard.getAbsolutePath() + "/ClinicalTrial");
		dir.mkdirs();
		File file = new File(dir, fileName);
		return json.WritePatientReadings(file.getAbsolutePath());
	}

	/**
	 *  Parses file extension, calls json or xml reading method accordingly
	 *
	 * @param clinicalTrial the clinical trial
	 * @return true, if successful
	 */
	public boolean getFiles(ClinicalTrial clinicalTrial) {
		getAllFiles(Environment.getExternalStorageDirectory()
				.getAbsolutePath());
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
	public boolean saveState(ClinicalTrial clinicalTrial, Context context) {
		//Instantiate new JsonHandler
		JsonHandler json = new JsonHandler(clinicalTrial);
		//Save the current state
		if (json.saveState(context.getFilesDir().getAbsolutePath() + SAVE_STATE_NAME)) {
			return true;
		}
		return false;
	}

	/**
	 * Loads a SaveState.json file.
	 *
	 * @return the clinical trial
	 */
	public ClinicalTrial loadState(Context context) {
		//Instantiate new JsonHandler
		JsonHandler json = new JsonHandler(null);
		//Load the save file
		return json.loadState(context.getFilesDir().getAbsolutePath() + SAVE_STATE_NAME);
	}

}
