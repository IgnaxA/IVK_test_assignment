package org.panov.game.io.console.command.container;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class GameParameters {
    int boardSize;

    @Setter(AccessLevel.NONE)
    Set<PlayerParameters> players;
}
