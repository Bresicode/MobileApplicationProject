package library.data;

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

    @Override
    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

    @Override
    public void removeDeck(Deck deck) {
        this.decks.remove(deck);
    }
}
