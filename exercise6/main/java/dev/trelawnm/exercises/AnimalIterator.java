package dev.trelawnm.exercises;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {
    private int index;
    private List<Animal> animaList;

    public AnimalIterator(List<Animal> givenList) {
        this.animaList = givenList;
    }

    public Animal next() {
        return animaList.get(index++);
    }

    public boolean hasNext() {
        if (index < animaList.size())
            return true;
        else 
            return false;
    }

    public void reset() {
        index = 0;
    }
}