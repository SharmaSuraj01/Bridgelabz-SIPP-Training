import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    
    private PasswordValidator validator = new PasswordValidator();
    
    @Test
    public void testValidPasswords() {
        assertTrue(validator.isValid("Password1"));
        assertTrue(validator.isValid("MySecure123"));
        assertTrue(validator.isValid("Test1234"));
    }
    
    @Test
    public void testInvalidPasswords() {
        assertFalse(validator.isValid("short1")); // Too short
        assertFalse(validator.isValid("nouppercase1")); // No uppercase
        assertFalse(validator.isValid("NODIGITS")); // No digits
        assertFalse(validator.isValid("NoDigits")); // No digits
        assertFalse(validator.isValid(null)); // Null password
    }
}