import java.util.*;

public class MultipleCatch {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            int[] array = {10, 20, 30, 40, 50};
            
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            
            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}