/**
 * FileHandler class handles the json file reading and writing the output to a new json file.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import javax.swing.JFileChooser;

import com.google.gson.*; //Importing gson library

public class FileHandler {

	/**
	 * PatientReadingsJson stores the ReadingJson class objects into an ArrayList
	 *
	 */
	private class PatientReadingsJson {
		//Arraylist to hold ReadingJson class objects
		private ArrayList<ReadingJson> patient_readings;

		/**
		 * Argument specified Constructor
		 * @param pr arraylist holding the ReadingJson class objects
		 */
		PatientReadingsJson(ArrayList<ReadingJson> pr)
        {
            patient_readings = pr;
        }
	}

	/**
	 * ReadingJson class handles the objects with the specified parameters that are present in the input Json File.
	 *
	 */
	private class ReadingJson {
		//Initializing parameters
		private String patient_id;
		private String reading_type;
		private String reading_id;
		private String reading_value;
		private String reading_date;

		//Arguments specified Constructor
		ReadingJson(String id, String type, String rid, String rval, String rdate){
		    patient_id = id;
		    reading_type = type;
		    reading_id = rid;
		    reading_value = rval;
		    reading_date = rdate;
        }
	}

	/**
	 * readJsonFile initializes the FileReader, creates a Gson object, and creates PatientReadingsJson object.
	 * It gets called from uploadFile method of GUI class and then it passes PatientReadingsJson object patient readings to AddReadingToPatient method.
	 * @param fileLocation the absolute path of the selected input file
	 */
	protected void readJsonFile (String fileLocation) {
		//Create a Gson object
		Gson gson = new GsonBuilder().serializeNulls().create();

		//Try a FileReader
		try (Reader fileReader = new FileReader(fileLocation)) {
			PatientReadingsJson readingList = gson.fromJson(fileReader, PatientReadingsJson.class); //Create PatientReadingsJson object which creates an arraylist
			AddReadingToPatient(readingList.patient_readings); //Call AddReadingToPatient to add readings from input file to Patient's readings arraylist
		} catch (IOException e) { //Catch if fileLocation doesn't exist
			e.printStackTrace();
		}
	}

	/**
	 * writeJsonFile writes to the output Json File.
	 * @param fileName the name of the output file
	 */
	//******I HAVEN'T COMMENTED AS THERE SEEMS TO BE SIMILAR METHOD IN GUI AS WELL. ***//
	protected void writeJsonFile(){
		String fileName;
			//Print the info of selected patient id
			JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				fileName = jfc.getSelectedFile().getAbsolutePath()+".json";
				try {
					Writer writer = new FileWriter(fileName);
					Gson gson = new GsonBuilder().create();
				    gson.toJson(ClinicalTrial.getAllPatients(), writer);	
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

    }

	/**
	 * AddReadingToPatient adds the readings from the input file to the Patient's reading ArrayList
	 * @param readings the readings of the input file in an ArrayList
	 */
	private void AddReadingToPatient(ArrayList<ReadingJson> readings) {
		for (ReadingJson reading : readings) { //loop through the readings arrayList
			Patient patient = ClinicalTrial.findPatient(reading.patient_id); //Get a patient from the arrayList
			if (patient == null) {
				continue; //Continue if arrayList is empty
			}

			//Grab the readings into each String
			String readingId = reading.reading_id;
			String type = reading.reading_type;
			long date = Long.parseLong(reading.reading_date);
			try { //Try for every reading value except blood_pressure type
				double value = Integer.parseInt(reading.reading_value);
				patient.addReading(readingId, type, value, date);
			} catch (java.lang.NumberFormatException e) { //Do this for reading value if the reading type is of blood_pressure
				String value = reading.reading_value; //blood_pressure reading value is of String type
				patient.addReading(readingId, type, value, date);
			}
		}
	}

}
