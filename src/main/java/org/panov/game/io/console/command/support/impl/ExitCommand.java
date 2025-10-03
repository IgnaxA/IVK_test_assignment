package org.panov.game.io.console.command.support.impl;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.panov.game.io.console.command.support.SupportiveCommand;
import org.panov.game.state.GlobalGameContext;

@NoArgsConstructor
@EqualsAndHashCode
public class ExitCommand implements SupportiveCommand {
    public static final String NAME = "exit";

    @Override
    public void execute() {
        GlobalGameContext gameContext = GlobalGameContext.getInstance();

        gameContext.endGames();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
