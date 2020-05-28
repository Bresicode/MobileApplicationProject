package game.data;

import library.data.Slide;

import java.util.List;

public class GameStateImpl implements GameState{

    private int scoreToWin;
    private List<Player> players;
    private List<Slide> playedCards;
    private boolean judgePhase;
    private Slide question;

    @Override
    public int getScoreToWin() {
        return this.scoreToWin;
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public List<Slide> getPlayedCards() {
        return this.playedCards;
    }

    @Override
    public boolean isJudgePhase() {
        return this.judgePhase;
    }

    @Override
    public Slide getQuestion() {
        return this.question;
    }
}
