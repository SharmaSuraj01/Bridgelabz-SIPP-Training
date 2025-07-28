import java.util.*;

public class InvertMap {
    
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        
        return invertedMap;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);
        
        Map<Integer, List<String>> inverted = invertMap(original);
        
        System.out.println("Original: " + original);
        System.out.println("Inverted: " + inverted);
    }
}