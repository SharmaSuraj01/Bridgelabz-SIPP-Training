import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "'}";
    }
}

public class NameUppercasing {
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("john doe", "HR"),
            new Employee("jane smith", "IT"),
            new Employee("bob johnson", "Finance"),
            new Employee("alice brown", "Marketing")
        );
        
        System.out.println("=== Employee Name Uppercasing ===");
        System.out.println("Original employee names:");
        employees.forEach(emp -> System.out.println(emp.getName()));
        
        System.out.println("\nUppercase names using String::toUpperCase method reference:");
        List<String> uppercaseNames = employees.stream()
                                               .map(Employee::getName)
                                               .map(String::toUpperCase)
                                               .collect(Collectors.toList());
        
        uppercaseNames.forEach(System.out::println);
        
        System.out.println("\nFormatted HR letter names:");
        employees.stream()
                 .map(Employee::getName)
                 .map(String::toUpperCase)
                 .map(name -> "Dear " + name + ",")
                 .forEach(System.out::println);
        
        System.out.println("\nComparison - Using lambda instead of method reference:");
        employees.stream()
                 .map(Employee::getName)
                 .map(name -> name.toUpperCase()) // Lambda equivalent
                 .forEach(System.out::println);
    }
}