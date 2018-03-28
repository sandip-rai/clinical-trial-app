package unitTest;
import org.junit.Test;
import org.junit.Assert;
import trial.*;
import file.xml.*;

public class XmlHandlerTest {
	@Test
	public void XmlHandlerUnitTest(){
		//reading test
		ClinicalTrial trial = new ClinicalTrial();
		XmlHandler xml = new XmlHandler(trial);
		String inpath = System.getProperty("user.dir")+"/assignment2_example.xml";
		Assert.assertTrue(xml.readXMLFile(inpath, true, true));
		Patient p = trial.findPatient("85545");
		Assert.assertNotNull(p);
		String reading = p.getReadings().get(0).getReadingId();
		Assert.assertTrue(reading.equals("ern222"));
	}
}
