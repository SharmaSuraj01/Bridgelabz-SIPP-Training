import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;
    
    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
    
    @Override
    public String toString() {
        return "Student{rollNumber=" + rollNumber + ", name='" + name + "', gpa=" + gpa + "}";
    }
}

public class DataStreams {
    
    public static void writeStudentData(Student[] students, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            
            dos.writeInt(students.length); // Write number of students
            
            for (Student student : students) {
                dos.writeInt(student.rollNumber);
                dos.writeUTF(student.name);
                dos.writeDouble(student.gpa);
            }
            
            System.out.println("Student data written to " + filename);
            
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }
    
    public static Student[] readStudentData(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            
            int count = dis.readInt(); // Read number of students
            Student[] students = new Student[count];
            
            for (int i = 0; i < count; i++) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                students[i] = new Student(rollNumber, name, gpa);
            }
            
            return students;
            
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
            return new Student[0];
        }
    }
    
    public static void main(String[] args) {
        Student[] students = {
            new Student(101, "Alice", 3.8),
            new Student(102, "Bob", 3.5),
            new Student(103, "Charlie", 3.9)
        };
        
        String filename = "students.dat";
        
        // Write data
        writeStudentData(students, filename);
        
        // Read data
        Student[] readStudents = readStudentData(filename);
        System.out.println("Read student data:");
        for (Student student : readStudents) {
            System.out.println(student);
        }
    }
}