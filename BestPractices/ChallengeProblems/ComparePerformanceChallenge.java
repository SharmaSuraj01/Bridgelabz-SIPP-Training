import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComparePerformanceChallenge {
    
    public static void main(String[] args) {
        // StringBuilder vs StringBuffer performance
        compareStringBuilders();
        
        // FileReader vs InputStreamReader performance
        compareReaders("sample.txt");
    }
    
    private static void compareStringBuilders() {
        int iterations = 100000; // Reduced for demonstration
        String text = "hello";
        
        System.out.println("Comparing StringBuilder vs StringBuffer:");
        
        // StringBuilder performance test
        long startTimeBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = (endTimeBuilder - startTimeBuilder) / 1000000; // Convert to milliseconds
        
        // StringBuffer performance test
        long startTimeBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = (endTimeBuffer - startTimeBuffer) / 1000000; // Convert to milliseconds
        
        System.out.println("StringBuilder time: " + durationBuilder + " ms");
        System.out.println("StringBuffer time: " + durationBuffer + " ms");
        System.out.println("StringBuffer is " + (durationBuffer > durationBuilder ? 
                          "slower by " + (durationBuffer - durationBuilder) : 
                          "faster by " + (durationBuilder - durationBuffer)) + " ms");
    }
    
    private static void compareReaders(String filePath) {
        System.out.println("\nComparing FileReader vs InputStreamReader:");
        
        // Count words using FileReader
        long startTimeFileReader = System.nanoTime();
        int fileReaderCount = countWordsWithFileReader(filePath);
        long endTimeFileReader = System.nanoTime();
        long durationFileReader = (endTimeFileReader - startTimeFileReader) / 1000000; // Convert to milliseconds
        
        // Count words using InputStreamReader
        long startTimeInputStreamReader = System.nanoTime();
        int inputStreamReaderCount = countWordsWithInputStreamReader(filePath);
        long endTimeInputStreamReader = System.nanoTime();
        long durationInputStreamReader = (endTimeInputStreamReader - startTimeInputStreamReader) / 1000000; // Convert to milliseconds
        
        System.out.println("FileReader time: " + durationFileReader + " ms, Word count: " + fileReaderCount);
        System.out.println("InputStreamReader time: " + durationInputStreamReader + " ms, Word count: " + inputStreamReaderCount);
    }
    
    private static int countWordsWithFileReader(String filePath) {
        int wordCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }
        
        return wordCount;
    }
    
    private static int countWordsWithInputStreamReader(String filePath) {
        int wordCount = 0;
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        
        return wordCount;
    }
}