package org.panov.game.player.impl;

import org.panov.game.board.GameBoard;
import org.panov.game.player.Player;
import org.panov.game.player.move.impl.ComputerMoveController;

public class ComputerPlayer extends Player {
    public ComputerPlayer(ComputerMoveController moveController) {
        super(moveController);
    }

    @Override
    protected void makeMove(GameBoard board) {

    }
}
