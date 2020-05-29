package game.control;

import game.data.GameState;
import game.data.Player;
import library.data.Slide;

public class GameControlImpl implements GameControl {
    private GameState gamemodel;

    public GameControlImpl(GameState gamemodel) {
        this.gamemodel = gamemodel;
    }

    @Override
    public void addPlayer(Player player) {
        gamemodel.getPlayers().add(player);
    }

    @Override
    public void removePlayer(Player player) {
        gamemodel.getPlayers().remove(player);
    }
}
