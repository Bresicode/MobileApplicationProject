package com.example.evilslides.library.control;

import library.data.Deck;
import library.data.Library;
import library.data.Slide;

public interface LibraryControl {
    /**
     * adds a deck to a library
     * @param library the library the deck has to be added to
     * @param deck the deck that has to be added
     */
    void addDeck(Library library, Deck deck);

    /**
     * removes a deck from library
     * @param library the library the deck has to be removed
     * @param deck the deck that has to be removed
     */
    void removeDeck(Library library, Deck deck);

    /**
     * adds a slide to a deck
     * @param deck the deck the slide has to be added to
     * @param slide the slide that has to be added
     */
    void addSlide(Deck deck, Slide slide);

    /**
     * removes a slide from a deck
     * @param deck the deck the slide has to be removed from
     * @param slide the slide that has to be removed
     */
    void removeSlide(Deck deck, Slide slide);
}
