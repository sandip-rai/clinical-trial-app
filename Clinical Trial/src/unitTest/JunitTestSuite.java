package unitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The Class JunitTestSuite.
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
	ClincalTrailUnitTest.class,
	ClinicUnitTest.class,
   FileAdapterTest.class,
   GuiControllerTest.class,
	JsonHandlerTest.class,
	PatientUnitTest.class,
	ReadingUnitTest.class,
	XmlHandlerTest.class
})

public class JunitTestSuite {   
}  		