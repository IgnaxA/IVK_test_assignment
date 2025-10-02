package org.panov.game.io.console.controller.impl;

import lombok.RequiredArgsConstructor;
import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.factory.CommandFactory;
import org.panov.game.io.console.controller.ConsoleController;
import org.panov.game.state.GlobalGameContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class DefaultConsoleController implements ConsoleController {
    private final CommandFactory commandFactory;

    private Scanner scanner;

    @Override
    public void startListening() {
        this.scanner = this.createScanner();

        GlobalGameContext gameContext = GlobalGameContext.getInstance();

        while (gameContext.isGamesCanBeStarted()) {
            try {
                String input = this.scanner.nextLine();
                this.processInput(input);
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
        }

        this.scanner.close();
    }

    private void processInput(String input) {
        String preparedInput = this.prepareInput(input);
        Command command = this.commandFactory.createCommand(preparedInput);
        command.execute();
    }

    private Scanner createScanner() {
        return new Scanner(System.in);
    }

    private String prepareInput(String input) {
        return input.trim();
    }
}
