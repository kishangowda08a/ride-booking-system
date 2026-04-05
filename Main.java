import java.util.*;
// User.java
abstract class User {
    protected int id;
    protected String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Rider.java
class Rider extends User {
    public Rider(int id, String name) {
        super(id, name);
    }

    public Ride requestRide(Location from, Location to, RideManager manager) {
        System.out.println(name + " requested a ride.");
        return manager.requestRide(this, from, to);
    }
}

// Driver.java
class Driver extends User {
    private boolean available;

    public Driver(int id, String name) {
        super(id, name);
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void acceptRide(Ride ride) {
        System.out.println(name + " accepted the ride.");
        ride.setDriver(this);
        ride.setStatus("Accepted");
        setAvailable(false);
    }
}

// Location.java
class Location {
    double latitude;
    double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

// Payment.java
interface Payment {
    void processPayment(double amount);
}

// CashPayment.java
class CashPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }
}

// CardPayment.java
class CardPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using card.");
    }
}

// WalletPayment.java
class WalletPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using wallet.");
    }
}

// Ride.java
class Ride {
    private int id;
    private Rider rider;
    private Driver driver;
    private Location fromLocation;
    private Location toLocation;
    private String status;
    private double fare;

    public Ride(int id, Rider rider, Location from, Location to) {
        this.id = id;
        this.rider = rider;
        this.fromLocation = from;
        this.toLocation = to;
        this.status = "Requested";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void startRide() {
        status = "Ongoing";
        System.out.println("Ride started...");
    }

    public void completeRide(Payment payment) {
        status = "Completed";
        fare = 200.0; // fixed fare for simplicity
        System.out.println("Ride completed! Fare: " + fare);
        payment.processPayment(fare);
        driver.setAvailable(true);
    }

    public String getStatus() {
        return status;
    }
}

// RideManager.java

class RideManager {
    private List<Driver> drivers = new ArrayList<>();
    private int rideCounter = 1;

    public void addDriver(Driver d) {
        drivers.add(d);
    }

    public Ride requestRide(Rider rider, Location from, Location to) {
        Ride ride = new Ride(rideCounter++, rider, from, to);
        assignDriver(ride);
        return ride;
    }

    private void assignDriver(Ride ride) {
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                d.acceptRide(ride);
                return;
            }
        }
        System.out.println("No available driver found!");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        RideManager manager = new RideManager();

        // Create drivers
        Driver d1 = new Driver(1, "Alice");
        Driver d2 = new Driver(2, "Bob");
        manager.addDriver(d1);
        manager.addDriver(d2);

        // Create rider
        Rider r1 = new Rider(100, "Srushti");

        // Request ride
        Location from = new Location(10.1, 20.1);
        Location to = new Location(15.2, 25.3);
        Ride ride = r1.requestRide(from, to, manager);

        // Simulate ride
        ride.startRide();
        Payment payment = new WalletPayment(); // try CashPayment or WalletPayment
        ride.completeRide(payment);
    }
}
