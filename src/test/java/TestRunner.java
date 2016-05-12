import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by mixmax on 14.12.15.
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ContactTest.class, TestContactRepository.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString() + " - ");
        }

        System.out.println(result.wasSuccessful());
    }
}

