package org.panov.game.manager;

import org.panov.game.event.subject.GameEventNotifier;

public interface GameManager extends GameEventNotifier {
    void startGame();
}
