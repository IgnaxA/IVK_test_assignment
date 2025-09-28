package org.panov.game.io.controller.impl;

import lombok.RequiredArgsConstructor;
import org.panov.game.io.console.controller.ConsoleController;
import org.panov.game.io.controller.IOController;
import org.panov.game.io.controller.IOControllerType;

@RequiredArgsConstructor
public class IOConsoleController implements IOController {
    private final IOControllerType type = IOControllerType.CONSOLE;
    private final ConsoleController consoleController;

    @Override
    public void startListening() {
        this.consoleController.startListening();
    }

    @Override
    public String getType() {
        return this.type.getName();
    }
}
