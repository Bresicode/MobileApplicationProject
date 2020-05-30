package library.data;

import java.util.List;

public class DeckImpl implements Deck{
    List<Slide> slides;
    int deckId;
    String deckName;

    public DeckImpl(List<Slide> slides, int deckId, String deckName) {
        this.slides = slides;
        this.deckId = deckId;
        this.deckName = deckName;
    }

    @Override
    public List<Slide> getSlides() {
        return this.slides;
    }

    @Override
    public void addSlide(Slide slide) {
        this.slides.add(slide);
    }

    @Override
    public void removeSlide(Slide slide) {
        this.slides.remove(slide);
    }
}
