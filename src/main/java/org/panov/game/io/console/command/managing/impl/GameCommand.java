package org.panov.game.io.console.command.managing.impl;

import lombok.EqualsAndHashCode;
import org.panov.game.io.console.command.container.GameParameters;
import org.panov.game.io.console.command.managing.GameManagementCommand;

@EqualsAndHashCode
public class GameCommand implements GameManagementCommand {
    public static final String NAME = "GAME";

    public GameCommand(GameParameters gameParameters) {

    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getAnnotation() {
        return "";
    }
}
