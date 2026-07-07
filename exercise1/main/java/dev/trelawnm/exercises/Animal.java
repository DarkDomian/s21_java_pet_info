package dev.trelawnm.exercises;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String petName, int petAge) {
        
        if (petName == null || petName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else {
            this.name = petName;
        }

        if (petAge <= 0) {
            throw new IllegalArgumentException("Incorrect input. Age <= 0");
        } else {
            this.age = petAge;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}