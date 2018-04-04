import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
     System.out.println("Runnings tests...");
      Result result = JUnitCore.runClasses(TestSimulation.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.printf("Tests Ran: %s, Passed: %s Failed: %s%n", result.getRunCount(), result.getRunCount()-result.getFailureCount(), result.getFailureCount());
   }
}
