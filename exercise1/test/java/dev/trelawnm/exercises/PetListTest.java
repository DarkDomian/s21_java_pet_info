package dev.trelawnm.exercises;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class PetListTest {
    @Test void appHasAGreeting() {
        PetList classUnderTest = new PetList();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
