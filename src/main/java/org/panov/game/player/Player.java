package org.panov.game.player;

import org.panov.game.board.GameBoard;
import org.panov.game.event.observer.PlayerObserver;
import org.panov.game.player.move.MoveController;

public abstract class Player implements PlayerObserver {
    private final MoveController moveController;

    protected Player(MoveController moveController) {
        this.moveController = moveController;
    }

    @Override
    public void handleGameStartEvent() {

    }

    protected abstract void makeMove(GameBoard board);
}