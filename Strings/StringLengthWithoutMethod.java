import java.util.Scanner;

public class StringLengthWithoutMethod {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        int customLength = findLength(input);
        int builtInLength = input.length();

        System.out.println("\nLength using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);
        sc.close();
    }
}
