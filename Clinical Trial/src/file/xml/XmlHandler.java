package file.xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import file.Handler;
import trial.ClinicalTrial;

public class XmlHandler extends Handler {
	
	public XmlHandler(ClinicalTrial clinicalTrial){
		this.clinicalTrial = clinicalTrial;
	}
	
	/*
	 * 
	 * Read the xml file, and please note that this also adds a clinic id.
	 */
	public boolean readXMLFile(String file, boolean addUnkownPatients, boolean addUnknownReadings) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ReadingSet.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ReadingSet readingSet = (ReadingSet) jaxbUnmarshaller.unmarshal(new File(file));
			ArrayList<FileReading> fileReadings = getFileReading(readingSet);
			if (addUnkownPatients) {
				addPatientsToTrial(fileReadings, addUnknownReadings);
			}
			AddReadingToPatient(fileReadings);
			return true;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}

	private ArrayList<FileReading> getFileReading(ReadingSet readingSet) {
		ArrayList<FileReading> fileReadings = new ArrayList<FileReading>();
		String clinic_id = readingSet.getClinic().getId();
		String clinic_name = readingSet.getClinic().getName();
		for (Reading reading : readingSet.getReadings()) {
			String patient_id = reading.getPatient();
			String reading_type = reading.getType();
			String reading_id = reading.getId();
			String reading_value = getValue(reading.getValue().getValue(), reading.getValue().getUnit());
			String reading_date = reading.getDate();
			FileReading fileReading = new FileReading(patient_id, reading_type, reading_id, reading_value, reading_date,
					clinic_id, clinic_name);
			fileReadings.add(fileReading);
		}
		return fileReadings;
	}

	private String getValue(String value, String unit) {
		if (value != null && unit != null) {
			return value + " " + unit;
		} else if (value != null && unit == null) {
			return value;
		} else {
			return null;
		}
	}
}
