package org.kava.lungo;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class LoggerFactory {
    private LoggerFactory() {}

    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz.getName());
    }

    public static Logger getLogger(String context) {
        return new Logger(context);
    }

    public static Logger getLogger(Class<?> clazz, Level level) {
        return new Logger(level, clazz.getName());
    }

    public static Logger getLogger(String context, Level level) {
        return new Logger(level, context);
    }

    public static Logger getLogger(Class<?> clazz, Level level, Supplier<LocalDateTime> timeSupplier) {
        return new Logger(level, clazz.getName(), timeSupplier);
    }

    public static Logger getLogger(String context, Level level, Supplier<LocalDateTime> timeSupplier) {
        return new Logger(level, context, timeSupplier);
    }

    public static Logger getLogger(Class<?> clazz, Level level, Supplier<LocalDateTime> timeSupplier, PrintStream output) {
        return new Logger(level, clazz.getName(), timeSupplier, output);
    }

    public static Logger getLogger(String context, Level level, Supplier<LocalDateTime> timeSupplier, PrintStream output) {
        return new Logger(level, context, timeSupplier, output);
    }

    public static Logger getLogger(Class<?> clazz, Level level, PrintStream output) {
        return new Logger(level, clazz.getName(), output);
    }

    public static Logger getLogger(String context, Level level, PrintStream output) {
        return new Logger(level, context, output);
    }
}
