package game.control;

import library.data.Slide;

/**
 * Interface providing methods for Player changes
 */
public interface PlayControl {
    /**
     * adds a slide to a player's hand
     * @param slide
     */
    void addSlideToPlayerHand(Slide slide);

    /**
     * removes a slide from a player's hand
     * @param slide
     */
    void removeSlideFromPlayerHand(Slide slide);
}
