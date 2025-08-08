import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTest {
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void testEvenNumbers(int number) {
        assertTrue(isEven(number));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testOddNumbers(int number) {
        assertFalse(isEven(number));
    }
}