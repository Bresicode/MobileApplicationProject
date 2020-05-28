package game.data;

import library.data.Slide;

import java.util.List;

public class GameStateImpl implements GameState{

    private int scoreToWin;
    private List<Player> players;
    private List<Slide> playedCards;
    private boolean judgePhase;
    private Slide question;

    public GameStateImpl(int scoreToWin, List<Player> players, List<Slide> playedCards, boolean judgePhase, Slide question) {
        this.scoreToWin = scoreToWin;
        this.players = players;
        this.playedCards = playedCards;
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
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public List<Slide> getPlayedCards() {
        return this.playedCards;
    }

    @Override
    public void setPlayerCards(List<Slide> playedCards) {
        this.playedCards = playedCards;
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
