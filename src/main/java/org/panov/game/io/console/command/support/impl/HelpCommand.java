package org.panov.game.io.console.command.support.impl;

import lombok.EqualsAndHashCode;
import org.panov.game.io.console.command.annotation.CommandAnnotation;
import org.panov.game.io.console.command.annotation.register.CommandAnnotationRegister;
import org.panov.game.io.console.command.support.SupportiveCommand;

import java.util.Comparator;
import java.util.Set;

@EqualsAndHashCode
public class HelpCommand implements SupportiveCommand {
    public static final String NAME = "help";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final CommandAnnotationRegister commandAnnotationRegister;

    public HelpCommand(CommandAnnotationRegister commandAnnotationRegister) {
        this.commandAnnotationRegister = commandAnnotationRegister;
    }

    @Override
    public void execute() {
        Set<CommandAnnotation> commandsAnnotations = this.commandAnnotationRegister.getCommandsAnnotations();

        commandsAnnotations.stream()
            .sorted(this.getCommandAnnotationComparator())
            .forEach(this::printCommandAnnotation);
    }

    @Override
    public String getName() {
        return NAME;
    }

    private Comparator<CommandAnnotation> getCommandAnnotationComparator() {
        return Comparator.comparing(CommandAnnotation::getAnnotationPriority, Comparator.reverseOrder())
            .thenComparing(CommandAnnotation::buildAnnotation, Comparator.naturalOrder());
    }

    private void printCommandAnnotation(CommandAnnotation commandAnnotation) {
        String builtCommandAnnotation = commandAnnotation.buildAnnotation() + LINE_SEPARATOR;

        System.out.println(builtCommandAnnotation);
    }
}
