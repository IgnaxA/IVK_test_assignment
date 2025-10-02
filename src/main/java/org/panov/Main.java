package org.panov;

import org.apache.commons.lang3.StringUtils;
import org.panov.game.io.console.command.annotation.CommandAnnotation;
import org.panov.game.io.console.command.annotation.impl.ExitCommandAnnotation;
import org.panov.game.io.console.command.annotation.impl.GameCommandAnnotation;
import org.panov.game.io.console.command.annotation.impl.HelpCommandAnnotation;
import org.panov.game.io.console.command.annotation.impl.MoveCommandAnnotation;
import org.panov.game.io.console.command.annotation.register.CommandAnnotationRegister;
import org.panov.game.io.console.command.annotation.register.impl.DefaultCommandAnnotationRegister;
import org.panov.game.io.console.command.factory.CommandFactory;
import org.panov.game.io.console.command.factory.impl.ConsoleCommandFactory;
import org.panov.game.io.console.command.mapper.CommandMapper;
import org.panov.game.io.console.command.mapper.impl.ExitCommandMapper;
import org.panov.game.io.console.command.mapper.impl.GameCommandMapper;
import org.panov.game.io.console.command.mapper.impl.HelpCommandMapper;
import org.panov.game.io.console.command.mapper.impl.MoveCommandMapper;
import org.panov.game.io.console.controller.ConsoleController;
import org.panov.game.io.console.controller.impl.DefaultConsoleController;
import org.panov.game.io.controller.IOController;
import org.panov.game.io.controller.dispatcher.IOControllerDispatcher;
import org.panov.game.io.controller.dispatcher.impl.DefaultIOControllerDispatcher;
import org.panov.game.io.controller.impl.IOConsoleController;
import org.panov.thread.UncaughtExceptionHandler;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String IO_CONTROLLER_KEY = "io.controller";

    public static void main(String[] args) {
        setUpThreads();

        IOControllerDispatcher ioControllerDispatcher = injectDependencies();

        startListening(ioControllerDispatcher);
    }

    private static IOControllerDispatcher injectDependencies() {
        CommandFactory commandFactory = createCommandFactory();

        ConsoleController consoleController = new DefaultConsoleController(commandFactory);
        IOController ioConsoleController = new IOConsoleController(consoleController);

        IOControllerDispatcher ioControllerDispatcher = new DefaultIOControllerDispatcher(ioConsoleController);

        return ioControllerDispatcher;
    }

    private static CommandFactory createCommandFactory() {
        List<CommandMapper> commandsMappers = createCommandsMappers();

        CommandFactory commandFactory = new ConsoleCommandFactory(commandsMappers);

        return commandFactory;
    }

    private static List<CommandMapper> createCommandsMappers() {
        CommandAnnotationRegister commandAnnotationRegister = createCommandAnnotationRegister();

        CommandMapper exitCommandMapper = new ExitCommandMapper();
        CommandMapper helpCommandMapper = new HelpCommandMapper(commandAnnotationRegister);
        CommandMapper gameCommandMapper = new GameCommandMapper();
        CommandMapper moveCommandMapper = new MoveCommandMapper();

        List<CommandMapper> commandMappers =
                Arrays.asList(exitCommandMapper, helpCommandMapper, gameCommandMapper, moveCommandMapper);

        return commandMappers;
    }

    private static CommandAnnotationRegister createCommandAnnotationRegister() {
        List<CommandAnnotation> commandsAnnotations = createCommandAnnotations();

        CommandAnnotationRegister commandAnnotationRegister = new DefaultCommandAnnotationRegister(commandsAnnotations);
        return commandAnnotationRegister;
    }

    private static List<CommandAnnotation> createCommandAnnotations() {
        CommandAnnotation exitCommandAnnotation = new ExitCommandAnnotation();
        CommandAnnotation helpCommandAnnotation = new HelpCommandAnnotation();
        CommandAnnotation gameCommandAnnotation = new GameCommandAnnotation();
        CommandAnnotation moveCommandAnnotation = new MoveCommandAnnotation();

        List<CommandAnnotation> commandsAnnotations =
                Arrays.asList(exitCommandAnnotation, helpCommandAnnotation, gameCommandAnnotation, moveCommandAnnotation);

        return commandsAnnotations;
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