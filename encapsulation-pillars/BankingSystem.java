import java.util.*;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4%
    
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    
    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for " + getHolderName());
        } else {
            System.out.println("Loan rejected for " + getHolderName());
        }
    }
    
    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; 
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; // 2%
    
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    
    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Business loan of " + amount + " approved for " + getHolderName());
        } else {
            System.out.println("Business loan rejected for " + getHolderName());
        }
    }
    
    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 50000; 
    }
}

public class BankingSystem {
    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + 
                             ", Interest: " + account.calculateInterest());
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(100000);
            }
        }
    }
    
    public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
            new SavingsAccount("SAV001", "Suraj", 15000),
            new CurrentAccount("CUR001", "uttam", 75000)
        );
        
        processAccounts(accounts);
    }
}