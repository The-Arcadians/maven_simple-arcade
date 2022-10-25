package com.github.curriculeon.utils;

public interface Loggable {
    default IOConsole getConsole() {
        return getConsole(AnsiColor.AUTO);
    }

    default IOConsole getConsole(AnsiColor color) {
        return new IOConsole(color);
    }

    default void info(String message, Object... arguments) {
        getConsole().println(message, arguments);
    }

    default void warn(String message, Object... arguments) {
        getConsole(AnsiColor.YELLOW).println(message, arguments);
    }

    default void error(String message, Object... arguments) {
        getConsole(AnsiColor.RED).println(message, arguments);
    }

    default void special(String message, Object... arguments) {
        getConsole(AnsiColor.GREEN).println(message, arguments);
    }

    default String selectString(String message, Object... arguments) {
        return getConsole(AnsiColor.CYAN).getStringInput(message, arguments);
    }

    default Integer selectInteger(String message, Object... arguments) {
        return getConsole(AnsiColor.CYAN).getIntegerInput(message, arguments);
    }

    default String getCurrentMethod() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}
