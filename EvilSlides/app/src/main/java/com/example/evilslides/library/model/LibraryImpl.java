package com.example.evilslides.library.model;

import java.util.List;

public class LibraryImpl implements Library {
    List<Deck> decks;

    public LibraryImpl(List<Deck> decks) {
        this.decks = decks;
    }

    @Override
    public List<Deck> getDecks() {
        return this.decks;
    }
}
