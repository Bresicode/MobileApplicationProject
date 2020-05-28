package game.data;

import library.data.Slide;

import java.util.List;


public class PlayerImpl implements Player{

    private int playerId;
    private String playerName;
    private List<Slide> playerHand;
    private Slide playerAnswer;
    private int playerScore;

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
    public int getPlayerScore() {
        return this.playerScore;
    }
}
