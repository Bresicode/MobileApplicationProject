package com.example.evilslides.library.data;

import java.util.List;

public class DeckImpl implements Deck {

    List<Slide> slides;
    int deckId;
    String deckName;

    public DeckImpl(List<Slide> slides, int deckId, String deckName) {
        this.slides = slides;
        this.deckId = deckId;
        this.deckName = deckName;
    }

    @Override
    public int getDeckId() {
        return this.deckId;
    }

    @Override
    public String getDeckName() {
        return this.deckName;
    }

    @Override
    public List<Slide> getSlides() {
        return this.slides;
    }

}
