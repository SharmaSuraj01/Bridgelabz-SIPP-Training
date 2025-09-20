import java.util.regex.Pattern;

public class LicensePlateValidator {
    
    private static final String LICENSE_PATTERN = "^[A-Z]{2}\\d{4}$";
    private static final Pattern pattern = Pattern.compile(LICENSE_PATTERN);
    
    public static boolean isValid(String licensePlate) {
        return pattern.matcher(licensePlate).matches();
    }
    
    public static void main(String[] args) {
        String[] testCases = {"AB1234", "A12345", "ab1234", "ABC123", "AB12345"};
        
        for (String plate : testCases) {
            System.out.println("\"" + plate + "\" → " + (isValid(plate) ? "Valid" : "Invalid"));
        }
    }
}