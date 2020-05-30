package game.control;

import game.data.GameState;
import game.data.Player;
import library.data.Slide;

/**
 * Interface providing methods for GameState and Player changes
 */
public interface GameControl {
    /**
     * adds a player to a game
     * @param gameState game the player has to be added to
     * @param player the player that has to be added
     */
    void addPlayer(GameState gameState, Player player);
    /**
     * removes a player to a game
     * @param gameState game the player has to be removed from
     * @param player the player that has to be removed
     */
    void removePlayer(GameState gameState, Player player);

    /**
     * chooses the winner of a judgePhase
     * @param gameState the current game
     */
    void chooseWinner(GameState gameState);

    /**
     * adds a slide to a player's hand
     * @param player the player who receives the slide
     * @param slide the slide that has to be added
     */
    void addSlideToPlayerHand(Player player, Slide slide);

    /**
     * removes a slide from a player's hand
     * @param player the player who loses the slide
     * @param slide the slide that has to be removed
     */
    void removeSlideFromPlayerHand(Player player, Slide slide);

    /**
     * raises a player's score
     * @param player the player who's score has to be raised
     */
    void raisePlayerScore(Player player);

}
