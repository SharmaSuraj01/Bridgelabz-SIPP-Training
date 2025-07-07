public class StudentManagement {
    static String universityName = "ABC University";
    static int totalStudents = 0;
        String name;
    final int rollNumber;
    String grade;
        StudentManagement(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
        static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
        void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
        public static void main(String[] args) {
        StudentManagement student1 = new StudentManagement("suraj ", 2001, "A");
        StudentManagement student2 = new StudentManagement("uttam", 2002, "B"); 
        Object stu = student1;
        if (stu instanceof StudentManagement) {
            ((StudentManagement) stu).displayDetails();
        }
        StudentManagement.displayTotalStudents();
    }
}