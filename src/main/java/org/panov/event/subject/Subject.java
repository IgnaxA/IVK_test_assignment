package org.panov.event.subject;

import org.panov.event.observer.Observer;

public interface Subject<T extends Observer> {
    void register(T observer);
    void remove(T observer);
}
