package com.example.evilslides.game.model;


import com.example.evilslides.library.model.Card;

import java.util.List;

/**
 * Interface providing methods to get and set player data
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
     * Gets a list of the slides currently in the player's hand
     *
     * @return List<Slide> playerHand
     */
    List<Card> getPlayerHand();

    /**
     * Gets the player's selected Slide
     *
     * @return Slide selection
     */
    Card getPlayerAnswer();

    /**
     * Sets the players answer slide
     *
     * @param playerAnswer Slide playerName
     */
    void setPlayerAnswer(Card playerAnswer);

}
