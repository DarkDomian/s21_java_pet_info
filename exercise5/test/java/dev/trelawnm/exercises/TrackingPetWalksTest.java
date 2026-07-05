package dev.trelawnm.exercises;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class TrackingPetWalksTest {
    @Test void appHasAGreeting() {
        TrackingPetWalks classUnderTest = new TrackingPetWalks();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
