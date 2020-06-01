package com.example.evilslides.library.control;


import com.example.evilslides.library.model.SlideImpl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataParserImpl implements FileDataParser {

    @Override
    public List<SlideImpl> parseDataFromFile(File file) {
        List<SlideImpl> slides = new ArrayList<SlideImpl>();
        try {
            Scanner myScanner = new Scanner(file);
            while (myScanner.hasNextLine()) {
                if (myScanner.nextLine() == "newSlide") {
                    slides.add(new SlideImpl(myScanner.nextLine(), myScanner.nextInt(), myScanner.nextBoolean()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return slides;
    }

    @Override
    public void parseDataToFile(List<SlideImpl> slides) {
        try {
            FileWriter myWriter = new FileWriter("slidedata.txt");
            int i;
            for (i = 0; i < slides.size(); i++) {
                myWriter.write("newSlide");
                myWriter.write(slides.get(i).getText());
                myWriter.write(slides.get(i).getSlideId());
                if (slides.get(i).isQuestion()) {
                    myWriter.write("true");
                } else {
                    myWriter.write("false");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
