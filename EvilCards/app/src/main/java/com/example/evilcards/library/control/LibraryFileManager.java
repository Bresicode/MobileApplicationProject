package com.example.evilcards.library.control;

import android.content.Context;

import com.example.evilcards.library.model.CardImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Interface providing methods to write and read Card data to file
 */
public interface LibraryFileManager {
    /**
     * writes a Card list in a file
     * @param file target file
     */
    void writeToFile(File file, Context context, List<CardImpl> cards);

    /**
     * builds a Card list from file
     * @param file file with data
     * @param context Activity using the data
     * @throws FileNotFoundException if the file that should've been read wasn't found
     * @return List<CardImpl> list of cards
     */
    List<CardImpl> readFromFile(File file, Context context);
}
