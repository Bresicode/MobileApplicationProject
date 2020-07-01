package com.example.evilcards.library.model;

/**
 * Interface providing getters for Card fields
 */
public interface Card {
    /**
     * returns the text of the card
     *
     * @return String text
     */
    String getText();

    /**
     * returns the cardId of the card
     *
     * @return cardId int
     */
    int getCardId();

    /**
     * returns a boolean depending on if the card is a question or not
     *
     * @return true if card is a question, false if it is no question
     */
    boolean isQuestion();

}
