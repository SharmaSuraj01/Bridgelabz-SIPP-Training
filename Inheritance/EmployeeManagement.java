class Employee {
    String name;
    int id;
    double salary;
    
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: $" + salary);
    }
}

class Manager extends Employee {
    int teamSize;
    
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;
    
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    int duration;
    
    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }
    
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + duration + " months");
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Suraj", 101, 80000, 5),
            new Developer("Uttam", 102, 70000, "Java"),
            new Intern("Sameer", 103, 55000, 6)
        };
        
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}