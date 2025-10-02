package org.panov.game.io.console.command.managing.impl;

import lombok.EqualsAndHashCode;
import org.panov.game.io.console.command.managing.GameManagementCommand;

@EqualsAndHashCode
public class MoveCommand implements GameManagementCommand {
    public static final String NAME = "MOVE";

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
