import java.io.*;

public class LargeFileReader {
    
    public static void readLargeFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
            String line;
            int lineCount = 0;
            int errorCount = 0;
            
            System.out.println("Reading large file and searching for 'error'...");
            
            while ((line = reader.readLine()) != null) {
                lineCount++;
                
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineCount + ": " + line);
                    errorCount++;
                }
                
                // Progress indicator for large files
                if (lineCount % 100000 == 0) {
                    System.out.println("Processed " + lineCount + " lines...");
                }
            }
            
            System.out.println("\nSummary:");
            System.out.println("Total lines processed: " + lineCount);
            System.out.println("Lines containing 'error': " + errorCount);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filename = "largefile.txt";
        readLargeFile(filename);
    }
}