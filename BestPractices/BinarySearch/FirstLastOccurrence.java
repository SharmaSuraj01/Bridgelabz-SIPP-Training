package BestPractices.BinarySearch;
import java.util.Arrays;

public class FirstLastOccurrence {
    public static int[] findFirstAndLastPosition(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findFirstOccurrence(nums, target);
        result[1] = findLastOccurrence(nums, target);
        return result;
    }
    private static int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    private static int findLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;
        int[] positions = findFirstAndLastPosition(nums, target);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("First and Last Positions: " + Arrays.toString(positions));
    }
}