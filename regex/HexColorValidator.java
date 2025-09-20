import java.util.regex.Pattern;

public class HexColorValidator {
    
    private static final String HEX_COLOR_PATTERN = "^#[0-9A-Fa-f]{6}$";
    private static final Pattern pattern = Pattern.compile(HEX_COLOR_PATTERN);
    
    public static boolean isValid(String hexColor) {
        return pattern.matcher(hexColor).matches();
    }
    
    public static void main(String[] args) {
        String[] testCases = {"#FFA500", "#ff4500", "#123", "#GGGGGG", "#123456"};
        
        for (String color : testCases) {
            System.out.println("\"" + color + "\" → " + (isValid(color) ? "Valid" : "Invalid"));
        }
    }
}