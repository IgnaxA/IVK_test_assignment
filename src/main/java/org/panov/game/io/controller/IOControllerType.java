package org.panov.game.io.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IOControllerType {
    CONSOLE("CONSOLE"),
    REST("REST");

    private final String name;
}
