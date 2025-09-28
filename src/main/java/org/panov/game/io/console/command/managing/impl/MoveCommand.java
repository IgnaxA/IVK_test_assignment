package org.panov.game.io.console.command.managing.impl;

import org.panov.game.io.console.command.managing.GameManagementCommand;

public class MoveCommand implements GameManagementCommand {
    @Override
    public int getArgumentsNumber() {
        return 2;
    }

    @Override
    public String getAnnotation() {
        return "";
    }
}
