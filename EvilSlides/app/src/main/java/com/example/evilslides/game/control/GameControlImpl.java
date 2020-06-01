package com.example.evilslides.game.control;


import com.example.evilslides.game.model.GameState;
import com.example.evilslides.game.model.Player;
import com.example.evilslides.game.model.Slide;

public class GameControlImpl implements GameControl {

    @Override
    public void addPlayer(GameState gameState, Player player) {
        gameState.getPlayers().add(player);
    }

    @Override
    public void removePlayer(GameState gameState, Player player) {
        gameState.getPlayers().remove(player);
    }

    @Override
    public void chooseWinner(GameState gameState) {

    }

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
        player.setPlayerScore(player.getPlayerScore() + 1);
    }

}
