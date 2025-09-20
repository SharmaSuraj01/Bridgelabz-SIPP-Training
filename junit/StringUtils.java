public class StringUtils {
    
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }
    
    public boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        return cleaned.equals(reverse(cleaned));
    }
    
    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}