import java.util.function.Consumer;

public class SmartHomeLighting {
    
    @FunctionalInterface
    interface LightPattern {
        void activate(String room);
    }
    
    public static void main(String[] args) {
        LightPattern motionPattern = room -> System.out.println("Motion detected in " + room + " - Turning on bright lights");
        
        LightPattern nightPattern = room -> System.out.println("Night mode in " + room + " - Turning on dim lights");
        
        LightPattern voicePattern = room -> System.out.println("Voice command in " + room + " - Activating colorful mood lighting");
        
        LightPattern emergencyPattern = room -> {
            System.out.println("Emergency in " + room + " - Activating flashing red lights");
            System.out.println("Alert sent to security");
        };
        
        System.out.println("=== Smart Home Lighting Automation ===");
        motionPattern.activate("Living Room");
        nightPattern.activate("Bedroom");
        voicePattern.activate("Kitchen");
        emergencyPattern.activate("Garage");
    }
}