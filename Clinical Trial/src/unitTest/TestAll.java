package unitTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestAll {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(JunitTestSuite.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      boolean successful = result.wasSuccessful();
      if (successful) {
			System.out.println("All tests passed.");
		}else {
			System.out.println("Test failed.");
		}
   }
}  	