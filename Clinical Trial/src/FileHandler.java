/**
 * FileHandler class handles the json file reading and writing the output to a new json file.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import com.google.gson.*; //Importing gson library

public class FileHandler {

	/**
	 * PatientReadingsJson stores the ReadingJson class objects into an ArrayList
	 *
	 */
	private class PatientReadingsJson {
		//Arraylist to hold ReadingJson class objects
		private ArrayList<ReadingJson> patient_readings;

		//No-Args constructor
		PatientReadingsJson(){}

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
		
		//No-Args Constructor
		ReadingJson(){
        }

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
			//addPatientsToTrial(readingList.patient_readings);
			AddReadingToPatient(readingList.patient_readings); //Call AddReadingToPatient to add readings from input file to Patient's readings arraylist
		} catch (IOException e) { //Catch if fileLocation doesn't exist
			e.printStackTrace();
		}
	}

	// TODO DELETE THIS AFTER TESTING!!! This will create a new patient for
	// every reading in the file
	private static void addPatientsToTrial(ArrayList<ReadingJson> readings) {
		for (ReadingJson readingJson : readings) {
			Patient patient = new Patient(readingJson.patient_id);
			ClinicalTrial.getAllPatients().add(patient);
		}
	}
	
	/**
	 * writeJsonFile writes to the output Json File.
	 * @param fileName the name of the output file
	 */
	//******I HAVEN'T COMMENTED AS THERE SEEMS TO BE SIMILAR METHOD IN GUI AS WELL. ***//
	protected void writeJsonFile(String fileName){
        ArrayList<Patient> patients = ClinicalTrial.getAllPatients();
        ArrayList<ReadingJson> prj_list = new ArrayList<ReadingJson>();
        for (Patient p: patients){
            String pid = p.getPatientId();
            ArrayList<Reading> rs = p.getReadings();
            for(Reading r : rs){
                String s1 = r.getType();
                String s2 = r.getReadingId();
                String s3;
                if (r.getBpValue() == null){
                    s3 = Double.toString(r.getValue());
                }
                else{
                    s3 = r.getBpValue();
                }
                String s4 = Long.toString(r.getDate());
                ReadingJson rj = new ReadingJson(pid, s1, s2, s3, s4);
                prj_list.add(rj);
            }
        }
        PatientReadingsJson prj = new PatientReadingsJson(prj_list);
        Gson gson = new Gson();
        String output = gson.toJson(prj);
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(output);
            fw.close();
        }
        catch (IOException exc)
        {
            exc.getStackTrace();
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

		//TODO REMOVE AFTER TESTING!!!
		for (Patient patient : ClinicalTrial.getAllPatients()) {
			for (Reading reading : patient.getReadings()) {
				System.out.println("Patient: " + patient.getPatientId());
				System.out.println(reading.toString());
				System.out.println("**************************************");
			}
		}
	}

}
