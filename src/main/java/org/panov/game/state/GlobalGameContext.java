package org.panov.game.state;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.panov.game.manager.GameManager;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class GlobalGameContext {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private volatile static GlobalGameContext instance;

    private GameManager gameManager;
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

    public void endGames() {
        this.gamesCanBeStarted = false;
    }
}
