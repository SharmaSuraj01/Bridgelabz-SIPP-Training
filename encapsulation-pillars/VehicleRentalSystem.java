import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
    
    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance - 10% of rental rate";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // 20% discount for bikes
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance - 5% of rental rate";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // 20% extra for trucks
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance - 15% of rental rate";
    }
}

public class VehicleRentalSystem {
    public static void calculateCosts(List<Vehicle> vehicles, int days) {
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(days);
            double insurance = (vehicle instanceof Insurable) ? ((Insurable) vehicle).calculateInsurance() : 0;
            System.out.println(vehicle.getType() + " " + vehicle.getVehicleNumber() + 
                             " - Rental: " + rentalCost + ", Insurance: " + insurance);
        }
    }
    
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
            new Car("CAR001", 1000),
            new Bike("BIKE001", 500),
            new Truck("TRUCK001", 2000)
        );
        
        calculateCosts(vehicles, 3);
    }
}