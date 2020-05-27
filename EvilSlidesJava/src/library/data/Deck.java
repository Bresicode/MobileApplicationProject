package library.data;

import java.util.List;

public interface Deck {
    /**
     * returns the list of all slides in the deck
     * @return slides ArrayList<Slide>
     */
    List<Slide> getSlides();

    /**
     * adds a slide to the slide list
     * @param slide the slide that has to be added
     */
    void addSlide(Slide slide);

    /**
     * removes a slide from the slide list
     * @param slide the slide that has to be removed
     */
    void removeSlide(Slide slide);
}
