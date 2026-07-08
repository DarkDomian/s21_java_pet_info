package dev.trelawnm.exercises;

public class Dog extends Animal {

    public Dog(Builder builder) {
        super(builder);
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d", getName(), getAge());
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