package game.control;

import game.data.GameState;
import game.data.Player;

public class GameControlImpl implements GameControl {
    private GameState game;
    private PlayerControl pControl;

    public GameControlImpl(GameState game) {
        this.game = game;
        this.pControl = new PlayerControlImpl();
    }

    @Override
    public void addPlayer(Player player) {
        game.getPlayers().add(player);
    }

    @Override
    public void removePlayer(Player player) {
        game.getPlayers().remove(player);
    }

    @Override
    public void chooseWinner() {

    }


}
