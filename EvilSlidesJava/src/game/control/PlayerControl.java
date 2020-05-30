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

    /**
     * sets a player's answer slide
     * @param player Player who's answer has to be set
     * @param slide Slide that will become the answer
     */
    void choosePlayerAnswer(Player player, Slide slide);
}
