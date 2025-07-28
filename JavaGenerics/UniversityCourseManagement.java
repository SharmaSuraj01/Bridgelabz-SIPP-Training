import java.util.*;

abstract class CourseType {
    protected String evaluationType;
    
    public CourseType(String evaluationType) {
        this.evaluationType = evaluationType;
    }
    
    public String getEvaluationType() { return evaluationType; }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + evaluationType + ")";
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() { super("Exam-Based"); }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() { super("Assignment-Based"); }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() { super("Research-Based"); }
}

class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;
    private int credits;
    
    public Course(String courseName, String department, T courseType, int credits) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
        this.credits = credits;
    }
    
    public String getCourseName() { return courseName; }
    public String getDepartment() { return department; }
    public T getCourseType() { return courseType; }
    public int getCredits() { return credits; }
    
    @Override
    public String toString() {
        return courseName + " [" + department + "] - " + courseType + " (" + credits + " credits)";
    }
}

public class UniversityCourseManagement {
    
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        System.out.println("All Courses:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
    
    public static void main(String[] args) {
        Course<ExamCourse> mathCourse = new Course<>("Calculus I", "Mathematics", new ExamCourse(), 4);
        Course<AssignmentCourse> csCourse = new Course<>("Data Structures", "Computer Science", new AssignmentCourse(), 3);
        Course<ResearchCourse> physicsCourse = new Course<>("Quantum Physics", "Physics", new ResearchCourse(), 4);
        
        List<Course<? extends CourseType>> allCourses = Arrays.asList(mathCourse, csCourse, physicsCourse);
        
        displayAllCourses(allCourses);
        
        System.out.println("\nCourse Details:");
        System.out.println("Math Course Type: " + mathCourse.getCourseType().getEvaluationType());
        System.out.println("CS Course Type: " + csCourse.getCourseType().getEvaluationType());
        System.out.println("Physics Course Type: " + physicsCourse.getCourseType().getEvaluationType());
    }
}