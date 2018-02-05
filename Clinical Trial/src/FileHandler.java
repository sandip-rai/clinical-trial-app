import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import com.google.gson.*;

public class FileHandler {

	private class PatientReadingsJson {
		private ArrayList<ReadingJson> patient_readings;

		PatientReadingsJson(){}

		PatientReadingsJson(ArrayList<ReadingJson> pr)
        {
            patient_readings = pr;
        }
	}

	private class ReadingJson {
		private String patient_id;
		private String reading_type;
		private String reading_id;
		private String reading_value;
		private String reading_date;
		
		ReadingJson(){
        }

		ReadingJson(String id, String type, String rid, String rval, String rdate){
		    patient_id = id;
		    reading_type = type;
		    reading_id = rid;
		    reading_value = rval;
		    reading_date = rdate;
        }
	}

	
	protected void readJsonFile (String fileLocation) {
		Gson gson = new GsonBuilder().serializeNulls().create();

		try (Reader fileReader = new FileReader(fileLocation)) {
			PatientReadingsJson readingList = gson.fromJson(fileReader, PatientReadingsJson.class);
			addPatientsToTrial(readingList.patient_readings);
			AddReadingToPatient(readingList.patient_readings);
		} catch (IOException e) {
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

	private void AddReadingToPatient(ArrayList<ReadingJson> readings) {
		for (ReadingJson reading : readings) {
			Patient patient = ClinicalTrial.findPatient(reading.patient_id);
			if (patient == null) {
				continue;
			}
			String readingId = reading.reading_id;
			//System.out.println("readingID = " + readingId);
			String type = reading.reading_type;
			long date = Long.parseLong(reading.reading_date);
			try {
				double value = Integer.parseInt(reading.reading_value);
				patient.addReading(readingId, type, value, date);
			} catch (java.lang.NumberFormatException e) {
				String value = reading.reading_value;
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
