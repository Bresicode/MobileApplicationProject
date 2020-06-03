package com.example.evilslides.library.control;

import com.example.evilslides.library.model.CardImpl;

import java.io.File;
import java.util.List;

/**
 * Interface providing getters for a LibraryFileManager file and a List<CardImpl>
 */
public interface LibraryAccessor {
    /**
     * gets a library file manager
     * @return LibraryFileManager fm
     */
    LibraryFileManager getFm();

    /**
     * gets a file
     * @return File file
     */
    File getFile();

    /**
     * gets a list of cards
     * @return List<CardImpl> cards
     */
    List<CardImpl> getCards();
}
