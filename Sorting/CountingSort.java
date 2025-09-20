package Sorting;
import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages) {
        int n = ages.length;
        int min = 10; 
        int max = 18; 
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }
        
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }
        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] studentAges = {14, 12, 16, 15, 13, 17, 11, 15, 14, 16, 12, 10, 18};
        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));
        countingSort(studentAges);
        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}