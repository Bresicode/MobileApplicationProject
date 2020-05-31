package com.example.evilslides.game.data;

import library.data.Slide;

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
    List<Slide> getPlayerHand();

    /**
     * Gets the player's selected Slide
     *
     * @return Slide selection
     */
    Slide getPlayerAnswer();

    /**
     * Sets the players answer slide
     *
     * @param playerAnswer Slide playerName
     */
    void setPlayerAnswer(Slide playerAnswer);

    /**
     * Gets the player's current score
     *
     * @return int playerScore
     */
    int getPlayerScore();

    /**
     * Sets the player's score
     *
     * @param playerScore int playerScore
     */
    void setPlayerScore(int playerScore);

}
