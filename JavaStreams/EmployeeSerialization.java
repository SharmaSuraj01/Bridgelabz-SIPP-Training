import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    
    int id;
    String name;
    String department;
    double salary;
    
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeSerialization {
    
    public static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return new ArrayList<>();
    }
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Suraj", "IT", 75000),
            new Employee(2, "sameer", "HR", 65000),
            new Employee(3, "uttam", "Finance", 70000)
        );
        
        String filename = "employees.ser";
        
        // Serialize
        serializeEmployees(employees, filename);
        
        // Deserialize
        List<Employee> deserializedEmployees = deserializeEmployees(filename);
        System.out.println("Deserialized employees:");
        deserializedEmployees.forEach(System.out::println);
    }
}