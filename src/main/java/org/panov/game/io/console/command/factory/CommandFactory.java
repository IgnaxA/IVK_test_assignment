package org.panov.game.io.console.command.factory;

import org.panov.game.io.console.command.Command;

public interface CommandFactory {
    Command createCommand(String input);
}
