package org.panov.game.event.observer;

import org.panov.event.observer.Observer;
import org.panov.game.board.GameBoard;

public interface PlayerObserver extends Observer {
    void handleGameStartEvent();
}
