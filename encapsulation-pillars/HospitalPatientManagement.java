import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private List<String> medicalHistory;
    
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }
    
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    protected List<String> getMedicalHistory() { return medicalHistory; }
    
    public void setName(String name) { this.name = name; }
    
    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
    
    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge = 1500;
    
    public InPatient(int patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }
    
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge + 5000;
    }
    
    @Override
    public void addRecord(String record) {
        getMedicalHistory().add("InPatient: " + record);
    }
    
    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(getMedicalHistory());
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private int consultationFee = 500;
    private int numberOfVisits;
    
    public OutPatient(int patientId, String name, int age, int numberOfVisits) {
        super(patientId, name, age);
        this.numberOfVisits = numberOfVisits;
    }
    
    public double calculateBill() {
        return numberOfVisits * consultationFee;
    }
    
    public void addRecord(String record) {
        getMedicalHistory().add("OutPatient: " + record);
    }
    
    public List<String> viewRecords() {
        return new ArrayList<>(getMedicalHistory());
    }
}

public class HospitalPatientManagement {
    public static void processPatients(List<Patient> patients) {
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails() + ", Bill: " + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                MedicalRecord record = (MedicalRecord) patient;
                record.addRecord("Regular checkup completed");
                System.out.println("Medical Records: " + record.viewRecords());
            }
        }
    }
    
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new InPatient(1, "Suraj", 45, 5),
            new OutPatient(2, "Archana", 30, 3)
        );
        
        processPatients(patients);
    }
}