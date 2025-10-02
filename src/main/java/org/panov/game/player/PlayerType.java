package org.panov.game.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PlayerType {
    USER("user"),
    COMPUTER("comp");

    private final String name;
}
