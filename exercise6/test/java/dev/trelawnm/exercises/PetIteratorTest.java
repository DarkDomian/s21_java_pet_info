package dev.trelawnm.exercises;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class PetIteratorTest {
    @Test void appHasAGreeting() {
        PetIterator classUnderTest = new PetIterator();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
