package com.example.evilcards.library.model;

import androidx.annotation.NonNull;

public class CardImpl implements Card {
    private String slideText;
    private int slideId;
    private boolean question;

    public CardImpl(String slideText, int slideId, boolean question) {
        this.slideText = slideText;
        this.slideId = slideId;
        this.question = question;
    }

    @Override
    public String getText() {
        return this.slideText;
    }

    @Override
    public int getCardId() {
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
