package org.panov.game.io.console.command.annotation;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseCommandAnnotation implements CommandAnnotation {
    protected final static String EMPTY_ARGUMENTS = "";

    @Override
    public String buildAnnotation() {
        String commandName = this.getCommandName();
        String commandArguments = this.getCommandArguments();
        String commandDescription = this.getCommandDescription();

        return StringUtils.isNotEmpty(commandArguments)
            ? this.buildAnnotationForCommandWithArguments(commandName, commandDescription, commandArguments)
            : this.buildAnnotationForCommandWithoutArguments(commandName, commandDescription);
    }

    protected abstract String getCommandName();

    protected abstract String getCommandArguments();

    protected abstract String getCommandDescription();

    private String buildAnnotationForCommandWithArguments(String commandName,
                                                          String commandDescription,
                                                          String commandArguments) {
        final String commandTemplateWithArguments = "%s  -  %s\nArguments: %s";

        return String.format(commandTemplateWithArguments, commandName, commandDescription, commandArguments);
    }

    private String buildAnnotationForCommandWithoutArguments(String commandName, String commandDescription) {
        final String commandTemplateWithoutArguments = "%s  -  %s";

        return String.format(commandTemplateWithoutArguments, commandName, commandDescription);
    }
}
