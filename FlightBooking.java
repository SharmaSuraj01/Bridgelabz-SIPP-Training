import java.util.*;

class User {
    int id;
    String name;
    String email;
    String src;
    String dest;
    User(int id, String name, String email, String src, String dest) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.src = src;
        this.dest = dest;
    }
}

public class FlightBooking {
    static class AeroPlane {
        String flightNumber;
        String departure;
        String arrival;
        int availableSeats;
        AeroPlane(String flightNumber, String departure, String arrival, int availableSeats) {
            this.flightNumber = flightNumber;
            this.departure = departure;
            this.arrival = arrival;
            this.availableSeats = availableSeats;
        }
    };

    static class Booking {
        User user;
        AeroPlane flight;

        Booking(User user, AeroPlane flight) {
            this.user = user;
            this.flight = flight;
        }
    };

    public static void viewDetails(User user, List<Booking> booking) {
        for (Booking booked : booking) {
            if (booked.user.id == user.id) {
                System.out.println("Booking Details: ");
                System.out.println("Name: " + booked.user.name);
                System.out.println("Email: " + booked.user.email);
                System.out.println("Flight Number: " + booked.flight.flightNumber);
                System.out.println("Departure: " + booked.flight.departure);
                System.out.println("Arrival: " + booked.flight.arrival);
                System.out.println("Available Seats: " + booked.flight.availableSeats);
            }
        }
    }

    public static void main(String args[]){
        AeroPlane[] flight = new AeroPlane[3];
        flight[0] = new AeroPlane("123", "Delhi", "Chennai", 10);
        flight[1] = new AeroPlane("456", "Delhi", "Mumbai", 20);
        flight[2] = new AeroPlane("789", "Mumbai", "Chennai", 30);
        
        List<User> users  = new ArrayList<>();
        users.add(new User(1, "Suraj ", "suraj@gmail.com", "Delhi", "Chennai"));
        users.add(new User(2, "Archana", "archana@gmail.com", "Delhi", "Mumbai"));
        users.add(new User(3, null, null, null, null));
        
        
        List<Booking> bookingDetails = new ArrayList<>();
        for(User u : users){{
            for(AeroPlane A : flight){
               if(A.departure.equals(u.src) && A.arrival.equals(u.dest) && A.availableSeats > 0){
                   bookingDetails.add(new Booking(u, A));
                   A.availableSeats--;
                }
            } 
        }
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the Id of the user: ");
            int id = sc.nextInt();
            for(User us : users){
                if(us.id == id){
                    viewDetails(us, bookingDetails);
                }
            }
        }
    }
}
}