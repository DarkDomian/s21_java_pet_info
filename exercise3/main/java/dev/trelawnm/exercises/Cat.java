package dev.trelawnm.exercises;

public class Cat extends Animal implements Omnivore {

    public Cat(Builder builder) {
        super(builder);
    }

    public String hunt() {
        return "I can hunt for mice";
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d. %s", getName(), getAge(), hunt());
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