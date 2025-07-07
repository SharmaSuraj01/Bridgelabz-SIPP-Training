public class BankAccount {
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;
    String accountHolderName;
    final int accountNumber;
    double balance;
    
    BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    static int getTotalAccounts() {
        return totalAccounts;
    }
    void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("moh", 12345, 5000.0);
        BankAccount acc2 = new BankAccount("maya", 67890, 7500.0);
        
        Object obj = acc1;
        if (obj instanceof BankAccount) {
            ((BankAccount) obj).displayDetails();
        }     
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}