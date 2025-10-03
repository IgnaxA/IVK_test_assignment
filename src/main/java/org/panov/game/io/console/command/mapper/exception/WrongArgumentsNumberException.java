package org.panov.game.io.console.command.mapper.exception;

public class WrongArgumentsNumberException extends RuntimeException {
    private static final String TEXT = "Wrong command arguments number. Expected %d but got %d.";

    public WrongArgumentsNumberException(int expectedArgumentsNumber, int actualArgumentsNumber) {
        super(String.format(TEXT, expectedArgumentsNumber, actualArgumentsNumber));
    }
}
