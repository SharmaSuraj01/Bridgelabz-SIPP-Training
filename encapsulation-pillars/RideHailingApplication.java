import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }
    
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }
    protected String getCurrentLocationInternal() { return currentLocation; }
    
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public void setRatePerKm(double ratePerKm) { this.ratePerKm = ratePerKm; }
    protected void setCurrentLocation(String location) { this.currentLocation = location; }
    
    public String getVehicleDetails() {
        return "ID: " + vehicleId + ", Driver: " + driverName + ", Rate: " + ratePerKm + "/km";
    }
    
    public abstract double calculateFare(double distance);
}

class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }
    
    public String getCurrentLocation() {
        return getCurrentLocationInternal();
    }
    
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Car location updated to: " + newLocation);
    }
}

class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    
    public String getCurrentLocation() {
        return getCurrentLocationInternal();
    }
    
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Bike location updated to: " + newLocation);
    }
}

class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }
    
    public String getCurrentLocation() {
        return getCurrentLocationInternal();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Auto location updated to: " + newLocation);
    }
}

public class RideHailingApplication {
    public static void calculateFares(List<Vehicle> vehicles, double distance) {
        for (Vehicle vehicle : vehicles) {
            double fare = vehicle.calculateFare(distance);
            System.out.println(vehicle.getVehicleDetails() + ", Fare for " + distance + "km: " + fare);
            
            if (vehicle instanceof GPS) {
                GPS gps = (GPS) vehicle;
                gps.updateLocation("Downtown");
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }
        }
    }
    
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
            new Car("CAR001", "Suraj", 15),
            new Bike("BIKE001", "sameer", 8),
            new Auto("AUTO001", "uttam", 12)
        );
        
        calculateFares(vehicles, 10.5);
    }
}