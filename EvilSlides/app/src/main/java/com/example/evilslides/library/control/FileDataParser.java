package com.example.evilslides.library.control;


import com.example.evilslides.library.model.SlideImpl;
import java.io.File;
import java.util.List;

public interface FileDataParser {
    /**
     * reads data from a file and puts it into a List
     * @param file resource file containing data
     * @return a deck with a List<Slide> slides and String deckName
     */
    List<SlideImpl> parseDataFromFile(File file);

    /**
     * writes data from a list into a file
     * @return
     */
    void parseDataToFile(List<SlideImpl> slides);
}
