package com.example.evilcards.library.control;

import android.content.Context;

import com.example.evilcards.library.model.CardImpl;

import java.io.File;
import java.util.List;

public class LibraryAccessorImpl implements LibraryAccessor {
    LibraryFileManager fm;
    File file;
    List<CardImpl> slides;

    @Override
    public LibraryFileManager getFm() {
        return fm;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public List<CardImpl> getCards() {
        return slides;
    }

    public LibraryAccessorImpl(Context context) {
        file = new File(context.getFilesDir(), "data");
        fm = new LibraryFileManagerImpl();
        slides = fm.readFromFile(file, context);
    }
}
