package dev.trelawnm.exercises;

public class Cat extends Animal {

    public Cat(Builder builder) {
        super(builder);
    }

    @Override
    public double getFeedInfoKg() {
        return this.getWeight() * .1;
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d, feed = %.2f", getName(), getAge(), getFeedInfoKg());
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