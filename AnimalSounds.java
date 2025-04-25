/* 9 Animal Sounds (super Keyword) Create a base class Animal with a method makeSound(). Extend it with Cat and Dog classes. In overridden methods, first call super.makeSound() and then add animal-specific sound logic. */
// Main.java

// Step 1: Create the base class Animal
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound...");
    }
}

// Step 2: Create the Cat class that extends Animal
class Cat extends Animal {
    @Override
    public void makeSound() {
        // Call the parent class method first
        super.makeSound();

        // Add cat-specific behavior
        System.out.println("Cat says: Meow");
    }
}

// Step 3: Create the Dog class that extends Animal
class Dog extends Animal {
    @Override
    public void makeSound() {
        // Call the parent class method first
        super.makeSound();

        // Add dog-specific behavior
        System.out.println("Dog says: Woof");
    }
}

// Step 4: Test everything in the main class
public class AnimalSounds {
    public static void main(String[] args) {
        // Create a Cat object
        Cat cat = new Cat();
        System.out.println("Cat's Sound:");
        cat.makeSound();

        System.out.println(); // Line break

        // Create a Dog object
        Dog dog = new Dog();
        System.out.println("Dog's Sound:");
        dog.makeSound();
    }
}