import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;
    private double amount;
    private String date;
    
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
        this.amount = Math.random() * 1000 + 100; // Random amount between 100-1100
        this.date = "2024-01-" + String.format("%02d", (int)(Math.random() * 28) + 1);
    }
    
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    
    @Override
    public String toString() {
        return String.format("Invoice{id='%s', amount=$%.2f, date='%s'}", 
                           transactionId, amount, date);
    }
}

public class InvoiceObjectCreation {
    
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN001", "TXN002", "TXN003", "TXN004", "TXN005"
        );
        
        System.out.println("=== Invoice Object Creation ===");
        System.out.println("Transaction IDs:");
        transactionIds.forEach(System.out::println);
        
        System.out.println("\nCreating invoices using constructor reference:");
        // Using constructor reference Invoice::new
        List<Invoice> invoices = transactionIds.stream()
                                              .map(Invoice::new)
                                              .collect(Collectors.toList());
        
        invoices.forEach(System.out::println);
        
        System.out.println("\nComparison - Using lambda instead of constructor reference:");
        List<Invoice> invoicesLambda = transactionIds.stream()
                                                    .map(id -> new Invoice(id)) // Lambda equivalent
                                                    .collect(Collectors.toList());
        
        invoicesLambda.forEach(System.out::println);
        
        System.out.println("\nTotal invoice amount:");
        double totalAmount = invoices.stream()
                                   .mapToDouble(Invoice::getAmount)
                                   .sum();
        System.out.printf("$%.2f%n", totalAmount);
    }
}