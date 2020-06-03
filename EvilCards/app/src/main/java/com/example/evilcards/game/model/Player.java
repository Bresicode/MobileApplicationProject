package com.example.evilcards.game.model;


import com.example.evilcards.library.model.Card;

import java.util.List;

/**
 * Interface providing methods to get and set player fields
 */
public interface Player {

    /**
     * Gets the player's Id
     *
     * @return int playerId
     */
    int getPlayerId();

    /**
     * Gets the player name
     *
     * @return String playerName
     */
    String getPlayerName();

    /**
     * Gets a list of the cards currently in the player's hand
     *
     * @return List<Card> playerHand
     */
    List<Card> getPlayerHand();

    /**
     * Gets the player's selected Card
     *
     * @return Card selection
     */
    Card getPlayerAnswer();

    /**
     * Sets the players answer card
     *
     * @param playerAnswer Card
     */
    void setPlayerAnswer(Card playerAnswer);

}
