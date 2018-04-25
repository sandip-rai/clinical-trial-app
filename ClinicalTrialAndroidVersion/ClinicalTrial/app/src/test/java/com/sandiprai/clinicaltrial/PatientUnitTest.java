package com.sandiprai.clinicaltrial;

import trial.Clinic;
import trial.Patient;
import trial.PatientState;
import trial.PatientStateActive;
import trial.PatientStateCompleted;
import trial.PatientStateFailed;
import trial.PatientStateWithdrawn;


import org.junit.Test;

import java.util.Date;

import org.junit.Assert;

/**
 * The Class PatientUnitTest.
 */
public class PatientUnitTest {

	/** The patient id. */
	String patientId = "1";
	
	/** The p. */
	Patient p;
	
	/** The c. */
	Clinic c = new Clinic("Clinic 1", "99");
	
	/**
	 * Patient test.
	 */
	@Test
	public void PatientTest() {
		//test constructor, isActive, getPatientId, get Readings
		p = new Patient(patientId);
		p.setState(new PatientStateActive(p));
		Assert.assertTrue(p.getState().toString().equals("Active"));
		Assert.assertEquals(patientId, p.getState().getPatientId());
		Assert.assertEquals(0,p.getState().getReadings().size());
		
		//test addReading and getReadings to active
		Assert.assertTrue(p.getState().addReading("001", "Weight", "150.5", new Date(), c));
		Assert.assertEquals(1,p.getState().getReadings().size());

		//test add duplicate id reading
		Assert.assertFalse(p.getState().addReading("001", "Weight", "99", new Date(), c));
		
		//test set to PatientStateWithdrawn
		p.setState(new PatientStateWithdrawn(p));
		Assert.assertTrue(p.getState().toString().equals("Withdrawn"));
		//test addReading and getReadings on Withdrawn
		Assert.assertFalse(p.getState().addReading("002", "Weight", "100", new Date(), c));
		Assert.assertTrue(p.getState().getReadings()==null);

		//test set to PatientStateFailed
		p.setState(new PatientStateFailed(p));
		Assert.assertTrue(p.getState().toString().equals("Failed"));
		//test addReading and getReadings on Failed
		Assert.assertFalse(p.getState().addReading("002", "Weight", "100", new Date(), c));
		Assert.assertTrue(p.getState().getReadings() == null);

		//test set to PatientStateCompleted
		p.setState(new PatientStateCompleted(p));
		Assert.assertTrue(p.getState().toString().equals("Completed"));
		//test addReading and getReadings on Complete
		Assert.assertFalse(p.getState().addReading("002", "Weight", "100", new Date(), c));
		Assert.assertFalse(p.getState().getReadings()==null);
	}
	
}
