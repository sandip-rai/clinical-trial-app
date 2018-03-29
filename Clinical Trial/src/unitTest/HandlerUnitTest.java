package unitTest;
import file.Handler;

import org.junit.Test;

import java.util.Date;
import java.util.ArrayList;

import org.junit.Assert;

public class HandlerUnitTest {
	String patient_id, reading_type, reading_id, reading_value, clinic_id, clinic_name;
	Date reading_date;
	
	public void testAll() {
		Handler h = new Handler();
		patient_id = "001";
		reading_type = "Bp";
		reading_id = "101";
		reading_value = "120/70";
		reading_date = new Date();
		clinic_id = "001";
		clinic_name = "Clinic 1";
		Handler.FileReading fr = h.new FileReading(patient_id, reading_type, reading_id, 
				reading_value, reading_date.toString(), clinic_id, clinic_name);
		Handler.FileReading fr1 = h.new FileReading(patient_id, reading_type, reading_id, 
				reading_value, reading_date.toString(), clinic_id, clinic_name);
		Handler.FileReading fr2 = h.new FileReading(patient_id, reading_type, reading_id, 
				reading_value, reading_date.toString(), clinic_id, clinic_name);
		ArrayList<Handler.FileReading> frs = new ArrayList<>();
		frs.add(fr);
		frs.add(fr1);
		frs.add(fr2);
		
		Assert.assertNotNull(h);
		
		h.addClinicToTrial(frs);
		h.addPatientsToTrial(frs, true);
		h.AddReadingToPatient(frs);
		
		Assert.assertNotNull(h.getClinicalTrial());
	}
}
