package BestPractices.FileReader;
import java.io.*;

public class CountWordOccurrence {
    
    public static int countWordInFile(String filePath, String targetWord) {
        int count = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (word.equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String filePath = "sample.txt";
        String targetWord = "java";
        
        int occurrences = countWordInFile(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}