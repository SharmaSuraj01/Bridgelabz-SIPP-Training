import java.io.*;

public class TryWithResources {
    
    public static void readFirstLine(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
    
    public static void main(String[] args) {
        readFirstLine("info.txt");
    }
}