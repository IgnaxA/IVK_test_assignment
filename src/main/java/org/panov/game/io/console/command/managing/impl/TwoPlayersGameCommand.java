package org.panov.game.io.console.command.managing.impl;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.panov.game.io.console.command.container.TwoPlayersGameParameters;
import org.panov.game.io.console.command.managing.GameManagementCommand;
import org.panov.game.state.GlobalGameContext;

@RequiredArgsConstructor
@EqualsAndHashCode
public class TwoPlayersGameCommand implements GameManagementCommand {
    public static final String NAME = "game";

    private final TwoPlayersGameParameters gameParameters;

    @Override
    public void execute() {
        GlobalGameContext globalGameContext = GlobalGameContext.getInstance();
        globalGameContext.startGame(this.gameParameters);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
