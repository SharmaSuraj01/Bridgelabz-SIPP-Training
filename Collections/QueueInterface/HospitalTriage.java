import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;
    
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Higher severity first
    }
    
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    
    public static void main(String[] args) {
        PriorityQueue<Patient> triage = new PriorityQueue<>();
        
        triage.add(new Patient("Suraj", 3));
        triage.add(new Patient("Uttam", 5));
        triage.add(new Patient("Archana", 2));
        
        System.out.println("Treatment Order:");
        while (!triage.isEmpty()) {
            System.out.println(triage.poll());
        }
    }
}