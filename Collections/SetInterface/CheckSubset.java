import java.util.*;

public class CheckSubset {
    
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }
    
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(2, 5));
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);
        
        System.out.println("Set1 is subset of Set2: " + isSubset(set1, set2));
        System.out.println("Set3 is subset of Set2: " + isSubset(set3, set2));
    }
}