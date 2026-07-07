package dev.trelawnm.exercises;

public class Dog extends Animal implements Omnivore {

    public Dog(Builder builder) {
        super(builder);
    }

    public String hunt() {
        return "I can hunt for robbers";
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d. %s", getName(), getAge(), hunt());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Animal.Builder {

        @Override
        public Animal build() {
            return new Dog(this);
        }
    }
}