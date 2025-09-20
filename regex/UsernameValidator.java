import java.util.regex.Pattern;

public class UsernameValidator {
    
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);
    
    public static boolean isValid(String username) {
        return pattern.matcher(username).matches();
    }
    
    public static void main(String[] args) {
        String[] testCases = {"user_123", "123user", "us", "validUser", "a_b_c_d_e"};
        
        for (String username : testCases) {
            System.out.println("\"" + username + "\" → " + (isValid(username) ? "Valid" : "Invalid"));
        }
    }
}