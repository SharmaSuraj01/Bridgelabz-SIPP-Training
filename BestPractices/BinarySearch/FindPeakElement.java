package BestPractices.BinarySearch;
public class FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int peakIndex = findPeakElement(arr);
        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nPeak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}