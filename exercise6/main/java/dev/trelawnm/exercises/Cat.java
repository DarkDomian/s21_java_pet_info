package dev.trelawnm.exercises;

public class Cat extends Animal {

    public Cat(Builder builder) {
        super(builder);
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d", getName(), getAge());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Animal.Builder {

        @Override
        public Animal build() {
            return new Cat(this);
        }
    }
}