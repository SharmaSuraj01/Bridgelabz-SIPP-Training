import java.util.*;

public class RotateList {
    
    public static <T> void rotateLeft(List<T> list, int positions) {
        if (list.isEmpty() || positions <= 0) return;
        
        int size = list.size();
        positions = positions % size;
        
        List<T> temp = new ArrayList<>(list.subList(0, positions));
        
        for (int i = 0; i < size - positions; i++) {
            list.set(i, list.get(i + positions));
        }
        
        for (int i = 0; i < temp.size(); i++) {
            list.set(size - positions + i, temp.get(i));
        }
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original: " + numbers);
        
        rotateLeft(numbers, 2);
        System.out.println("Rotated by 2: " + numbers);
    }
}