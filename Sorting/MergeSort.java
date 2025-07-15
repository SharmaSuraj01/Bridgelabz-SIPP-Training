package Sorting;
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }
    private static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] L = new double[n1];
        double[] R = new double[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = prices[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        double[] bookPrices = {12.99, 8.99, 15.50, 9.99, 20.50, 5.99, 7.50};
        System.out.println("Original Book Prices: " + Arrays.toString(bookPrices));
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        System.out.println("Sorted Book Prices: " + Arrays.toString(bookPrices));
    }
}