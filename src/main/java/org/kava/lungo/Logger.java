package org.kava.lungo;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.function.Supplier;

public class Logger {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final String context;
    private final Supplier<LocalDateTime> timeSupplier;
    private Level level;

    private final PrintStream output;

    public Logger(String context) {
        this(Level.INFO, context);
    }

    public Logger(Level level, String context) {
        this(level, context, LocalDateTime::now);
    }

    public Logger(Level level, String context, Supplier<LocalDateTime> timeSupplier) {
        this(level, context, timeSupplier, System.out);
    }

    public Logger(Level level, String context, PrintStream output) {
        this(level, context, LocalDateTime::now, output);
    }

    public Logger(Level level, String context, Supplier<LocalDateTime> timeSupplier, PrintStream output) {
        this.level = level;
        this.context = context;
        this.timeSupplier = timeSupplier;
        this.output = output;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private void log(Level level, String message, Object... args) {
        if (level.isLoggable(this.level)) {
            String log = String.format("[%s] [%s] [%s] - %s",
                    timeSupplier.get().format(DateTimeFormatter.ofPattern(DATE_FORMAT)),
                    level,
                    context,
                    String.format(message, args));


            output.println(log);
        }
    }

    public void trace(String message, Object... args) {
        log(Level.TRACE, message, args);
    }

    public void debug(String message, Object... args) {
        log(Level.DEBUG, message, args);
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warn(String message, Object... args) {
        log(Level.WARN, message, args);
    }

    public void error(String message, Object... args) {
        log(Level.ERROR, message, args);
    }

    public void fatal(String message, Object... args) {
        log(Level.FATAL, message, args);
    }
}
