package HashMaps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        List<Integer> initialList = new ArrayList<>();
        initialList.add(-1);
        map.put(0, initialList);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int startIndex : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIndex + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }
            
            List<Integer> sumIndices = map.getOrDefault(sum, new ArrayList<>());
            sumIndices.add(i);
            map.put(sum, sumIndices);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<List<Integer>> zeroSumSubarrays = findZeroSumSubarrays(arr);
        System.out.println("Zero Sum Subarrays:");
        for (List<Integer> subarray : zeroSumSubarrays) {
            System.out.println(subarray);
        }
    }
}