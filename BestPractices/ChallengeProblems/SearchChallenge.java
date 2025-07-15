import java.util.Arrays;

public class SearchChallenge {
    
    // Linear Search to find first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Mark numbers that are out of range or negative as n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        
        // Mark presence of each number by making the value at index (num-1) negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        
        // Find the first positive value, its index + 1 is the missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // If all numbers from 1 to n are present, return n+1
        return n + 1;
    }
    
    // Binary Search to find target index
    public static int binarySearch(int[] nums, int target) {
        // Sort the array first
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Target not found
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 7, 2, -3, 9};
        int target = 7;
        
        System.out.println("Original array: " + Arrays.toString(nums));
        
        // Make a copy for binary search since findFirstMissingPositive modifies the array
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        
        int missingPositive = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missingPositive);
        
        int targetIndex = binarySearch(numsCopy, target);
        if (targetIndex != -1) {
            System.out.println("Target " + target + " found at index " + targetIndex + " in sorted array.");
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}