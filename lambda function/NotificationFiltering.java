import java.util.*;
import java.util.function.Predicate;

class Alert {
    private String type;
    private String message;
    private String priority;
    
    public Alert(String type, String message, String priority) {
        this.type = type;
        this.message = message;
        this.priority = priority;
    }
    
    public String getType() { return type; }
    public String getMessage() { return message; }
    public String getPriority() { return priority; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s", priority, type, message);
    }
}

public class NotificationFiltering {
    
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("MEDICATION", "Time for blood pressure medication", "HIGH"),
            new Alert("APPOINTMENT", "Doctor appointment tomorrow", "MEDIUM"),
            new Alert("VITALS", "Heart rate slightly elevated", "LOW"),
            new Alert("EMERGENCY", "Patient fall detected", "CRITICAL"),
            new Alert("MEDICATION", "Insulin injection due", "HIGH"),
            new Alert("SYSTEM", "Device battery low", "LOW")
        );
        
        System.out.println("=== Hospital Notification Filtering ===");
        System.out.println("All alerts:");
        alerts.forEach(System.out::println);
        
        // Filter high priority alerts only
        Predicate<Alert> highPriorityFilter = alert -> 
            alert.getPriority().equals("HIGH") || alert.getPriority().equals("CRITICAL");
        
        System.out.println("\nHigh Priority Alerts:");
        alerts.stream()
               .filter(highPriorityFilter)
               .forEach(System.out::println);
        
        // Filter medication alerts only
        Predicate<Alert> medicationFilter = alert -> alert.getType().equals("MEDICATION");
        
        System.out.println("\nMedication Alerts:");
        alerts.stream()
               .filter(medicationFilter)
               .forEach(System.out::println);
        
        // Filter critical emergency alerts
        Predicate<Alert> emergencyFilter = alert -> 
            alert.getType().equals("EMERGENCY") && alert.getPriority().equals("CRITICAL");
        
        System.out.println("\nCritical Emergency Alerts:");
        alerts.stream()
               .filter(emergencyFilter)
               .forEach(System.out::println);
    }
}