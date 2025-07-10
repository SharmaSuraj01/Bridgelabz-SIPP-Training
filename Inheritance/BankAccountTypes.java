class BankAccount {
    String accountNumber;
    double balance;
    
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    void displayAccountType() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    
    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    void displayAccountType() {
        super.displayAccountType();
        System.out.println("Type: Savings Account, Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    
    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    @Override
    void displayAccountType() {
        super.displayAccountType();
        System.out.println("Type: Checking Account, Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod;
    
    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }
    
    @Override
    void displayAccountType() {
        super.displayAccountType();
        System.out.println("Type: Fixed Deposit, Maturity Period: " + maturityPeriod + " months");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SAV001", 5000, 3.5),
            new CheckingAccount("CHK001", 2000, 1000),
            new FixedDepositAccount("FD001", 10000, 12)
        };
        
        for (BankAccount account : accounts) {
            account.displayAccountType();
            System.out.println();
        }
    }
}