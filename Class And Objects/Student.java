
import java.util.Scanner;

public class Student {
	 String name;
	 int rollNumber;
	 int marks;
	 Student(String name, int rollNumber, int marks) {
	        this.name = name;
	        this.rollNumber = rollNumber;
	        this.marks = marks;
	  }
	  String calculateGrade() {
	        if (marks >= 90) return "A";
	        else if (marks >= 75) return "B";
	        else if (marks >= 60) return "C";
	        else if (marks >= 40) return "D";
	        else return "F";
	   }
	   void display() {
	        System.out.println("Name: " + name);
	        System.out.println("Roll No: " + rollNumber);
	        System.out.println("Marks: " + marks);
	        System.out.println("Grade: " + calculateGrade());
	    }

public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter student name: ");
      String name = sc.nextLine();
      System.out.print("Enter roll number: ");
      int roll = sc.nextInt();
      System.out.print("Enter marks: ");
      int marks = sc.nextInt();
      Student student = new Student(name, roll, marks);
      student.display();
  }
}