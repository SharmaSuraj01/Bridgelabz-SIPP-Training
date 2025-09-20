import java.util.*;

class Patient {
    private String id;
    private String name;
    
    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return "Patient{id='" + id + "', name='" + name + "'}";
    }
}

public class HospitalPatientPrinting {
    
    public static void printPatientId(Patient patient) {
        System.out.println("Patient ID: " + patient.getId());
    }
    
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient("P001", "John Doe"),
            new Patient("P002", "Jane Smith"),
            new Patient("P003", "Bob Johnson"),
            new Patient("P004", "Alice Brown")
        );
        
        System.out.println("=== Hospital Patient ID Printing ===");
        System.out.println("All patients:");
        patients.forEach(System.out::println);
        
        System.out.println("\nPatient IDs using Method Reference:");
        // Using method reference instead of lambda
        patients.forEach(HospitalPatientPrinting::printPatientId);
        
        System.out.println("\nPatient IDs using Lambda (for comparison):");
        // Lambda equivalent
        patients.forEach(patient -> System.out.println("Patient ID: " + patient.getId()));
        
        System.out.println("\nPatient IDs using Stream and Method Reference:");
        patients.stream()
                .map(Patient::getId)
                .forEach(System.out::println);
    }
}