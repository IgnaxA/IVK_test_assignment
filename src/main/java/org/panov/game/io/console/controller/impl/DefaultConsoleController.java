package org.panov.game.io.console.controller.impl;

import lombok.NoArgsConstructor;
import org.panov.game.io.console.controller.ConsoleController;

import java.util.Scanner;

@NoArgsConstructor
public class DefaultConsoleController implements ConsoleController {
    private Scanner scanner;

    @Override
    public void startListening() {
        this.scanner = new Scanner(System.in);

        boolean stoppedListening = false;

        while (!stoppedListening) {
            this.scanner.nextLine();
        }
    }
}
