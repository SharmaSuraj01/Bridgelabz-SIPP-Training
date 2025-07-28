import java.util.*;

public class CompareSets {
    
    public static <T> boolean areEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
    
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 4));
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);
        
        System.out.println("Set1 equals Set2: " + areEqual(set1, set2));
        System.out.println("Set1 equals Set3: " + areEqual(set1, set3));
    }
}