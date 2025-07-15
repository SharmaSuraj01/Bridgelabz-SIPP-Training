package HashMaps;
import java.util.HashMap;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = targetSum - arr[i];
            if (map.containsKey(complement)) {
                System.out.println("Pair found: (" + arr[map.get(complement)] + ", " + arr[i] + ")");
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int targetSum = 16;
        
        if (!hasPairWithSum(arr, targetSum)) {
            System.out.println("No pair found with sum " + targetSum);
        }
    }
}