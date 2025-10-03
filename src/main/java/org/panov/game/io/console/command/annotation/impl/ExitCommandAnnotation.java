package org.panov.game.io.console.command.annotation.impl;

import org.panov.game.io.console.command.annotation.AnnotationPriority;
import org.panov.game.io.console.command.annotation.BaseCommandAnnotation;

public class ExitCommandAnnotation extends BaseCommandAnnotation {
    private final AnnotationPriority priority = AnnotationPriority.LOW;

    @Override
    public int getAnnotationPriority() {
        return this.priority.getPriority();
    }

    @Override
    protected String getCommandName() {
        final String commandName = "EXIT";

        return commandName;
    }

    @Override
    protected String getCommandArguments() {
        final String commandArguments = EMPTY_ARGUMENTS;

        return commandArguments;
    }

    @Override
    protected String getCommandDescription() {
        final String commandDescription = "Exits the game";

        return commandDescription;
    }
}
