// Question: Use Optional to safely get a value or return a default.
/*Optional.ofNullable(name) means:

If name is not null → it creates an Optional with the value.

If name is null → it creates an empty Optional (no value inside, but still safe to use).*/
package Functional_Programming_Assignment.level1.level3;

import java.util.Optional;

public class OptionalSimple {

    public static void main(String[] args) {
        // Simulate a value that could be null (change to "Alice" to test)
        String name = null;

        // Wrap the value in Optional
        Optional<String> optionalName = Optional.ofNullable(name);

        // Get the name or return a default value if it's null
        String result = optionalName.orElse("Default Name");

        // Print the result
        System.out.println("Name is: " + result);
    }
}
