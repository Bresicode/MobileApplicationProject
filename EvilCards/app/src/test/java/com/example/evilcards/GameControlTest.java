package com.example.evilcards;


import com.example.evilcards.game.control.GameControl;
import com.example.evilcards.game.control.GameControlImpl;
import com.example.evilcards.game.model.GameState;
import com.example.evilcards.game.model.GameStateImpl;
import com.example.evilcards.game.model.Player;
import com.example.evilcards.game.model.PlayerImpl;
import com.example.evilcards.library.model.Card;
import com.example.evilcards.library.model.CardImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GameControlTest {
    private List<CardImpl> testGameDeckEmpty;
    private List<PlayerImpl> testPlayersEmpty;
    private PlayerImpl testPlayer1;
    private PlayerImpl testPlayer2;
    private PlayerImpl testPlayer3;
    private CardImpl testCard1;
    private CardImpl testCard2;
    private CardImpl testCard3;
    private CardImpl testCard4;
    private CardImpl testCard5;
    private List<PlayerImpl> testPlayersFilled;
    private List<CardImpl> testGameDeckFilled;
    private GameState testGameState;


    @BeforeEach
    void setup() {
        //testcards
        testCard1 = new CardImpl("TestText1", 1, false);
        testCard2 = new CardImpl("TestText2", 2, false);
        testCard3 = new CardImpl("TestText3", 3, false);
        testCard4 = new CardImpl("TestQuestion1", 4, true);
        testCard5 = new CardImpl("TestQuestion1", 5, true);

        //testplayers
        testPlayer1 = new PlayerImpl(1, "TestPlayer1");
        testPlayer2 = new PlayerImpl(2, "TestPlayer2");
        testPlayer3 = new PlayerImpl(3, "TestPlayer3");
        //empty players/gamedeck
        testPlayersEmpty = new ArrayList<PlayerImpl>();
        testGameDeckEmpty = new ArrayList<CardImpl>();

        //filled player lists
        testPlayersFilled = new ArrayList<PlayerImpl>();
        testPlayersFilled.add(testPlayer1);
        testPlayersFilled.add(testPlayer2);
        testPlayersFilled.add(testPlayer3);

        //filled card lists
        testGameDeckFilled = new ArrayList<CardImpl>();
        testGameDeckFilled.add(testCard1);
        testGameDeckFilled.add(testCard2);
        testGameDeckFilled.add(testCard3);
        testGameDeckFilled.add(testCard4);
        testGameDeckFilled.add(testCard5);
    }

    /**
     * Prüft ob Spielerhände nicht leer sind, genau 5 Karten enthält und ob es sich bei den Karten nicht um Fragen handelt
     */
    @Test
    void TestDealCardsGut() {
        testGameState = new GameStateImpl(testPlayersFilled, testGameDeckFilled);
        GameControl gc = new GameControlImpl();
        gc.dealCards(testGameState);
        for (Player player : testGameState.getPlayers()) {
            assertFalse(player.getPlayerHand().isEmpty());
            assertTrue(player.getPlayerHand().size() == 5);
            for (Card card : player.getPlayerHand()
            ) {
                assertFalse(card.isQuestion());
            }
        }
    }

    /**
     * Prüft ob bei leerer Spielerliste oder leerem Spieldeck eine IllegalStateException geworfen wird
     */
    @Test
    void TestDealCardsSchlecht() {
        testGameState = new GameStateImpl(testPlayersFilled, testGameDeckEmpty);
        GameControl gc = new GameControlImpl();

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            gc.dealCards(testGameState);
        });

        assertTrue(exception.getMessage().contains("gameDeck is empty"));

        testGameState = new GameStateImpl(testPlayersEmpty, testGameDeckFilled);

        IllegalStateException exception2 = assertThrows(IllegalStateException.class, () -> {
            gc.dealCards(testGameState);
        });

        assertTrue(exception2.getMessage().contains("players is empty"));
    }

    /**
     * Prüft ob Card mit isQuestion true gewählt wurde und nicht null ist
     */
    @Test
    void TestRandomizeQuestionGut() {
        testGameState = new GameStateImpl(testPlayersFilled, testGameDeckFilled);
        GameControl gc = new GameControlImpl();
        gc.randomizeQuestion(testGameState);
        assertFalse(testGameState.getQuestion() == null);
        assertFalse(testGameState.getQuestion().isQuestion());
    }

    /**
     * Prüft ob IllegalStateException geworfen wird, falls das GameDeck leer ist
     */
    @Test
    void TestRandomizeQuestionSchlecht() {
        testGameState = new GameStateImpl(testPlayersFilled, testGameDeckEmpty);
        GameControl gc = new GameControlImpl();

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            gc.randomizeQuestion(testGameState);
        });

    }
}