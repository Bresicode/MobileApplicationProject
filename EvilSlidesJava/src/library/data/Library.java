package library.data;


import java.util.List;

public interface Library{
    /**
     * returns list of all decks in the library
     * @return decks ArrayList<DeckImpl>
     */
    List<Deck> getDecks();

    /**
     * adds a deck to the deck list
     * @param deck the deck that has to be added
     */
    void addDeck(Deck deck);

    /**
     * removes a deck from the deck list
     * @param deck the deck that has to be removed
     */
    void removeDeck(Deck deck);


}
