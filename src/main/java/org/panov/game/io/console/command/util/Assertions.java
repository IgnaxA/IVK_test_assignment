package org.panov.game.io.console.command.util;

import org.panov.game.io.console.command.mapper.exception.WrongArgumentsNumberException;

import java.util.Collection;

public class Assertions {
    public static <T> void assertArgumentNumber(Collection<T> arguments, int expectedArgumentsNumber) {
        if (arguments.size() != expectedArgumentsNumber) {
            throw new WrongArgumentsNumberException(expectedArgumentsNumber, arguments.size());
        }
    }
}
