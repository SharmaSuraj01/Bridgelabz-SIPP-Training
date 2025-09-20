package Sorting;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] employeeIds = {1045, 1023, 1067, 1089, 1015, 1056};
        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIds));
        insertionSort(employeeIds);
        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIds));
    }
}