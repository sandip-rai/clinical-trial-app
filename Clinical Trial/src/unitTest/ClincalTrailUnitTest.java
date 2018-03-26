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
		
		Patient obj = new Patient("001");
		
		Assert.assertNotNull(obj);
		
		Assert.assertTrue(obj instanceof Patient);
	
	}
	
	@Test
	// unit test method to test the addClinic method 
	public void uTestForAddClinic(){
		
		
		// input
		
		String id = "CLN001";
		String name = "Clinic-A";
		//object 
		ClinicalTrial  clt = new ClinicalTrial();
		Clinic clinic = clt.addClinic(name, id);
		Assert.assertEquals(id, clinic.getId());
		Assert.assertEquals(name, clinic.getName());
	}
	
	
	@Test
	// unit test method to test the findClinic method 
	public void uTestForFindClinic(){
		
		Clinic obj = new Clinic("Clinic-A","CLN001");
		
		Assert.assertNotNull(obj);
		
		Assert.assertTrue(obj instanceof Clinic);
	
	}
}
