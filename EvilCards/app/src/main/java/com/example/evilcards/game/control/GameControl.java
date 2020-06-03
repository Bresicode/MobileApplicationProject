package com.example.evilcards.game.control;

import com.example.evilcards.game.model.GameState;

/**
 * Interface providing methods for GameState and Player changes
 */
public interface GameControl {

    /**
     * fills the players hands with random non question cards
     */
    void dealCards(GameState gameState);

    /**
     * sets a random question in gameState
     *
     * @param gameState the current game
     */
    void randomizeQuestion(GameState gameState);
}
