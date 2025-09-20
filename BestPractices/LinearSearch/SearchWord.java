package BestPractices.LinearSearch;
public class SearchWord {
    
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
    
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog",
            "A journey of a thousand miles begins with a single step",
            "All that glitters is not gold",
            "Java is a popular programming language"
        };
        String word = "programming";
        String result = findSentenceWithWord(sentences, word);
        
        System.out.println("Searching for: \"" + word + "\"");
        System.out.println("Result: " + result);
    }
}