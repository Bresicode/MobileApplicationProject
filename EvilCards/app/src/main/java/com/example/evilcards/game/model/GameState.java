package com.example.evilcards.game.model;


import com.example.evilcards.library.model.Card;
import com.example.evilcards.library.model.CardImpl;

import java.util.List;

/**
 * Interface providing methods to get and set gameState fields
 */
public interface GameState {

    /**
     * Gets a list of all players in the game
     *
     * @return List<PlayerImpl> players
     */
    List<PlayerImpl> getPlayers();

    /**
     * gets the list of cards that are the game deck
     *
     * @return List<CardImpl> gameDeck
     */
    List<CardImpl> getGameDeck();

    /**
     * Gets a list of all cards that have been selected by the players
     *
     * @return List<CardImpl> playedCards
     */
    List<CardImpl> getPlayedCards();

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
