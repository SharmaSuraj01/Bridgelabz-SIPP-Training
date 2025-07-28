import java.util.*;

public class BankingSystem {
    private HashMap<String, Double> accounts;
    private Queue<String> withdrawalRequests;
    
    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalRequests = new LinkedList<>();
    }
    
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }
    
    public void deposit(String accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
    }
    
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalRequests.add(accountNumber);
        }
    }
    
    public void processWithdrawals() {
        System.out.println("Processing withdrawals:");
        while (!withdrawalRequests.isEmpty()) {
            String account = withdrawalRequests.poll();
            System.out.println("Processing withdrawal for: " + account);
        }
    }
    
    public void displayAccountsSortedByBalance() {
        TreeMap<Double, String> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedByBalance.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Accounts sorted by balance: " + sortedByBalance);
    }
    
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        bank.createAccount("ACC001", 1000.0);
        bank.createAccount("ACC002", 1500.0);
        bank.createAccount("ACC003", 500.0);
        
        bank.requestWithdrawal("ACC001");
        bank.requestWithdrawal("ACC003");
        
        bank.displayAccountsSortedByBalance();
        bank.processWithdrawals();
    }
}