import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    
    private BankAccount account;
    
    @BeforeEach
    public void setUp() {
        account = new BankAccount(100.0);
    }
    
    @Test
    public void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }
    
    @Test
    public void testWithdrawSuccess() {
        assertTrue(account.withdraw(30.0));
        assertEquals(70.0, account.getBalance());
    }
    
    @Test
    public void testWithdrawInsufficientFunds() {
        assertFalse(account.withdraw(150.0));
        assertEquals(100.0, account.getBalance());
    }
    
    @Test
    public void testWithdrawNegativeAmount() {
        assertFalse(account.withdraw(-10.0));
        assertEquals(100.0, account.getBalance());
    }
}