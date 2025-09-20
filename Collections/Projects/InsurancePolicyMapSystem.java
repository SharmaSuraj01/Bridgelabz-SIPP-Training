import java.time.LocalDate;
import java.util.*;

class PolicyMap {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    
    public PolicyMap(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    @Override
    public String toString() {
        return holderName + " (" + coverageType + ", expires: " + expiryDate + ")";
    }
}

public class InsurancePolicyMapSystem {
    private HashMap<String, PolicyMap> hashMapPolicies;
    private LinkedHashMap<String, PolicyMap> linkedHashMapPolicies;
    private TreeMap<LocalDate, PolicyMap> treeMapPolicies;
    
    public InsurancePolicyMapSystem() {
        hashMapPolicies = new HashMap<>();
        linkedHashMapPolicies = new LinkedHashMap<>();
        treeMapPolicies = new TreeMap<>();
    }
    
    public void addPolicy(PolicyMap policy) {
        hashMapPolicies.put(policy.policyNumber, policy);
        linkedHashMapPolicies.put(policy.policyNumber, policy);
        treeMapPolicies.put(policy.expiryDate, policy);
    }
    
    public PolicyMap getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }
    
    public List<PolicyMap> getPoliciesExpiringSoon() {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        List<PolicyMap> expiring = new ArrayList<>();
        
        for (PolicyMap policy : hashMapPolicies.values()) {
            if (policy.expiryDate.isBefore(thirtyDaysFromNow)) {
                expiring.add(policy);
            }
        }
        return expiring;
    }
    
    public List<PolicyMap> getPoliciesByHolder(String holderName) {
        List<PolicyMap> policies = new ArrayList<>();
        for (PolicyMap policy : hashMapPolicies.values()) {
            if (policy.holderName.equals(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }
    
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        hashMapPolicies.entrySet().removeIf(entry -> entry.getValue().expiryDate.isBefore(today));
        linkedHashMapPolicies.entrySet().removeIf(entry -> entry.getValue().expiryDate.isBefore(today));
        treeMapPolicies.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
    }
    
    public static void main(String[] args) {
        InsurancePolicyMapSystem system = new InsurancePolicyMapSystem();
        
        system.addPolicy(new PolicyMap("P001", "John Doe", LocalDate.of(2024, 6, 15), "Health", 1200.0));
        system.addPolicy(new PolicyMap("P002", "Jane Smith", LocalDate.of(2024, 3, 10), "Auto", 800.0));
        
        System.out.println("Policy P001: " + system.getPolicyByNumber("P001"));
        System.out.println("Policies expiring soon: " + system.getPoliciesExpiringSoon());
        System.out.println("John's policies: " + system.getPoliciesByHolder("John Doe"));
    }
}