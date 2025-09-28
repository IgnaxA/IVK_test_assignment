package org.panov.game.player.impl;

import org.panov.game.board.GameBoard;
import org.panov.game.player.Player;
import org.panov.game.player.move.impl.PlayerMoveController;

public class HumanPlayer extends Player {
    public HumanPlayer(PlayerMoveController moveController) {
        super(moveController);
    }

    @Override
    protected void makeMove(GameBoard board) {

    }
}
