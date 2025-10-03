package org.panov.game.io.console.command.factory.impl;

import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.factory.CommandFactory;
import org.panov.game.io.console.command.mapper.CommandMapper;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConsoleCommandFactory implements CommandFactory {
    private static final String COMMAND_SEPARATOR_BETWEEN_NAME_AND_ARGUMENTS = " ";

    private final Map<String, CommandMapper> commandsMappers = new ConcurrentHashMap<>();

    public ConsoleCommandFactory(List<CommandMapper> commandsMappers) {
        commandsMappers.forEach(commandMapper -> {
            this.commandsMappers.put(commandMapper.getAssignedCommandName(), commandMapper);
        });
    }

    @Override
    public Command createCommand(String input) {
        String commandName = this.getCommandName(input);

        CommandMapper commandMapper = this.commandsMappers.get(commandName);
        if (commandMapper == null) {
            throw new RuntimeException("Unknown command: " + commandName + ". Try use HELP to get commands list.");
        }

        String arguments = this.getArguments(input, commandName);

        return commandMapper.mapCommand(arguments);
    }

    private String getArguments(String input, String commandName) {
        String commandNameWithSeparator = commandName + COMMAND_SEPARATOR_BETWEEN_NAME_AND_ARGUMENTS;

        if (input.startsWith(commandNameWithSeparator)) {
            return input.substring(commandNameWithSeparator.length());
        }

        return input.substring(commandName.length());
    }

    private String getCommandName(String input) {
        final int zeroIndex = 0;

        int index = input.indexOf(COMMAND_SEPARATOR_BETWEEN_NAME_AND_ARGUMENTS);

        return index != -1
                ? input.substring(zeroIndex, index)
                : input;
    }

    @PreDestroy
    public void destroy() {
        this.commandsMappers.clear();
    }
}
