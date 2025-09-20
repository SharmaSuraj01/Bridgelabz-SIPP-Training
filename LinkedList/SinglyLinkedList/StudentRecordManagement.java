package LinkedList.SinglyLinkedList;
class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;
    
    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    Student head;
    
    void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
    
    void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }
    
    void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    
    Student search(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    void updateGrade(int rollNumber, String newGrade) {
        Student student = search(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }
    
    void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + 
                             ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.addAtEnd(101, "Suraj", 20, "A");
        list.addAtEnd(102, "Uttam", 21, "B");
        list.addAtBeginning(100, "Sameer", 19, "A+");
        list.display();
        System.out.println("\nAfter updating grade:");
        list.updateGrade(101, "A+");
        list.display();
    }
}