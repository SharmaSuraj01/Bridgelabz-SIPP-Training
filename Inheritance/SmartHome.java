class Device {
    String deviceId;
    boolean status;
    
    Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    
    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + (status ? "ON" : "OFF"));
    }
}

class Thermostat extends Device {
    int temperatureSetting;
    
    Thermostat(String deviceId, boolean status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    
    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("001", true, 22);
        thermostat.displayStatus();
    }
}