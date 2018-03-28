package unitTest;
import org.junit.Test;
import org.junit.Assert;
import trial.*;

public class ClincalTrailUnitTest {

	
	@Test
	// unit test method to test the addPatient method 
	public void uTestForAddPatient(){
		
		
		// input
		
		String id = "001";
		
		//object 
		ClinicalTrial  clt = new ClinicalTrial();
		
		Assert.assertTrue(clt.addPatient(id));
	}
	
	
	@Test
	// unit test method to test the findPatient method 
	public void uTestForFindPatient(){
		
		
		ClinicalTrial  clt = new ClinicalTrial();
		
	
		//adding a single object of Patient
		clt.addPatient("001");
		
		//call to findPatient returning an object if Patient is found or null if not
		Patient obj1 = clt.findPatient("001");
		Patient obj2 = clt.findPatient("002");
		
		//checking if the method returns the object and null 
		Assert.assertNotNull(obj1);
		Assert.assertNull(obj2);
		//checking if objects are in instances of Patient or not
		Assert.assertTrue(obj1 instanceof Patient);
		Assert.assertFalse(obj2 instanceof Patient);
	
	}
	
	@Test
	// unit test method to test the addClinic method 
	public void uTestForAddClinic(){
		
		
		// input
		
		String id = "CLN001";
		String name = "Clinic-A";
		//object 
		
		
		ClinicalTrial  clt = new ClinicalTrial();
		Assert.assertNotNull(clt);
		
		Clinic clinic = clt.addClinic(name, id);
		Assert.assertNotNull(clinic);
		
		Assert.assertEquals(id, clinic.getId());
		Assert.assertEquals(name, clinic.getName());
	}
	
	
	@Test
	// unit test method to test the findClinic method 
	public void uTestForFindClinic(){
		
		ClinicalTrial  clt = new ClinicalTrial();

		//adding a single object of Patient
		clt.addClinic("Clinic-A", "CLN001");
	
		//call to findClinic returning an object if clinic is found or null if not
		Clinic clinic1 = clt.findClinic("CLN001");
		Clinic clinic2 = clt.findClinic("CLN002");
		
		//checking if the method returns the object and null 
		Assert.assertNotNull(clinic1);
		Assert.assertNull(clinic2);
		
		//checking if objects are in instances of Clinic or not
		Assert.assertTrue(clinic1 instanceof Clinic);
		Assert.assertFalse(clinic2 instanceof Clinic);
	}
}
