package org.panov.game.io.console.command.mapper;

import org.panov.game.io.console.command.Command;

public interface CommandMapper {
    Command mapCommand(String arguments);

    String getAssignedCommandName();
}
