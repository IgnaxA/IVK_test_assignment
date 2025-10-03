package org.panov.game.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PlayerType {
    USER("user"),
    COMPUTER("comp");

    private final String name;

    public static PlayerType getPlayerType(String playerType) {
        for (PlayerType type : PlayerType.values()) {
            if (type.getName().equalsIgnoreCase(playerType)) {
                return type;
            }
        }

        throw new RuntimeException("Unknown player type: " + playerType);
    }
}
