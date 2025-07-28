import java.util.*;

class Employee {
    String name;
    String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public String toString() {
        return name;
    }
}

public class GroupByProperty {
    
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        
        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        
        return grouped;
    }
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Suraj", "HR"),
            new Employee("Uttam", "IT"),
            new Employee("Archana", "HR")
        );
        
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        
        System.out.println("Employees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}