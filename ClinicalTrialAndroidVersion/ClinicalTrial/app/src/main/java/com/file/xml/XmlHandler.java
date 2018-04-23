package com.file.xml;

import java.io.File;
import java.util.ArrayList;
import com.file.Handler;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import trial.ClinicalTrial;

/**
 * The Class XmlHandler.
 */
public class XmlHandler extends Handler {

	/**
	 * Instantiates a new xml handler.
	 *
	 * @param clinicalTrial
	 *            the clinical trial
	 */
	public XmlHandler(ClinicalTrial clinicalTrial) {
		this.clinicalTrial = clinicalTrial;
	}

	/**
	 * Read XML file.
	 *
	 * @param path
	 *            the file
	 * @return true, if successful
	 * @throws Exception 
	 */
	public boolean readXMLFile(String path) throws Exception {
		// Decide how to handle unknown patients and readings based on system settings
		boolean addPatients = clinicalTrial.getSettings().xmlAddUnknownPatients();
		boolean addReadings = clinicalTrial.getSettings().xmlAddUnknownReadings();
			File file = new File(path);
			Serializer serializer = new Persister();
			ReadingSet readingSet = serializer.read(ReadingSet.class, file);
			// Convert from a reading set to an ArrayList of FileReadings so that the data
			// can be processed
			ArrayList<FileReading> fileReadings = getFileReading(readingSet);
			// Attempt to add the clinics to the trial
			addClinicToTrial(fileReadings);
			// If system settings are to add unknown patients attempt to add the patients to
			// the trial
			if (addPatients) {
				addPatientsToTrial(fileReadings, addReadings);
			}
			// Add readings from input file to Patient's readings ArrayList
			AddReadingToPatient(fileReadings);
			return true;

	}

	/**
	 * Converts a ReadingSet into and ArrayList of File Readings
	 *
	 * @param readingSet
	 *            the reading set
	 * @return the file reading
	 */
	private ArrayList<FileReading> getFileReading(ReadingSet readingSet) {
		// Instantiate a FileReading ArrayList
		ArrayList<FileReading> fileReadings = new ArrayList<FileReading>();
		// set clinic variables
		String clinic_id = readingSet.getClinic().getId();
		String clinic_name = readingSet.getClinic().getName();
		for (Reading reading : readingSet.getReadings()) {
			// set reading variables
			String patient_id = reading.getPatient();
			String reading_type = reading.getType();
			String reading_id = reading.getId();
			String reading_value = getValue(reading.getValue().getValue(), reading.getValue().getUnit());
			String reading_date = reading.getDate();
			// Instantiate a new FileReading
			FileReading fileReading = new FileReading(patient_id, reading_type, reading_id, reading_value, reading_date,
					clinic_id, clinic_name);
			// Add the FileReading to the fileReadings ArrayList
			fileReadings.add(fileReading);
		}
		return fileReadings;
	}

	/**
	 * Unifies Value and Unit into a single String
	 *
	 * @param value
	 *            the value
	 * @param unit
	 *            the unit
	 * @return the value
	 */
	private String getValue(String value, String unit) {
		if (value != null && unit != null) {
			// If both value and unit are not null concatenate them to a single String
			return value + " " + unit;
		} else if (value != null && unit == null) {
			// If no unit return only the value
			return value;
		} else {
			// if the was no value return null
			return null;
		}
	}
}
