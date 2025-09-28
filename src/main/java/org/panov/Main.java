package org.panov;

import org.apache.commons.lang3.StringUtils;
import org.panov.game.io.console.controller.ConsoleController;
import org.panov.game.io.console.controller.impl.DefaultConsoleController;
import org.panov.game.io.controller.IOController;
import org.panov.game.io.controller.dispatcher.IOControllerDispatcher;
import org.panov.game.io.controller.dispatcher.impl.DefaultIOControllerDispatcher;
import org.panov.game.io.controller.impl.IOConsoleController;
import org.panov.thread.UncaughtExceptionHandler;

public class Main {
    private static final String IO_CONTROLLER_KEY = "io.controller";

    public static void main(String[] args) {
        setUpThreads();

        ConsoleController consoleController = new DefaultConsoleController();
        IOController ioConsoleController = new IOConsoleController(consoleController);

        IOControllerDispatcher ioControllerDispatcher = new DefaultIOControllerDispatcher(ioConsoleController);

        startListening(ioControllerDispatcher);
    }

    private static void startListening(IOControllerDispatcher ioControllerDispatcher) {
        String controllerType = System.getProperty(IO_CONTROLLER_KEY);
        if (StringUtils.isEmpty(controllerType)) {
            throw new RuntimeException("Unable to start game. Set controller in java options by key: " + IO_CONTROLLER_KEY);
        }

        IOController ioController = ioControllerDispatcher.findIOController(controllerType)
                .orElseThrow(() -> new RuntimeException("Unable to find controller with type: " + controllerType));

        ioController.startListening();
    }

    private static void setUpThreads() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
    }
}