/* 2 Vehicle Hierarchy (Inheritance) Design a class Vehicle with fields speed and fuelCapacity. Extend it with Car and Truck classes. Add specific methods like getMileage() in each subclass that calculate mileage based on different formulas.*/

// Base class: Vehicle
class Vehicle {
    double speed;          // in km/h
    double fuelCapacity;   // in liters

    // Constructor to initialize common vehicle data
    Vehicle(double speed, double fuelCapacity) {
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    // Method to display basic vehicle details
    void displayInfo() {
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Car class inherits from Vehicle
class Car extends Vehicle {

    // Constructor calls Vehicle constructor using super()
    Car(double speed, double fuelCapacity) {
        super(speed, fuelCapacity);
    }

    // Mileage for Car: let's say it is (speed * 0.5)
    double getMileage() {
        return speed * 0.5;  // Example formula for car mileage
    }
}

// Truck class inherits from Vehicle
class Truck extends Vehicle {

    // Constructor calls Vehicle constructor using super()
    Truck(double speed, double fuelCapacity) {
        super(speed, fuelCapacity);
    }

    // Mileage for Truck: let's say it is (speed * 0.3)
    double getMileage() {
        return speed * 0.3;  // Example formula for truck mileage
    }
}

// Main class to test everything
public class VehicleHierarchy {
    public static void main(String[] args) {
        // Creating a Car object
        Car myCar = new Car(120, 40);  // 120 km/h speed, 40 liters fuel
        System.out.println("CAR DETAILS:");
        myCar.displayInfo();  // Show basic vehicle info
        System.out.println("Car Mileage: " + myCar.getMileage() + " km/ltr");
        System.out.println();

        // Creating a Truck object
        Truck myTruck = new Truck(80, 100);  // 80 km/h speed, 100 liters fuel
        System.out.println("TRUCK DETAILS:");
        myTruck.displayInfo();  // Show basic vehicle info
        System.out.println("Truck Mileage: " + myTruck.getMileage() + " km/ltr");
    }
}
