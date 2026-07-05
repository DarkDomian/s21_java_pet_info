package dev.trelawnm.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HerbivorousAndOmnivorousTest {
    @Test void appHasAGreeting() {
        HerbivorousAndOmnivorous classUnderTest = new HerbivorousAndOmnivorous();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
