package com.example.evilslides.game.model;


import com.example.evilslides.library.model.Card;

import java.util.List;

/**
 * Interface providing methods to get and set gameState fields
 */
public interface GameState {

    /**
     * Gets a list of all players in the game
     *
     * @return List<Player> players
     */
    List<Player> getPlayers();

    /**
     * gets the list of cards that are the game deck
     * @return List<Card> gameDeck
     */
    List<Card> getGameDeck();

    /**
     * Gets a list of all cards that have been selected by the players
     *
     * @return List<Card> playedCards
     */
    List<Card> getPlayedCards();

    /**
     * Gets the current question that has to be answered by the players
     *
     * @return Card question
     */
    Card getQuestion();

    /**
     * Sets the current question that has to be answered by the players
     *
     * @param question Card
     */
    void setQuestion(Card question);
}
