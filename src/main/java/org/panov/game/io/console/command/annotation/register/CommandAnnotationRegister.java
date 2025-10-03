package org.panov.game.io.console.command.annotation.register;

import org.panov.game.io.console.command.annotation.CommandAnnotation;

import java.util.Set;

public interface CommandAnnotationRegister {
    Set<CommandAnnotation> getCommandsAnnotations();

    boolean registerCommandAnnotation(CommandAnnotation commandAnnotation);
}
