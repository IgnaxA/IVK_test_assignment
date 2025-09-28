package org.panov.game.event.subject;

import org.panov.event.subject.Subject;
import org.panov.game.event.observer.PlayerObserver;

public interface GameEventNotifier extends Subject<PlayerObserver> {
}
