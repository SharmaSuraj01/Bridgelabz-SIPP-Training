package BestPractices.LinearSearch;
public class FindFirstNegative {
    
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1; 
    }
    public static void main(String[] args) {
        int[] numbers = {5, 8, 2, -3, 9, -6, 0, 4};
        int index = findFirstNegative(numbers);
        if (index != -1) {
            System.out.println("First negative number found at index " + index + ": " + numbers[index]);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}