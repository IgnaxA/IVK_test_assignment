package org.panov.game.io.console.command.mapper;

import org.apache.commons.lang3.StringUtils;
import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.util.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseCommandMapper implements CommandMapper {
    private static final String ARGUMENT_SEPARATOR = ", ";

    @Override
    public Command mapCommand(String arguments) {
        List<String> separatedArguments = this.parseArguments(arguments);
        Assertions.assertArgumentNumber(separatedArguments, this.getArgumentsNumber());

        List<String> preparedArguments = this.prepareArguments(separatedArguments);

        return this.mapCommand(preparedArguments);
    }

    protected abstract Command mapCommand(List<String> arguments);

    protected abstract int getArgumentsNumber();

    private List<String> parseArguments(String arguments) {
        return Arrays.stream(arguments.split(ARGUMENT_SEPARATOR))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }

    private List<String> prepareArguments(List<String> arguments) {
        return arguments.stream()
            .map(this::prepareArgument)
            .collect(Collectors.toList());
    }

    private String prepareArgument(String argument) {
        return argument.trim().toLowerCase();
    }
}
