import java.util.*;
public class DSsearch {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        int target = -1;
        for (int n : sizes) {
            int[] arr = new int[n];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }
            long start, end;
            start = System.nanoTime();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == target) { found = true; break; }
            }
            if (found) System.out.print("");
            end = System.nanoTime();
            System.out.printf("Array Search (N=%d): %.4f ms\n", n, (end - start) / 1e6);
            start = System.nanoTime();
            boolean hashFound = hashSet.contains(target);
            end = System.nanoTime();
            if (hashFound) System.out.print("");
            System.out.printf("HashSet Search (N=%d): %.4f ms\n", n, (end - start) / 1e6);
            start = System.nanoTime();
            boolean treeFound = treeSet.contains(target);
            end = System.nanoTime();
            if (treeFound) System.out.print("");
            System.out.printf("TreeSet Search (N=%d): %.4f ms\n", n, (end - start) / 1e6);
        }
    }    
}
