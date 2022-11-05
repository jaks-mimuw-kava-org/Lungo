package org.kava.lungo;

import java.util.Arrays;

public enum Level {
    TRACE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    FATAL;

    boolean isLoggable(Level border) {
        return this.ordinal() >= border.ordinal();
    }

    private static final int MAX_LENGTH = Arrays.stream(values())
            .map(Enum::name)
            .map(String::length)
            .max(Integer::compareTo)
            .orElse(0);

    @Override
    public String toString() {
        return String.format("%-" + MAX_LENGTH + "s", name());
    }
}
