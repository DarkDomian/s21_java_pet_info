package dev.trelawnm.exercises;

public abstract class Animal {
    private final String name;
    private final int age;

    public Animal(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public abstract static class Builder {
        private String name;
        private int age;

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

        public abstract Animal build();
    }
}

interface Herbivore {
    public String chill();
}

interface Omnivore {
    public String hunt();
}