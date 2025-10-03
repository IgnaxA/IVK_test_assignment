package org.panov.game.io.console.command.annotation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AnnotationPriority {
    LOW(-1),
    MEDIUM(0),
    HIGH(1);

    private final int priority;
}
