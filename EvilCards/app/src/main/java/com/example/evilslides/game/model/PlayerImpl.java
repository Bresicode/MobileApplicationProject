package com.example.evilslides.game.model;



import com.example.evilslides.library.model.Card;

import java.util.List;


public class PlayerImpl implements Player {

    private int playerId;
    private String playerName;
    private List<Card> playerHand;
    private Card playerAnswer;

    public PlayerImpl(int playerId, String playerName, List<Card> playerHand, Card playerAnswer, int playerScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerHand = playerHand;
        this.playerAnswer = playerAnswer;
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
    public List<Card> getPlayerHand() {
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
