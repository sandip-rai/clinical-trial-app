package trial;
/**
 * FileHandler class handles the json file reading and writing the output to a new json file.
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;
import com.google.gson.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class FileHandler {
	/**
	 * ReadingJson class handles the objects with the specified parameters that are
	 * present in the input Json File.
	 *
	 */
	private class ReadingJson {
		// Initializing parameters
		private String patient_id;
		private String reading_type;
		private String reading_id;
		private String reading_value;
		private String reading_date;
		private String clinic_id, clinic_name;

		ReadingJson(String patient_id, String reading_type, String reading_id, String reading_value,
				String reading_date) {
			this.patient_id = patient_id;
			this.reading_type = reading_type;
			this.reading_id = reading_id;
			this.reading_value = reading_value;
			this.reading_date = reading_date;
		}
		
		ReadingJson(String id, String type, String rid, String rval, String rdate, String cid, String cn){
		    patient_id = id;
		    reading_type = type;
		    reading_id = rid;
		    reading_value = rval;
		    reading_date = rdate;
		    clinic_id = cid;
		    clinic_name = cn;
        }
	}

	/**
	 * PatientReadingsJson stores the ReadingJson class objects into an ArrayList
	 *
	 */
	private class PatientReadingsJson {
		// Arraylist to hold ReadingJson class objects
		private ArrayList<ReadingJson> patient_readings;

		PatientReadingsJson(ArrayList<ReadingJson> patient_readings) {
			this.patient_readings = patient_readings;
		}
	}
	
	@SuppressWarnings("unused")
	private class State {
		private ArrayList<Patient> allPatients = ClinicalTrial.getAllPatients();;
		// private ArrayList<Clinic> allClinics = new ArrayList<Clinic>();
	}

	public void startProgram() {

	}

	public void endProgram() {

	}

	/**
	 * readJsonFile initializes the FileReader, creates a Gson object, and creates
	 * PatientReadingsJson object. It gets called from uploadFile method of GUI
	 * class and then it passes PatientReadingsJson object patient readings to
	 * AddReadingToPatient method.
	 * 
	 * @return true if file is successfully read and contents are added
	 *         appropriately
	 */

	public boolean readJsonFile(String filePath, boolean addToTrial, boolean activate) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		// Try a FileReader
		try (Reader fileReader = new FileReader(filePath)) {
			// Create PatientReadingsJson object which creates an AarrayList
			PatientReadingsJson readingList = gson.fromJson(fileReader, PatientReadingsJson.class);
			/*
			 * TODO per phase 1 requirements readings from patients not in trial should be
			 * ignored. if we want to automatically add a patient we should add a check box
			 * to the gui.
			 */
			addPatientsToTrial(readingList.patient_readings);
			// Add readings from input file to Patient's readings ArrayList
			AddReadingToPatient(readingList.patient_readings);
			return true; // If file has been read and contents added
		} catch (IOException e) { // Catch if fileLocation doesn't exist
			e.printStackTrace();
		}
		return false;
	}

	public boolean WriteState() {
		Writer writer;
		try {
			writer = new FileWriter("state.json");
			Gson gson = new GsonBuilder().create();
			State state = new State();
			gson.toJson(state, writer);
			writer.close();// If file is written and writer closed
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;// If exception occurs
		}
	}

	public boolean WritePatientReadings(String fileName) {
		try {
			Writer writer = new FileWriter(fileName);
			Gson gson = new GsonBuilder().create();
			ArrayList<ReadingJson> jsonReadings = getJsonReadings();
			PatientReadingsJson allReadings = new PatientReadingsJson(jsonReadings);
			gson.toJson(allReadings, writer);
			writer.close();
			return true; // If file is written and writer closed
		} catch (IOException e) {
			e.printStackTrace();
			return false; // If exception occurs
		}
	}

	private ArrayList<ReadingJson> getJsonReadings() {
		ArrayList<Patient> allPatients = ClinicalTrial.getAllPatients();
		ArrayList<ReadingJson> allReadings = new ArrayList<ReadingJson>();
		for (Patient patient : allPatients) {
			ArrayList<Reading> patientReadings = patient.getReadings();
			for (Reading reading : patientReadings) {
				String patient_id = patient.getPatientId();
				String reading_type = reading.getType();
				String reading_id = reading.getReadingId();
				String reading_date = Long.toString(reading.getDate().getTime());
				String reading_value = new String();
				if (reading_type.equals("blood_press")) {
					reading_value = reading.getBpValue();
				} else {
					reading_value = Double.toString(reading.getValue());
				}
				if (reading.getClinicId() != null && reading.getClinicName() != null) {
					String clinic_id = reading.getClinicId();
					String clinic_name = reading.getClinicName();
					ReadingJson rj = new ReadingJson(patient_id, reading_type, reading_id, reading_value,
							reading_date, clinic_id, clinic_name);
					allReadings.add(rj);
				}
				else {
					ReadingJson readingJson = new ReadingJson(patient_id, reading_type, reading_id, reading_value,
						reading_date);
					allReadings.add(readingJson);
				}
			}
		}
		return allReadings;
	}

	private void addPatientsToTrial(ArrayList<ReadingJson> readings) {
		for (ReadingJson readingJson : readings) {
			if (ClinicalTrial.findPatient(readingJson.patient_id) == null) {
				Patient patient = new Patient(readingJson.patient_id);
				ClinicalTrial.getAllPatients().add(patient);
			}

		}
	}

	/**
	 * AddReadingToPatient adds the readings from the input file to the Patient's
	 * reading ArrayList
	 * 
	 * @param readings
	 *            the readings of the input file in an ArrayList
	 */
	private void AddReadingToPatient(ArrayList<ReadingJson> readings) {
		for (ReadingJson reading : readings) { // loop through the readings arrayList
			Patient patient = ClinicalTrial.findPatient(reading.patient_id); // Get a patient from the arrayList
			if (patient == null) {
				continue; // Continue if arrayList is empty
			}
			// Grab the readings into each String
			String readingId = reading.reading_id;
			String type = reading.reading_type;
			Date date = new Date(Long.parseLong(reading.reading_date));
			try { // Try for every reading value except blood_pressure type
				double value = Integer.parseInt(reading.reading_value);
				patient.addReading(readingId, type, value, date);
			} catch (java.lang.NumberFormatException e) { // Do this for reading value if the reading type is of
															// blood_pressure
				String value = reading.reading_value; // blood_pressure reading value is of String type
				patient.addReading(readingId, type, value, date);
			}
		}
	}
	
	/*
	 * 
	 * Read the xml file, and please note that this also adds a clinic id.
	 */
	private void readXMLFile(String file) {
	    String clinicName="", clinicId="";
	    String[] readingId, readingType, readingValue, patientId;
        File inputFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nl1 = doc.getElementsByTagName("Clinic");
            Node n = nl1.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE){
                Element el = (Element) n;
                clinicId = el.getAttribute("id");
                clinicName = el.getTextContent();
            }
            NodeList nl2 = doc.getElementsByTagName("Reading");
            readingId = new String[nl2.getLength()];
            readingType = new String[nl2.getLength()];
            readingValue = new String[nl2.getLength()];
            patientId = new String[nl2.getLength()];
            for (int temp = 0; temp < nl2.getLength(); temp++){
                Node n2 = nl2.item(temp);
                if (n2.getNodeType() == Node.ELEMENT_NODE) {
                    Element el2 = (Element) n2;
                    readingId[temp] = el2.getAttribute("id");
                    readingType[temp] = el2.getAttribute("type");
                    readingValue[temp] = el2.getElementsByTagName("value").item(0).getTextContent();
                    patientId[temp] = el2.getElementsByTagName("patient").item(0).getTextContent();
                }
            }
            ArrayList<ReadingJson> rjl = new ArrayList<>();

            for (int i = 0; i < readingId.length; i++){
                ReadingJson rj = new ReadingJson(patientId[i], readingType[i], readingId[i], readingValue[i], null, clinicId, clinicName);
                rjl.add(rj);
            }

            AddReadingToPatient(rjl);

        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

}
