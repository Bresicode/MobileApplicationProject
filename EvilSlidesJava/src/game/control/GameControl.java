package game.control;

import game.data.Player;

/**
 * Interface providing methods for GameState changes
 */
public interface GameControl {
    /**
     * adds a player to the game
     * @param player Player
     */
    void addPlayer(Player player);
    /**
     * removes a player from the game
     * @param player Player
     */
    void removePlayer(Player player);

    /**
     * determines who won the judgePhase
     */
    void chooseWinner();
}
