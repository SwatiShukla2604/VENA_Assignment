/* 4 Drawing App (Polymorphism) Create a Shape class with a method draw(). Extend it with Circle, Square, and Triangle classes. Override draw() in each class. In the main method, store shapes in an array and call draw() in a loop. */
// Base class or Parent class
class Shape {
    // This is the method we will override in each shape
    public void draw() {
        System.out.println("Drawing a shape...");
    }
}

// Child class 1 - Circle
class Circle extends Shape {
    // Overrides draw() method of Shape class
    @Override
    public void draw() {
        System.out.println(" Drawing a Circle");
    }
}

// Child class 2 - Square
class Square extends Shape {
    // Overrides draw() method of Shape class
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Child class 3 - Triangle
class Triangle extends Shape {
    // Overrides draw() method of Shape class
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// Main class to run everything
public class DrawingApp {
    public static void main(String[] args) {
        
        // Creating an array of Shape type that can hold different shapes
        Shape[] shapes = new Shape[3];  // Array of size 3

        // Storing different shape objects in the same array
        shapes[0] = new Circle();     // First element is a Circle
        shapes[1] = new Square();     // Second is a Square
        shapes[2] = new Triangle();   // Third is a Triangle

        // Looping through the array and calling draw() method
        System.out.println("Drawing All Shapes:");
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();  // This will call the correct draw() method due to polymorphism
        }
    }
}
