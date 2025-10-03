package org.panov.game.io.console.command.container;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class MoveParameters {
    private int xCoordinate;
    private int yCoordinate;
}
