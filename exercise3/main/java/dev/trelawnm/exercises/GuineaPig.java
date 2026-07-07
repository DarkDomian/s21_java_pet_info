package dev.trelawnm.exercises;

public class GuineaPig extends Animal implements Herbivore {

    public GuineaPig(Builder builder) {
        super(builder);
    }

    public String chill() {
        return "I can chill for 12 hours";
    }

    @Override
    public String toString() {
        return String.format("GuineaPig name = %s, age = %d. %s", getName(), getAge(), chill());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Animal.Builder {

        @Override
        public Animal build() {
            return new GuineaPig(this);
        }
    }
}