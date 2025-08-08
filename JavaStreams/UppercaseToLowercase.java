import java.io.*;

public class UppercaseToLowercase {
    
    public static void convertCase(String sourcePath, String destPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destPath))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            
            System.out.println("File converted from uppercase to lowercase: " + destPath);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String sourceFile = "uppercase.txt";
        String destFile = "lowercase.txt";
        
        convertCase(sourceFile, destFile);
    }
}