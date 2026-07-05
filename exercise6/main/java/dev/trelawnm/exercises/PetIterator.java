package dev.trelawnm.exercises;

public class PetIterator {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new PetIterator().getGreeting());
    }
}
