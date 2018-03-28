package unitTest;
import org.junit.Test;
import org.junit.Assert;
import trial.*;
import file.json.*;

/**
 * The Class JsonHandlerTest.
 */
public class JsonHandlerTest {
	
	/**
	 * Json handler unit test.
	 */
	@Test
	public void JsonHandlerUnitTest(){
		//reading test
		ClinicalTrial trial = new ClinicalTrial();
		trial.getSettings().setJsonAddUnknownPatients(false);
		trial.getSettings().setJsonAddUnknownReadings(false);
		JsonHandler json = new JsonHandler(trial);
		String inpath = System.getProperty("user.dir")+"/assignment_1_example.json";
		Assert.assertTrue(json.readFile(inpath));
		Patient p = trial.findPatient("12513");
		Assert.assertNull(p);
		trial.getSettings().setJsonAddUnknownPatients(true);
		trial.getSettings().setJsonAddUnknownReadings(true);
		Assert.assertTrue(json.readFile(inpath));
		p = trial.findPatient("12513");
		Assert.assertNotNull(p);
		String reading = p.getReadings().get(0).getReadingId();
		Assert.assertTrue(reading.equals("48934j"));
		
		//writing test
		String outpath = System.getProperty("user.dir")+"/testWritePatientReadings.json";
		Assert.assertTrue(json.WritePatientReadings(outpath));
		Assert.assertTrue(json.readFile(outpath));
		
		//save state test
		Assert.assertTrue(json.saveState());
		
		//load the save state test
		trial = json.loadState();
		p=trial.findPatient("12513");
		Assert.assertNotNull(p);
	}
}
