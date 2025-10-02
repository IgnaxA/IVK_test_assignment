package org.panov.game.io.console.command.mapper;

import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.util.Assertions;
import org.panov.game.io.console.command.util.SplitUtils;

import java.util.List;

public abstract class BaseCommandMapper implements CommandMapper {
    @Override
    public Command mapCommand(String arguments) {
        List<String> separatedArguments = SplitUtils.getArguments(arguments);
        Assertions.assertArgumentNumber(separatedArguments, this.getArgumentsNumber());

        return this.mapCommand(separatedArguments);
    }

    protected abstract Command mapCommand(List<String> arguments);

    protected abstract int getArgumentsNumber();
}
