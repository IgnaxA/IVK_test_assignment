package org.panov.game.io.console.command.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.mapper.BaseCommandMapper;
import org.panov.game.io.console.command.annotation.register.CommandAnnotationRegister;
import org.panov.game.io.console.command.support.impl.HelpCommand;

import java.util.List;

@RequiredArgsConstructor
public class HelpCommandMapper extends BaseCommandMapper {
    private static final int ARGUMENTS_NUMBER = 0;

    private final CommandAnnotationRegister commandAnnotationRegister;

    @Override
    public String getAssignedCommandName() {
        return HelpCommand.NAME;
    }

    @Override
    protected Command mapCommand(List<String> arguments) {
        return new HelpCommand(this.commandAnnotationRegister);
    }

    @Override
    protected int getArgumentsNumber() {
        return ARGUMENTS_NUMBER;
    }
}
