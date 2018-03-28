package unitTest;
import org.junit.Test;
import org.junit.Assert;
import trial.*;
import file.*;

public class FileAdapterTest {
	@Test
	public void FileAdapterUnitTest(){
		//test to make sure file upload works for both json and xml files
		//because of the way the methods were written, will need to run this test twice and select different files with the filechooser
		ClinicalTrial trial = new ClinicalTrial();
		FileAdapter fa = new FileAdapter();
		System.out.println("Please select a valid .json or .xml file to import.");
		Assert.assertTrue(fa.readFile(trial));
	}
}
