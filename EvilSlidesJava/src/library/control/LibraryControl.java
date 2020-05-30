package library.control;

import library.data.Deck;
import library.data.Slide;

public interface LibraryControl {
    /**
     * adds a deck to a deck list
     * @param deck the deck that has to be added
     */
    void addDeck(Deck deck);

    /**
     * removes a deck from the deck list
     * @param deck the deck that has to be removed
     */
    void removeDeck(Deck deck);

    /**
     * adds a slide to the slide list
     * @param slide the slide that has to be added
     */
    void addSlide(Slide slide);

    /**
     * removes a slide from the slide list
     * @param slide the slide that has to be removed
     */
    void removeSlide(Slide slide);
}
