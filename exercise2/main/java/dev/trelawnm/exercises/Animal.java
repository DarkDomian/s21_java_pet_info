package dev.trelawnm.exercises;

public abstract class Animal {
    private final String name;
    private final int age;
    private final double weight;

    public Animal(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.weight = builder.weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    public abstract double getFeedInfoKg();

    public abstract static class Builder {
        private String name;
        private int age;
        private double weight;

        public Builder setName(String petName) {
            if (petName == null || petName.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            this.name = petName;
            return this;
        }

        public Builder setAge(int petAge) {
            if (petAge <= 0) {
                throw new IllegalArgumentException("Incorrect input. Age <= 0");
            }
            this.age = petAge;
            return this;
        }

        public Builder setWeight(double petWeight) {
            if (petWeight <= 0) {
                throw new IllegalArgumentException("Incorrect input. Mass <= 0");
            }
            this.weight = petWeight;
            return this;
        }

        public abstract Animal build();
    }
}