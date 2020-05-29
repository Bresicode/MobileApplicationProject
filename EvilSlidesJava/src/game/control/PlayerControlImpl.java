package game.control;

import game.data.Player;
import library.data.Slide;

public class PlayerControlImpl implements PlayerControl {

    @Override
    public void addSlideToPlayerHand(Player player, Slide slide) {
        player.getPlayerHand().add(slide);
    }

    @Override
    public void removeSlideFromPlayerHand(Player player, Slide slide) {
        player.getPlayerHand().remove(slide);
    }

    @Override
    public void raisePlayerScore(Player player) {
        player.setPlayerScore(player.getPlayerScore()+1);
    }

    @Override
    public void choosePlayerAnswer(Player player, Slide slide) {
        player.setPlayerAnswer(slide);
    }


}
