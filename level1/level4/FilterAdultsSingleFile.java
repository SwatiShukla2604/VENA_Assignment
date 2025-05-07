/**Given a list of people (name, age), filter adults (age > 18) and collect names.*/

package Functional_Programming_Assignment.level1.level4;

import java.util.*;
import java.util.stream.Collectors;

// ✅ Question: Given a list of people (name, age), filter adults (age > 18) and collect their names.

public class FilterAdultsSingleFile {

    // 👤 Inner static class to represent a Person with name and age
    static class Person {
        private String name;
        private int age;

        // Constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        // 🧍‍♂️ Create a sample list of people
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 16),
                new Person("Charlie", 30),
                new Person("Daisy", 17),
                new Person("Eve", 22)
        );

        // ✅ Filter adults (age > 18) and collect their names
        List<String> adultNames = people.stream()
                .filter(person -> person.getAge() > 18)     // Only adults
                .map(Person::getName)                       // Get their names
                .collect(Collectors.toList());              // Collect to List

        // 🖨️ Print the result
        System.out.println("Adult Names: " + adultNames);
    }
}
