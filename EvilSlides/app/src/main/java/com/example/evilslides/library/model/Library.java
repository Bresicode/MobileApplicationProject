package com.example.evilslides.library.model;


import java.util.List;

public interface Library {
    /**
     * returns list of all decks in the library
     *
     * @return decks ArrayList<DeckImpl>
     */
    List<Deck> getDecks();
}
