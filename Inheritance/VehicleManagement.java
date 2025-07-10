class Vehicle {
    int maxSpeed;
    String model;
    
    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    
    void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    
    void charge() {
        System.out.println("Electric vehicle " + model + " is charging");
    }
    
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Electric Vehicle");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    
    @Override
    public void refuel() {
        System.out.println("Petrol vehicle " + model + " is refueling with petrol");
    }
    
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Petrol Vehicle");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3");
        PetrolVehicle pv = new PetrolVehicle(180, "Honda Civic");
        
        ev.displayInfo();
        ev.charge();
        System.out.println();
        
        pv.displayInfo();
        pv.refuel();
    }
}