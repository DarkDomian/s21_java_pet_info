package dev.trelawnm.exercises;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class AmountOfPetFoodTest {
    @Test void appHasAGreeting() {
        AmountOfPetFood classUnderTest = new AmountOfPetFood();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
