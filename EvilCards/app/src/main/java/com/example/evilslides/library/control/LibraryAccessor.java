package com.example.evilslides.library.control;

import android.content.Context;

import com.example.evilslides.library.model.CardImpl;

import java.io.File;
import java.util.List;

public class LibraryAccessor {
    LibraryFileManager fm;
    File file;
    List<CardImpl> slides;

    public LibraryFileManager getFm() {
        return fm;
    }

    public File getFile() {
        return file;
    }

    public List<CardImpl> getSlides() {
        return slides;
    }

    public LibraryAccessor(Context context) {
        file = new File(context.getFilesDir(), "data");
        fm = new LibraryFileManagerImpl();
        slides = fm.readFromFile(file, context);
    }
}
