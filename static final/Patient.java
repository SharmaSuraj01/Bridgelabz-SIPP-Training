public class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    String name;
    int age;
    String ailment;
    final int patientID;
    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
    static int getTotalPatients() {
        return totalPatients;
    }
    void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
    }
    public static void main(String[] args) {
        Patient patient1 = new Patient("David", 35, "Fever", 3001);
        Patient patient2 = new Patient("Emma", 28, "Headache", 3002);
        
        Object obj = patient1;
        if (obj instanceof Patient) {
            ((Patient) obj).displayDetails();
        }   
        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}