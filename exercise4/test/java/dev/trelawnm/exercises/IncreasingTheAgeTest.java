package dev.trelawnm.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncreasingTheAgeTest {
    @Test void appHasAGreeting() {
        IncreasingTheAge classUnderTest = new IncreasingTheAge();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
