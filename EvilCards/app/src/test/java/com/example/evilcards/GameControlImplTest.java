package com.example.evilcards;


import com.example.evilcards.game.model.GameState;
import com.example.evilcards.game.model.GameStateImpl;
import com.example.evilcards.game.model.Player;
import com.example.evilcards.game.model.PlayerImpl;
import com.example.evilcards.library.model.Card;
import com.example.evilcards.library.model.CardImpl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class GameControlImplTest {

    @Test
    void addPlayer() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new CardImpl("Kaka", 2, false));
        Player p = new PlayerImpl(1, "Kurt", cards, null, 0);
        List<PlayerImpl> players= new ArrayList<PlayerImpl>();
        GameState g = new GameStateImpl(10, new ArrayList<Player>(), new ArrayList<Card>(), false, null);
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