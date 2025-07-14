import java.util.*;

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;
    
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    
    public void setName(String name) { this.name = name; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + 
                          ", Salary: " + calculateSalary() + ", Dept: " + getDepartmentDetails());
    }
    
    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }
    
    @Override
    public String getDepartmentDetails() {
        return department != null ? department : "Not Assigned";
    }
}

class FullTimeEmployee extends Employee {
    private int workHours;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary, int workHours) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours > 40 ? (workHours - 40) * 50 : 0);
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new FullTimeEmployee(1, "John", 5000, 45),
            new PartTimeEmployee(2, "Jane", 0, 20, 25)
        );
        
        employees.get(0).assignDepartment("IT");
        employees.get(1).assignDepartment("HR");
        
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}