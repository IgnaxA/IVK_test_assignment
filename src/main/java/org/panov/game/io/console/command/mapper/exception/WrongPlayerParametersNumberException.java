package org.panov.game.io.console.command.mapper.exception;

public class WrongPlayerParametersNumberException extends RuntimeException {
    private static final String TEXT = "Wrong player parameters arguments number. Expected %d but got %d.";

    public WrongPlayerParametersNumberException(int expectedParametersNumber, int actualParametersNumber) {
        super(String.format(TEXT, expectedParametersNumber, actualParametersNumber));
    }
}
