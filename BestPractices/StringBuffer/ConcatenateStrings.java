package BestPractices.StringBuffer;
public class ConcatenateStrings {
    
    public static String concatenate(String[] strings) {
        StringBuffer sb = new StringBuffer();
        
        for (String str : strings) {
            sb.append(str);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!", " ", "Welcome", " ", "to", " ", "Java"};
        
        String result = concatenate(strings);
        System.out.println("Concatenated string: " + result);
    }
}