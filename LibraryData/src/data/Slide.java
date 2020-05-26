package data;

public interface Slide {
    /**
     * returns the text of the slide
     * @return String slideText
     */
    String getText();

    /**
     * sets the text of the slide
     * @param slideText String
     */
    void setText(String slideText);

    /**
     * returns the slideId of the slide
     * @return slideId int
     */
    int getSlideId();

    /**
     * returns a boolean depending on if the slide is a question or not
     * @return true if slide is a question, false if it no question
     */
    boolean isQuestion();

    /**
     * sets isQuestion to true or false
     * @param question boolean
     */
    void setQuestion(boolean question);

}
