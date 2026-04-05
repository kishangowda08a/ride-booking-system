 Ride Booking System (OOP Project)

Overview

This project is a backend simulation of a ride booking system where riders can request rides and drivers can accept them.

The system demonstrates core Object-Oriented Programming (OOP) principles such as inheritance, encapsulation, abstraction, and polymorphism.

---

Features

* Create Riders and Drivers
* Request and assign rides
* Track ride status (Requested → Ongoing → Completed)
* Multiple payment methods (Cash, Card, Wallet)
* Driver availability management

---

OOP Concepts Used

1. Inheritance

* Rider and Driver inherit from User

2. Encapsulation

* Sensitive data like ride status and driver availability are private

 3. Abstraction

* Payment interface defines common behavior

 4. Polymorphism

* Different payment types implement the same method differently

---

 Project Structure

* User → Base class
* Rider, Driver → Derived classes
* Ride → Core ride logic
* RideManager → Handles ride assignment
* Payment → Interface for payments
* Main → Entry point

---

How to Run

1. Compile:
   javac Main.java

2. Run:
   java Main

---

 Future Improvements

* Dynamic fare calculation
* Multiple ride types (Bike, Cab, Pool)
* Better driver matching algorithm
* Use of Enum for ride status

---

 Conclusion

This project focuses on clean design and demonstrates how OOP concepts can be applied to real-world systems like ride booking.

PFB the implemented code


-> For Wallet Payment:
Srushti requested a ride.
Alice accepted the ride.
Ride started...
Ride completed! Fare: 200.0
Paid 200.0 using wallet.

-> For Cash Payment:
Rohan requested a ride.
Alice accepted the ride.
Ride started...
Ride completed! Fare: 200.0
Paid 200.0 in cash.

-> For Card Payment:
Kishan requested a ride.
Alice accepted the ride.
Ride started...
Ride completed! Fare: 200.0
Paid 200.0 using card.



Code explained in Detail

Code Division (in Brief)
Base Class → User
Common properties: id, name
Parent for Rider & Driver
Used for: Code reuse

Child Classes → Rider, Driver
Rider → requests ride
Driver → accepts ride, tracks availability
 Used for: Specialized behavior

 Data Class → Location
Stores coordinates (latitude, longitude)
Used for: Clean data representation

Payment System
Payment (interface)
CashPayment, CardPayment, WalletPayment
 Used for: Flexible payment handling

 Core Logic → Ride
Manages:
Rider
Driver
Status
Fare
Used for: Ride lifecycle management

 Controller → RideManager
Stores drivers
Assigns available driver
 Used for: Business logic separation

Entry Point → Main
Creates objects
Runs the flow
 Used for: Execution
