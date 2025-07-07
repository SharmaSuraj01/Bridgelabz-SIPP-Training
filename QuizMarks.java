import java.util.*;

class Student {
        String name;
        String[] subjects;
        int[] marks;

        Student(String name, String[] subjects, int[] marks) {
            this.name = name;
            this.subjects = subjects;
            this.marks = marks;
            for (int mark:marks) {
                if (mark < 0 || mark > 100) {
                    System.out.println("Not valid marks");
                }
            }
        }
         double getAvg() {
            int sum=0;
            for(int mark: marks){
                sum+=mark;
            }
            return sum/(double)marks.length;
        }
        String grade(){
            double avg=getAvg();
            if(avg>=90) return "A";
            if (avg>=80) return "B";
            if (avg>=70) return "C";
            if(avg>=60) return "D";
            if (avg>=50) return "E";
            return "F";
        }
        void Display(){
            System.out.println("Name"+name);
            for (String subject : subjects) {
                System.out.println("subject" + subject);
            }
            for (int mark : marks) {
                System.out.println("Marks" + mark);
            }
            System.out.println("Average is"+getAvg());
            System.out.println("Grade is"+grade());
        }
    }
    public  class QuizMarks{
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        String[] subject={"physics","chemistry","Maths","English"};
        list.add(new Student("Suraj",subject,new int[]{50,60,70,80}));
        list.add(new Student("Sameer",subject,new int[]{88,90,60,99}));
        list.add(new Student("Dheeraj",subject,new int[]{54,20,58,45}));
        list.add(new Student("Aadi",subject,new int[]{70,90,80,98}));
        for(Student s:list){
            s.Display();
        }
    }
}
