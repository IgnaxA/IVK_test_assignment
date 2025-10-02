package org.panov.game.io.console.command.mapper.impl;

import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.mapper.BaseCommandMapper;
import org.panov.game.io.console.command.support.impl.ExitCommand;

import java.util.List;

public class ExitCommandMapper extends BaseCommandMapper {
    private static final int ARGUMENTS_NUMBER = 0;

    @Override
    public String getAssignedCommandName() {
        return ExitCommand.NAME;
    }

    @Override
    protected Command mapCommand(List<String> arguments) {
        return new ExitCommand();
    }

    @Override
    protected int getArgumentsNumber() {
        return ARGUMENTS_NUMBER;
    }
}
