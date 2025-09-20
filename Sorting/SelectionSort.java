package Sorting;
import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
   
    public static void main(String[] args) {
        int[] examScores = {85, 72, 93, 65, 80, 78, 90, 88};
        System.out.println("Original Exam Scores: " + Arrays.toString(examScores));
        selectionSort(examScores);
        System.out.println("Sorted Exam Scores: " + Arrays.toString(examScores));
    }
}