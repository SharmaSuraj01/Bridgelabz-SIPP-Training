package Sorting;
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] studentMarks = {78, 65, 90, 82, 70, 93, 88, 60};
        System.out.println("Original Student Marks: " + Arrays.toString(studentMarks));
        bubbleSort(studentMarks);
        System.out.println("Sorted Student Marks: " + Arrays.toString(studentMarks));
    }
}