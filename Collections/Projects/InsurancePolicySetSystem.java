import java.time.LocalDate;
import java.util.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    
    public Policy(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }
    
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    
    public String toString() {
        return policyNumber + " (" + holderName + ", " + coverageType + ", expires: " + expiryDate + ")";
    }
}

public class InsurancePolicySetSystem {
    private HashSet<Policy> hashSetPolicies;
    private LinkedHashSet<Policy> linkedHashSetPolicies;
    private TreeSet<Policy> treeSetPolicies;
    
    public InsurancePolicySetSystem() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>();
    }
    
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }
    
    public Set<Policy> getPoliciesExpiringSoon() {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        Set<Policy> expiringSoon = new HashSet<>();
        
        for (Policy policy : hashSetPolicies) {
            if (policy.expiryDate.isBefore(thirtyDaysFromNow)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }
    
    public Set<Policy> getPoliciesByCoverage(String coverageType) {
        Set<Policy> filtered = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.coverageType.equals(coverageType)) {
                filtered.add(policy);
            }
        }
        return filtered;
    }
    
    public void displayAllSets() {
        System.out.println("HashSet (Quick lookup): " + hashSetPolicies);
        System.out.println("LinkedHashSet (Insertion order): " + linkedHashSetPolicies);
        System.out.println("TreeSet (Sorted by expiry): " + treeSetPolicies);
    }
    
    public static void main(String[] args) {
        InsurancePolicySetSystem system = new InsurancePolicySetSystem();
        
        system.addPolicy(new Policy("P001", "Suraj", LocalDate.of(2024, 6, 15), "Health", 1200.0));
        system.addPolicy(new Policy("P002", "uttam", LocalDate.of(2024, 3, 10), "Auto", 800.0));
        system.addPolicy(new Policy("P003", "Kruti", LocalDate.of(2024, 8, 20), "Home", 1500.0));
        
        system.displayAllSets();
        
        System.out.println("\nPolicies expiring soon: " + system.getPoliciesExpiringSoon());
        System.out.println("Health policies: " + system.getPoliciesByCoverage("Health"));
    }
}