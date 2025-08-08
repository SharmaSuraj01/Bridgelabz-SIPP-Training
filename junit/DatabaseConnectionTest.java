import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    
    private DatabaseConnection dbConnection;
    
    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }
    
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();
    }
    
    @Test
    public void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected());
    }
    
    @Test
    public void testAnotherOperation() {
        assertTrue(dbConnection.isConnected());
        // Simulate some database operation
    }
}