import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    
    public static void countWords(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase()
                                    .replaceAll("[^a-zA-Z\\s]", "")
                                    .split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            // Display total word count
            int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total words in file: " + totalWords);
            System.out.println("Unique words: " + wordCount.size());
            
            // Get top 5 most frequent words
            List<Map.Entry<String, Integer>> top5 = wordCount.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(5)
                    .collect(Collectors.toList());
            
            System.out.println("\nTop 5 most frequent words:");
            for (int i = 0; i < top5.size(); i++) {
                Map.Entry<String, Integer> entry = top5.get(i);
                System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " times");
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filename = "textfile.txt";
        countWords(filename);
    }
}