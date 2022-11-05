package org.kava.lungo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    @Test
    public void testIsLoggableTrace() {
        assertTrue(Level.TRACE.isLoggable(Level.TRACE));
        assertFalse(Level.TRACE.isLoggable(Level.DEBUG));
        assertFalse(Level.TRACE.isLoggable(Level.INFO));
        assertFalse(Level.TRACE.isLoggable(Level.WARN));
        assertFalse(Level.TRACE.isLoggable(Level.ERROR));
        assertFalse(Level.TRACE.isLoggable(Level.FATAL));
    }

    @Test
    public void testIsLoggableInfo() {
        assertTrue(Level.INFO.isLoggable(Level.TRACE));
        assertFalse(Level.INFO.isLoggable(Level.WARN));
    }

    @Test
    public void testIsLoggableFatal() {
        for (Level level : Level.values()) {
            assertTrue(Level.FATAL.isLoggable(level));
        }
    }

    @Test
    public void allToStringEqual() {
        assertEquals(1, Arrays.stream(Level.values())
                .map(Level::toString)
                .map(String::length)
                .distinct()
                .count());
    }
}
