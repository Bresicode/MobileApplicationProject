package game.data;

import library.data.Slide;

import java.util.List;

public class PlayerImpl implements Player{
    int playerId;
    String playerName;
    List<Slide> playerHand;
    Slide playerAnswer;
    int playerScore;

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
