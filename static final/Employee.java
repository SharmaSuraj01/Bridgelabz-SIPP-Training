public class Employee {
    static String companyName = "Tech Corp";
    static int totalEmployees = 0;
    String name;
    final int id;
    String designation;
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee("surya", 101, "Developer");
        Employee emp2 = new Employee("krti", 102, "Manager");
        
        Object emp = emp1;
        if (emp instanceof Employee) {
            ((Employee) emp).displayDetails();
        }
        
        Employee.displayTotalEmployees();
    }
}