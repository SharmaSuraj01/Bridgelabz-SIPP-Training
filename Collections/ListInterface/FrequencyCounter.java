import java.util.*;

public class FrequencyCounter {
    
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        
        return frequencyMap;
    }
    
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequency = countFrequency(fruits);
        
        System.out.println("Input: " + fruits);
        System.out.println("Frequency: " + frequency);
    }
}