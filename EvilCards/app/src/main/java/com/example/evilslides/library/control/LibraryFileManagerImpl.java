package com.example.evilslides.library.control;

import android.content.Context;

import com.example.evilslides.library.model.CardImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LibraryFileManagerImpl implements LibraryFileManager {

    @Override
    public void writeToFile(File file, Context context, List<CardImpl> slides) {
        String filename = "data";
        String fileContents = "";
        for (CardImpl s : slides) {
            fileContents += s.toString();
        }
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(fileContents.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CardImpl> readFromFile(File file, Context context){
        List<CardImpl> slides = new ArrayList<CardImpl>();
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<CardImpl>();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                slides.add( new CardImpl(line, Integer.parseInt(reader.readLine()) ,Boolean.parseBoolean(reader.readLine())));
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        }
        return slides;
    }
}
