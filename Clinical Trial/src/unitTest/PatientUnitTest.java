package unitTest;

import trial.Clinic;
import trial.Patient;

import org.junit.Test;

import java.util.Date;

import org.junit.Assert;

public class PatientUnitTest {

	String patientId = "1";
	Patient p;
	Clinic c = new Clinic("Clinic 1", "99");
	
	@Test
	public void PatientTest() {
		//test constructor, isActive, getPatientId, get Readings
		p = new Patient(patientId);
		Assert.assertTrue(p.isActive());
		Assert.assertEquals(patientId, p.getPatientId());
		Assert.assertEquals(0,p.getReadings().size());
		
		//test addReading to active
		Assert.assertTrue(p.addReading("001", "Weight", "150.5", new Date(), c));
		Assert.assertEquals(1,p.getReadings().size());
		
		//test add duplicate id reading
		Assert.assertFalse(p.addReading("001", "Weight", "99", new Date(), c));
		
		//test setActive
		p.setActive(false);
		Assert.assertFalse(p.isActive());
		//test addReading to inactive
		Assert.assertFalse(p.addReading("002", "Weight", "100", new Date(), c));
		
	}
	
}
