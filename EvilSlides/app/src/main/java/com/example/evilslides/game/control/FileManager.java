package com.example.evilslides.game.control;

import android.content.Context;

import com.example.evilslides.game.model.SlideImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileManager {
    /**
     * writes data in a file
     * @param file target file
     */
    void writeToFile(File file, Context context, List<SlideImpl> slides);

    /**
     * builds a Slide list from file
     * @param file file with data
     * @param context Activity using the data
     * @throws FileNotFoundException if the file that should've been read wasn't found
     * @return List<SlideImpl> list of slides
     */
    List<SlideImpl> readFromFile(File file, Context context) throws FileNotFoundException;
}
