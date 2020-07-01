package com.example.evilcards.game.model;


import com.example.evilcards.library.model.Card;
import com.example.evilcards.library.model.CardImpl;

import java.util.ArrayList;
import java.util.List;


public class PlayerImpl implements Player {

    private int playerId;
    private String playerName;
    private List<CardImpl> playerHand;
    private Card playerAnswer;

    public PlayerImpl(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerHand = new ArrayList<CardImpl>();
    }

    @Override
    public int getPlayerId() {
        return this.playerId;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public List<CardImpl> getPlayerHand() {
        return this.playerHand;
    }

    @Override
    public Card getPlayerAnswer() {
        return this.playerAnswer;
    }

    @Override
    public void setPlayerAnswer(Card playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

}
