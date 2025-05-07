/** Create a Runnable lambda that prints “Hello Functional Java”*/

package Functional_Programming_Assignment.level1;

public class RunnableExample {
    public static void main(String[] args) {
        // Runnable prints "Hello Functional Java"
        Runnable greet = () -> System.out.println("Hello Functional Java");

        greet.run();  // Output: Hello Functional Java
    }
}
