package library.data;

import java.util.List;

public interface Deck {
    /**
     * returns the decks Id
     *
     * @return deckId int
     */
    int getDeckId();

    /**
     * returns the decks name
     *
     * @return deckName String
     */
    String getDeckName();

    /**
     * returns the list of all slides in the deck
     *
     * @return slides ArrayList<Slide>
     */
    List<Slide> getSlides();

}
