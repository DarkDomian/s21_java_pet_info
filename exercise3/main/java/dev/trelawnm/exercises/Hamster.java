package dev.trelawnm.exercises;

public class Hamster extends Animal implements Herbivore {

    public Hamster(Builder builder) {
        super(builder);
    }

    public String chill() {
        return "I can chill for 8 hours";
    }

    @Override
    public String toString() {
        return String.format("Hamster name = %s, age = %d. %s", getName(), getAge(), chill());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Animal.Builder {

        @Override
        public Animal build() {
            return new Hamster(this);
        }
    }
}