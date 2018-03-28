package unitTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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
		Result result = JUnitCore.runClasses(JunitTestSuite.class);
		boolean successful = result.wasSuccessful();
		if (successful) {
			System.out.println("All tests passed.");
		} else {
			for (Failure failure : result.getFailures()) {
				System.out.println("FAILURE: " + failure.toString());
				System.out.println(failure.getTrace());
			}
		}
	}
}