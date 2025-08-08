import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTest {
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
    
    @Test
    public void testDivideByZeroException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            divide(10, 0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }
    
    @Test
    public void testValidDivision() {
        assertEquals(5, divide(10, 2));
        assertEquals(-3, divide(-9, 3));
    }
}