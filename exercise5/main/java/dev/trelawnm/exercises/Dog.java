package dev.trelawnm.exercises;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {

    public Dog(Builder builder) {
        super(builder);
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d", getName(), getAge());
    }

    @Override
    public double goToWalk() throws InterruptedException {
        double walkTime = getAge() * .5;
        TimeUnit.SECONDS.sleep((long) walkTime);

        return walkTime;
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