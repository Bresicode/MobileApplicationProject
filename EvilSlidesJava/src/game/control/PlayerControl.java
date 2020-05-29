package game.control;

import game.data.Player;
import library.data.Slide;

/**
 * Interface providing methods for player changes
 */
public interface PlayerControl {

    /**
     * adds a slide to a player's hand
     *
     * @param slide Slide
     */
    void addSlideToPlayerHand(Player player, Slide slide);

    /**
     * removes a slide from a player's hand
     *
     * @param slide Slide
     */
    void removeSlideFromPlayerHand(Player player, Slide slide);

    /**
     * increases a player's score
     */
    void raisePlayerScore(Player player);

    void choosePlayerAnswer(Player player, Slide slide);
}
