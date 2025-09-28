package org.panov.game.player.impl;

import org.panov.game.board.GameBoard;
import org.panov.game.player.Player;
import org.panov.game.player.move.impl.BotMoveController;

public class BotPlayer extends Player {
    public BotPlayer(BotMoveController moveController) {
        super(moveController);
    }

    @Override
    protected void makeMove(GameBoard board) {

    }
}
