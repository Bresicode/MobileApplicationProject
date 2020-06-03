package com.example.evilslides.library.model;

/**
 * Interface providing getters for Card fields
 */
public interface Card {
    /**
     * returns the text of the slide
     *
     * @return String slideText
     */
    String getText();

    /**
     * returns the slideId of the slide
     *
     * @return slideId int
     */
    int getSlideId();

    /**
     * returns a boolean depending on if the slide is a question or not
     *
     * @return true if slide is a question, false if it no question
     */
    boolean isQuestion();

}
