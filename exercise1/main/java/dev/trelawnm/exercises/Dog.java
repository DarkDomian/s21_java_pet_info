package dev.trelawnm.exercises;

public class Dog extends Animal {

    public Dog(String dogName, int dogAge) {
        super(dogName, dogAge);
    }

    @Override
    public String toString() {
        return "Dog name = " + this.getName() + ", age = " + this.getAge();
    }
}