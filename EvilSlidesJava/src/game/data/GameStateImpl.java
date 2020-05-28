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
        return 0;
    }

    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public List<Slide> getPlayedCards() {
        return null;
    }

    @Override
    public boolean isJudgePhase() {
        return false;
    }

    @Override
    public Slide getQuestion() {
        return null;
    }
}
