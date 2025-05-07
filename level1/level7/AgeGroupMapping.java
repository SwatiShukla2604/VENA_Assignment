// Question: Create a function that takes a list of people and returns a map of
// age group (<20, 20–40, 40+) → list of people.

package Functional_Programming_Assignment.level1.level7;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // For easy printing
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class AgeGroupMapping {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 15),
                new Person("Alice", 25),
                new Person("Bob", 35),
                new Person("David", 45),
                new Person("Eve", 60),
                new Person("Tom", 19)
        );

        // Group by custom age range
        Map<String, List<Person>> ageGroupMap = people.stream()
                .collect(Collectors.groupingBy(person -> {
                    int age = person.getAge();
                    if (age < 20) return "<20";
                    else if (age <= 40) return "20-40";
                    else return "40+";
                }));

        // Print result
        ageGroupMap.forEach((ageGroup, groupPeople) -> {
            System.out.println("Age Group " + ageGroup + ": " + groupPeople);
        });
    }
}
