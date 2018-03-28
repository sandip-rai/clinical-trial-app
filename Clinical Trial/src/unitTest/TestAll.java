package unitTest;

/**
 * The Class TestAll.
 */
public class TestAll {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		//Instantiate new tests
		ClincalTrailUnitTest trialTest = new ClincalTrailUnitTest();
		ClinicUnitTest clinicTest = new ClinicUnitTest();
		FileAdapterTest adapterTest = new FileAdapterTest();
		GuiControllerTest controllerTest = new GuiControllerTest();
		JsonHandlerTest jsonTest = new JsonHandlerTest();
		PatientUnitTest patientTest = new PatientUnitTest();
		ReadingUnitTest readingTest = new ReadingUnitTest();
		XmlHandlerTest xmlTest = new XmlHandlerTest();
		//Run All tests
		trialTest.testAll();
		clinicTest.testAll();
		adapterTest.FileAdapterUnitTest();
		controllerTest.testAll();
		jsonTest.JsonHandlerUnitTest();
		patientTest.PatientTest();
		readingTest.testAll();
		xmlTest.XmlHandlerUnitTest();

	}

}

	
	