package org.panov.game.io.console.command.support.impl;

import lombok.EqualsAndHashCode;
import org.panov.game.io.console.command.annotation.register.CommandAnnotationRegister;
import org.panov.game.io.console.command.support.SupportiveCommand;

@EqualsAndHashCode
public class HelpCommand implements SupportiveCommand {
    public static final String NAME = "HELP";

    private final CommandAnnotationRegister commandAnnotationRegister;

    public HelpCommand(CommandAnnotationRegister commandAnnotationRegister) {
        this.commandAnnotationRegister = commandAnnotationRegister;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getAnnotation() {
        return "";
    }
}
