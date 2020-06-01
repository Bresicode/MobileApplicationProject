package com.example.evilslides.game.model;



import java.util.List;


public class PlayerImpl implements Player {

    private int playerId;
    private String playerName;
    private List<Slide> playerHand;
    private Slide playerAnswer;
    private int playerScore;

    public PlayerImpl(int playerId, String playerName, List<Slide> playerHand, Slide playerAnswer, int playerScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerHand = playerHand;
        this.playerAnswer = playerAnswer;
        this.playerScore = playerScore;
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
    public List<Slide> getPlayerHand() {
        return this.playerHand;
    }

    @Override
    public Slide getPlayerAnswer() {
        return this.playerAnswer;
    }

    @Override
    public void setPlayerAnswer(Slide playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

    @Override
    public int getPlayerScore() {
        return this.playerScore;
    }

    @Override
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
