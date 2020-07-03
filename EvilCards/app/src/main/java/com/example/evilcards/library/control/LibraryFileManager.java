package com.example.evilcards.library.control;

import com.example.evilcards.library.model.CardImpl;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Interface providing methods to write and read Card data to file
 */
public interface LibraryFileManager {
    /**
     * writes a Card list in a file
     */
    void writeToFile(List<CardImpl> cards);

    /**
     * builds a Card list from file
     *
     * @return List<CardImpl> list of cards
     * @throws FileNotFoundException if the file that should've been read wasn't found
     */
    List<CardImpl> readFromFile();

}
