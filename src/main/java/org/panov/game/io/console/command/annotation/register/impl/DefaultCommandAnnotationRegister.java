package org.panov.game.io.console.command.annotation.register.impl;

import org.panov.game.io.console.command.annotation.CommandAnnotation;
import org.panov.game.io.console.command.annotation.register.CommandAnnotationRegister;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultCommandAnnotationRegister implements CommandAnnotationRegister {

    private final Set<CommandAnnotation> commands = new HashSet<>();

    public DefaultCommandAnnotationRegister(List<CommandAnnotation> commandsAnnotations) {
        this.commands.addAll(commandsAnnotations);
    }

    @Override
    public Set<CommandAnnotation> getCommandsAnnotations() {
        return this.commands;
    }

    @Override
    public boolean registerCommandAnnotation(CommandAnnotation commandAnnotation) {
        return this.commands.add(commandAnnotation);
    }
}
