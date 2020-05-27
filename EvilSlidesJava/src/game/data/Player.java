package game.data;

import library.data.Slide;

import java.util.List;

/**
 * Interface providing methods to get player data
 */
public interface Player {
    /**
     * Get the player's Id
     * @return int playerId
     */
    int getPlayerId();

    /**
     * Get the player name
     * @return String playerName
     */
    String getPlayerName();

    /**
     * Get a list of the slides currently in the player's hand
     * @return List<Slide> playerHand
     */
    List<Slide> getPlayerHand();

    /**
     * Get the player's selected card
     * @return Slide selection
     */
    Slide getPlayerAnswer();

    /**
     * Get the player's current score
     * @return int playerScore
     */
    int getPlayerScore();

}
