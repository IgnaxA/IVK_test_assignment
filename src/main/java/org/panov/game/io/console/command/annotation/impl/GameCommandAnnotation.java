package org.panov.game.io.console.command.annotation.impl;

import org.panov.game.io.console.command.annotation.AnnotationPriority;
import org.panov.game.io.console.command.annotation.BaseCommandAnnotation;

public class GameCommandAnnotation extends BaseCommandAnnotation {
    private final AnnotationPriority priority = AnnotationPriority.HIGH;

    @Override
    public int getAnnotationPriority() {
        return this.priority.getPriority();
    }

    @Override
    protected String getCommandName() {
        final String commandName = "GAME";

        return commandName;
    }

    @Override
    protected String getCommandArguments() {
        final String commandArguments =
                "<squares_number>, <user_type>('user' | 'comp') <piece_color>('W' | 'B'), <user_type>('user' | 'comp') <piece_color>('W' | 'B')";

        return commandArguments;
    }

    @Override
    protected String getCommandDescription() {
        final String commandDescription = "Starts new game with certain parameters";

        return commandDescription;
    }
}
