import java.util.*;

public class MaxValueKey {
    
    public static String findMaxValueKey(Map<String, Integer> map) {
        if (map.isEmpty()) return null;
        
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        
        String maxKey = findMaxValueKey(map);
        
        System.out.println("Map: " + map);
        System.out.println("Key with highest value: " + maxKey);
    }
}