package org.panov.game.io.console.command.annotation;

public interface CommandAnnotation {
    String buildAnnotation();

    int getAnnotationPriority();
}
