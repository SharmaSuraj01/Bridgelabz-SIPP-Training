import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class TimeoutTest {
    
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task completed";
    }
    
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTaskTimeout() {
        // This test will fail because the method takes 3 seconds but timeout is 2 seconds
        longRunningTask();
    }
    
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testLongRunningTaskSuccess() {
        // This test will pass because timeout is 5 seconds
        String result = longRunningTask();
        assertEquals("Task completed", result);
    }
}