package com.example.evilcards.game.model;


import com.example.evilcards.library.model.Card;
import com.example.evilcards.library.model.CardImpl;

import java.util.ArrayList;
import java.util.List;

public class GameStateImpl implements GameState {
    private List<PlayerImpl> players;
    private List<CardImpl> gameDeck;
    private List<CardImpl> playedCards;
    private Card question;

    public GameStateImpl(List<PlayerImpl> players, List<CardImpl> gameDeck) {
        this.players = players;
        this.gameDeck = gameDeck;
        this.playedCards = new ArrayList<CardImpl>();
        this.question = null;
    }

    @Override
    public List<PlayerImpl> getPlayers() {
        return this.players;
    }

    @Override
    public List<CardImpl> getGameDeck() {
        return gameDeck;
    }

    @Override
    public List<CardImpl> getPlayedCards() {
        return this.playedCards;
    }

    @Override
    public Card getQuestion() {
        return this.question;
    }

    @Override
    public void setQuestion(Card question) {
        this.question = question;
    }
}
