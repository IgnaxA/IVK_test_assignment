package org.panov.game.io.console.command.managing.impl;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.panov.game.io.console.command.container.MoveParameters;
import org.panov.game.io.console.command.managing.GameManagementCommand;

@RequiredArgsConstructor
@EqualsAndHashCode
public class MoveCommand implements GameManagementCommand {
    public static final String NAME = "move";

    private final MoveParameters parameters;

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return NAME;
    }
}
