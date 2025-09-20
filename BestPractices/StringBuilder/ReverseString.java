package BestPractices.StringBuilder;
public class ReverseString {
    
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);
        
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversed);
    }
}