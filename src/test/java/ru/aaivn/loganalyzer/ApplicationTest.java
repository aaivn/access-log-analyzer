package ru.aaivn.loganalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ApplicationTest {
    @Test
    void runAppWithoutData() {
        String[] args = new String[]{"-t", "40", "-a", "90.0"};
        assertDoesNotThrow(() -> Application.main(args));
    }

    @Test
    void runAppWithDataFromFile() {
        String[] args = new String[]{"-t", "40", "-a", "90.0", "-f", "src/test/resources/access.log"};
        assertDoesNotThrow(() -> Application.main(args));
    }
}