import java.util.*;
import java.util.stream.*;

@FunctionalInterface
interface FareCalculator {
    double calculateFare(double baseFare, boolean peakTime);
}

interface EmergencyService {}

interface TransportService {
    String getName();
    double getBaseFare();
    List<String> getSchedules();
    default void printServiceDetails() {
        System.out.println("Service: " + getName() + " | Base Fare: " + getBaseFare());
    }
    static double calculateDistance(double a, double b) {
        return Math.abs(a - b);
    }
}

class BusService implements TransportService {
    private String name;
    private double baseFare;
    private List<String> schedules;
    BusService(String name, double baseFare, List<String> schedules) {
        this.name = name;
        this.baseFare = baseFare;
        this.schedules = schedules;
    }
    public String getName() { return name; }
    public double getBaseFare() { return baseFare; }
    public List<String> getSchedules() { return schedules; }
}

class TaxiService implements TransportService, EmergencyService {
    private String name;
    private double baseFare;
    private List<String> schedules;
    TaxiService(String name, double baseFare, List<String> schedules) {
        this.name = name;
        this.baseFare = baseFare;
        this.schedules = schedules;
    }
    public String getName() { return name; }
    public double getBaseFare() { return baseFare; }
    public List<String> getSchedules() { return schedules; }
}

public class SmartCity {
    public static void main(String[] args) {
        TransportService bus = new BusService("City Bus", 15.0, Arrays.asList("8:00", "10:00", "12:00"));
        TransportService taxi = new TaxiService("City Taxi", 50.0, Arrays.asList("Anytime"));
        List<TransportService> services = Arrays.asList(bus, taxi);

        System.out.println("=== Service Details ===");
        services.forEach(TransportService::printServiceDetails);

        FareCalculator fareCalculator = (base, peak) -> peak ? base * 1.2 : base;
        System.out.println("\nFare for Bus (Peak): " + fareCalculator.calculateFare(bus.getBaseFare(), true));
        System.out.println("Fare for Taxi (Non-Peak): " + fareCalculator.calculateFare(taxi.getBaseFare(), false));

        System.out.println("\n=== Services with fare < 40 ===");
        services.stream()
                .filter(s -> s.getBaseFare() < 40)
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("\n=== All Schedules ===");
        services.forEach(s -> s.getSchedules().forEach(time ->
                System.out.println(s.getName() + " -> " + time)));

        System.out.println("\n=== Grouping by Fare ===");
        Map<Boolean, List<TransportService>> grouped = services.stream()
                .collect(Collectors.partitioningBy(s -> s.getBaseFare() < 40));
        System.out.println(grouped);
    }
    
}
