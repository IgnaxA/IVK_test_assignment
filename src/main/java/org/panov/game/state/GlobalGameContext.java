package org.panov.game.state;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.panov.game.io.console.command.container.TwoPlayersGameParameters;
import org.panov.game.manager.GameManager;
import org.panov.game.manager.impl.TwoPlayersGameManager;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalGameContext {
    private volatile static GlobalGameContext instance;

    private GameManager gameManager;

    @Getter
    @Setter
    private volatile boolean gamesCanBeStarted = true;

    public static GlobalGameContext getInstance() {
        if (instance == null) {
            synchronized (GlobalGameContext.class) {
                if (instance == null) {
                    instance = new GlobalGameContext();
                }
            }
        }

        return instance;
    }

    public void startGame(TwoPlayersGameParameters gameParameters) {
        if (!this.gamesCanBeStarted) {
            throw new RuntimeException("Cannot start game because it's restricted");
        }

        GameManager gameManager = new TwoPlayersGameManager();

        this.setGameManager(gameManager);
        this.gameManager.startGame();
    }

    public void endGames() {
        this.gamesCanBeStarted = false;
    }

    private void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
}
