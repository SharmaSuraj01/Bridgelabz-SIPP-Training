import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> votes;
    private LinkedHashMap<String, Integer> voteOrder;
    
    public VotingSystem() {
        votes = new HashMap<>();
        voteOrder = new LinkedHashMap<>();
    }
    
    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }
    
    public void displayResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votes);
        System.out.println("Results (Alphabetical): " + sortedResults);
    }
    
    public void displayVoteOrder() {
        System.out.println("Vote Order: " + voteOrder);
    }
    
    public String getWinner() {
        return votes.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No votes");
    }
    
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        
        system.displayVoteOrder();
        system.displayResults();
        System.out.println("Winner: " + system.getWinner());
    }
}