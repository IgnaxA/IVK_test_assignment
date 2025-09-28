package org.panov.game.io.console.command.managing.impl;

import org.panov.game.io.console.command.managing.GameManagementCommand;

public class GameCommand implements GameManagementCommand {
    @Override
    public int getArgumentsNumber() {
        return 3;
    }

    @Override
    public String getAnnotation() {
        return "";
    }
}
