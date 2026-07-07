package dev.trelawnm.exercises;

public class Cat extends Animal {

    public Cat(String catName, int catAge) {
        super(catName, catAge);
    }

    @Override
    public String toString() {
        return "Cat name = " + this.getName() + ", age = " + this.getAge();
    }
}