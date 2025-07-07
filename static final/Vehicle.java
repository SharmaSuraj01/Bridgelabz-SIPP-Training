public class Vehicle {
    static double registrationFee = 5000.0;
        String ownerName;
    String vehicleType;
    final String registrationNumber;
        Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
        static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
        void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }
        public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("meera", "Car", "MH12AB1234");
                Vehicle.updateRegistrationFee(6000.0);
                Object obj = vehicle1;
        if (obj instanceof Vehicle) {
            ((Vehicle) obj).displayDetails();
        }
    }
}