package com.example.evilslides;


import com.example.evilslides.game.model.GameState;
import com.example.evilslides.game.model.GameStateImpl;
import com.example.evilslides.game.model.Player;
import com.example.evilslides.game.model.PlayerImpl;
import com.example.evilslides.library.model.Slide;
import com.example.evilslides.library.model.SlideImpl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class GameControlImplTest {

    @Test
    void addPlayer() {
        List<Slide> slides= new ArrayList<Slide>();
        slides.add(new SlideImpl("Kaka", 2, false));
        Player p = new PlayerImpl(1, "Kurt", slides, null, 0);
        List<PlayerImpl> players= new ArrayList<PlayerImpl>();
        GameState g = new GameStateImpl(10, new ArrayList<Player>(), new ArrayList<Slide>(), false, null);
        players.add((PlayerImpl) p);
        assertTrue(players.contains(p));
    }

    @Test
    void removePlayer() {
    }

    @Test
    void chooseWinner() {
    }

    @Test
    void addSlideToPlayerHand() {
    }

    @Test
    void removeSlideFromPlayerHand() {
    }

    @Test
    void raisePlayerScore() {
    }
}