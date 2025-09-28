package org.panov.game.manager.impl;

import org.panov.game.event.observer.PlayerObserver;
import org.panov.game.manager.GameManager;

public class TwoPlayersGameManager implements GameManager {
    private PlayerObserver firstPlayer;
    private PlayerObserver secondPlayer;

    public TwoPlayersGameManager() {

    }

    @Override
    public void register(PlayerObserver observer) {
        if (observer.equals(this.firstPlayer) || observer.equals(this.secondPlayer)) {
            throw new RuntimeException("This player is already registered");
        }

        if (this.firstPlayer == null) {
            this.setFirstPlayer(observer);
        } else if (this.secondPlayer == null) {
            this.setSecondPlayer(observer);
        } else {
            throw new RuntimeException("Two players have already been registered for the game");
        }
    }

    @Override
    public void remove(PlayerObserver observer) {
        if (observer.equals(this.firstPlayer)) {
            this.unregisterFirstPlayer();
        } else if (observer.equals(this.secondPlayer)) {
            this.unregisterSecondPlayer();
        }
    }

    @Override
    public void startGame() {
        this.assertGameReadyToStart();

        this.firstPlayer.handleGameStartEvent();
        this.secondPlayer.handleGameStartEvent();
    }

    private void unregisterFirstPlayer() {
        this.setFirstPlayer(null);
    }

    private void unregisterSecondPlayer() {
        this.setSecondPlayer(null);
    }

    private void setFirstPlayer(PlayerObserver observer) {
        this.firstPlayer = observer;
    }

    private void setSecondPlayer(PlayerObserver observer) {
        this.secondPlayer = observer;
    }

    private void assertGameReadyToStart() {
        if (this.firstPlayer == null || this.secondPlayer == null) {
            throw new RuntimeException("Not enough players are registered for the game");
        }
    }
}
