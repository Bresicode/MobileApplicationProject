package com.example.evilslides.game.control;

import android.content.Context;
import android.util.Log;
import com.example.evilslides.game.model.SlideImpl;

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

public class FileManagerImpl implements FileManager {
    @Override
    public void writeToFile(File file, Context context, List<SlideImpl> slides) {
        String filename = "data";
        String fileContents = "";
        for (SlideImpl s : slides) {
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
    public List<SlideImpl> readFromFile(File file, Context context) throws FileNotFoundException {
        List<SlideImpl> slides = new ArrayList<SlideImpl>();
        FileInputStream fis = context.openFileInput(file.getName());
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                slides.add( new SlideImpl(line, Integer.parseInt(reader.readLine()) ,Boolean.parseBoolean(reader.readLine())));
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        }
        return slides;
    }
}
