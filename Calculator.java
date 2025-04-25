/* 7 Calculator Lockdown (final Keyword) Create a BasicCalculator class with a final method add(int a, int b). Extend it with a SmartCalculator class and attempt to override add() (it should give an error). Add a new method subtract() in the subclass. */
// Main.java

// Step 1: Define the BasicCalculator class
class BasicCalculator {

    // final method - this cannot be overridden by any subclass
    public final int add(int a, int b) {
        return a + b;
    }
}

// Step 2: Define the SmartCalculator class that extends BasicCalculator
class SmartCalculator extends BasicCalculator {

    /*
    // This would cause a compilation error if you uncomment it,
    // because add() is declared final in the parent class.

    @Override
    public int add(int a, int b) {
        return a + b + 100; // Just an example of override attempt
    }
    */

    // You can still define new methods in the subclass
    public int subtract(int a, int b) {
        return a - b;
    }
}

// Step 3: Main class to test the functionality
public class Calculator {
    public static void main(String[] args) {

        // Creating an object of SmartCalculator
        SmartCalculator calc = new SmartCalculator();

        // Using the final add() method from the BasicCalculator class
        int result1 = calc.add(10, 20);
        System.out.println("Sum: " + result1);

        // Using the subtract() method from the SmartCalculator class
        int result2 = calc.subtract(20, 10);
        System.out.println("Difference: " + result2);
    }
}
