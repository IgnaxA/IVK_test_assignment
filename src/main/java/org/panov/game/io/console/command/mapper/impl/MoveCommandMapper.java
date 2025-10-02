package org.panov.game.io.console.command.mapper.impl;

import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.managing.impl.MoveCommand;
import org.panov.game.io.console.command.mapper.BaseCommandMapper;

import java.util.List;

public class MoveCommandMapper extends BaseCommandMapper {
    private static final int ARGUMENTS_NUMBER = 2;

    @Override
    public String getAssignedCommandName() {
        return MoveCommand.NAME;
    }

    @Override
    protected Command mapCommand(List<String> arguments) {
        return null;
    }

    @Override
    protected int getArgumentsNumber() {
        return ARGUMENTS_NUMBER;
    }
}
