package org.panov.game.io.console.command.support.impl;

import org.panov.game.io.console.command.support.SupportiveCommand;

public class HelpCommand implements SupportiveCommand {
    @Override
    public int getArgumentsNumber() {
        return 0;
    }

    @Override
    public String getAnnotation() {
        return "";
    }
}
