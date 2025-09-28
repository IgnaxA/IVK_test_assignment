package org.panov;

import org.panov.thread.UncaughtExceptionHandler;

public class Main {

    public static void main(String[] args) {
        setUpThreads();

        throw new RuntimeException("asd");
    }

    private static void setUpThreads() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
    }
}