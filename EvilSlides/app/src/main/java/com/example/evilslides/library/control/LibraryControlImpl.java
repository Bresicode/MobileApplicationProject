package com.example.evilslides.library.control;


import com.example.evilslides.library.model.Deck;
import com.example.evilslides.library.model.Library;
import com.example.evilslides.library.model.Slide;

public class LibraryControlImpl implements LibraryControl {
    public LibraryControlImpl() {

    }

    @Override
    public void addDeck(Library library, Deck deck) {
        library.getDecks().add(deck);
    }

    @Override
    public void removeDeck(Library library, Deck deck) {
        library.getDecks().remove(deck);
    }

    @Override
    public void addSlide(Deck deck, Slide slide) {
        deck.getSlides().add(slide);
    }

    @Override
    public void removeSlide(Deck deck, Slide slide) {
        deck.getSlides().remove(slide);
    }
}
