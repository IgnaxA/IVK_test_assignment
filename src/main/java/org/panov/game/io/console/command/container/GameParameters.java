package org.panov.game.io.console.command.container;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
public class GameParameters<T extends GameParameters> {
    private int boardSize;

    @Setter(AccessLevel.NONE)
    private Set<PlayerParameters> players = new HashSet<>();

    public T setBoardSize(int boardSize) {
        this.boardSize = boardSize;

        return (T) this;
    }

    protected void handleNewPlayer(PlayerParameters existingPlayer, PlayerParameters newPlayer) {
        if (existingPlayer != null) {
            this.removePlayer(existingPlayer);
        }
        this.addPlayer(newPlayer);
    }

    protected void addPlayer(PlayerParameters player) {
        this.players.add(player);
    }

    protected void removePlayer(PlayerParameters player) {
        this.players.remove(player);
    }
}
