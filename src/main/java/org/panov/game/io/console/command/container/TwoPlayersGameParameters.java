package org.panov.game.io.console.command.container;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TwoPlayersGameParameters extends GameParameters<TwoPlayersGameParameters> {
    private PlayerParameters firstPlayer;
    private PlayerParameters secondPlayer;

    public TwoPlayersGameParameters setFirstPlayer(PlayerParameters firstPlayer) {
        this.handleNewPlayer(this.firstPlayer, firstPlayer);
        this.firstPlayer = firstPlayer;

        return this;
    }

    public TwoPlayersGameParameters setSecondPlayer(PlayerParameters secondPlayer) {
        this.handleNewPlayer(this.secondPlayer, secondPlayer);
        this.secondPlayer = secondPlayer;

        return this;
    }
}
