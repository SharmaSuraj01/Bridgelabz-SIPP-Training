import java.util.*;

public class NthFromEnd {
    
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || list.isEmpty()) return null;
        
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        
        for (int i = 0; i < n && first.hasNext(); i++) {
            first.next();
        }
        
        if (!first.hasNext() && n > list.size()) return null;
        
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        
        return second.next();
    }
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        
        String result = findNthFromEnd(list, n);
        System.out.println("List: " + list);
        System.out.println(n + "nd element from end: " + result);
    }
}