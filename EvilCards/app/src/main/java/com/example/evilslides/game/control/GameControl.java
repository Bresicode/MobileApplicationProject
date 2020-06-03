package com.example.evilslides.game.control;

import com.example.evilslides.game.model.GameState;
import com.example.evilslides.game.model.Player;

/**
 * Interface providing methods for GameState and Player changes
 */
public interface GameControl {

    /**
     * fills the players hands with random non question cards
     */
    void dealSlides(GameState gameState);

    /**
     * sets a random question in gameState
     * @param gameState the current game
     */
    void randomizeQuestion(GameState gameState);
}
