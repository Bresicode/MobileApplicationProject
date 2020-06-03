package com.example.evilslides.library.control;

import android.content.Context;
import com.example.evilslides.library.model.SlideImpl;

import java.io.File;
import java.util.List;

public class DataBuilder {
    FileManager fm;
    File file;
    List<SlideImpl> slides;

    public FileManager getFm() {
        return fm;
    }

    public File getFile() {
        return file;
    }

    public List<SlideImpl> getSlides() {
        return slides;
    }

    public DataBuilder(Context context) {
        file = new File(context.getFilesDir(), "data");
        fm = new FileManagerImpl();
        slides = fm.readFromFile(file, context);
    }
}
