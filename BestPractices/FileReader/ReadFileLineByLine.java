package BestPractices.FileReader;
import java.io.*;

public class ReadFileLineByLine {
    
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filePath = "sample.txt";
        System.out.println("Reading file: " + filePath);
        readFile(filePath);
    }
}