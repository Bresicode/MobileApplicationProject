package com.example.evilslides.game.model;



import com.example.evilslides.library.model.Slide;

import java.util.List;

public class GameStateImpl implements GameState {
    private int scoreToWin;
    private List<Player> players;
    private List<Slide> playedSlides;
    private boolean judgePhase;
    private Slide question;

    public GameStateImpl(int scoreToWin, List<Player> players, List<Slide> playedSlides, boolean judgePhase, Slide question) {
        this.scoreToWin = scoreToWin;
        this.players = players;
        this.playedSlides = playedSlides;
        this.judgePhase = judgePhase;
        this.question = question;
    }

    @Override
    public int getScoreToWin() {
        return this.scoreToWin;
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public List<Slide> getPlayedSlides() {
        return this.playedSlides;
    }

    @Override
    public boolean isJudgePhase() {
        return this.judgePhase;
    }

    @Override
    public void setJudgePhase(boolean judgePhase) {
        this.judgePhase = judgePhase;
    }

    @Override
    public Slide getQuestion() {
        return this.question;
    }

    @Override
    public void setQuestion(Slide question) {
        this.question = question;
    }
}
