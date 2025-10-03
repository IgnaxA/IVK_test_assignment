package org.panov.game.io.console.command.annotation.impl;

import org.panov.game.io.console.command.annotation.AnnotationPriority;
import org.panov.game.io.console.command.annotation.BaseCommandAnnotation;

public class MoveCommandAnnotation extends BaseCommandAnnotation {
    private final AnnotationPriority priority = AnnotationPriority.MEDIUM;

    @Override
    public int getAnnotationPriority() {
        return this.priority.getPriority();
    }

    @Override
    protected String getCommandName() {
        final String commandName = "MOVE";

        return commandName;
    }

    @Override
    protected String getCommandArguments() {
        final String commandArguments = "<x_coordinate>, <y_coordinate>";

        return commandArguments;
    }

    @Override
    protected String getCommandDescription() {
        final String commandDescription = "Places piece in a cell at chosen coordinate";

        return commandDescription;
    }
}
