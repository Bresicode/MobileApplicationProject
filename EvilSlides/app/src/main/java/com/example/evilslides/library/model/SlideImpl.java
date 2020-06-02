package com.example.evilslides.library.model;

import androidx.annotation.NonNull;

public class SlideImpl implements Slide {
    private String slideText;
    private int slideId;
    private boolean question;

    public SlideImpl(String slideText, int slideId, boolean question) {
        this.slideText = slideText;
        this.slideId = slideId;
        this.question = question;
    }

    @Override
    public String getText() {
        return this.slideText;
    }

    @Override
    public int getSlideId() {
        return this.slideId;
    }

    @Override
    public boolean isQuestion() {
        return this.question;
    }

    @NonNull
    @Override
    public String toString() {
        String s = this.slideText+"\n"+ this.slideId+"\n";
        if(isQuestion() == true){
            s+="true\n";
        }else {
            s+="false\n";
        }
        return s;
    }
}
