import java.util.*;

public class RemoveDuplicates {
    
    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> result = new ArrayList<>();
        Set<T> seen = new HashSet<>();
        
        for (T element : list) {
            if (!seen.contains(element)) {
                result.add(element);
                seen.add(element);
            }
        }   
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> unique = removeDuplicates(numbers);
        
        System.out.println("Original: " + numbers);
        System.out.println("Without duplicates: " + unique);
    }
}