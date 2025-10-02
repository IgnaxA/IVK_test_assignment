package org.panov.game.io.console.command.container;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Accessors(chain = true)
public class TwoPlayersGameParameters extends GameParameters {
    PlayerParameters firstPlayer;
    PlayerParameters secondPlayer;

    public void setFirstPlayer(PlayerParameters firstPlayer) {
        if (this.firstPlayer != null) {
            this.players.remove(firstPlayer);
        }
        this.firstPlayer = firstPlayer;
        this.players.add(firstPlayer);
    }

    public void setSecondPlayer(PlayerParameters secondPlayer) {
        if (this.secondPlayer != null) {
            this.players.remove(secondPlayer);
        }
        this.firstPlayer = secondPlayer;
        this.players.add(secondPlayer);
    }
}
