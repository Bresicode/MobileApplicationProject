package com.example.evilslides.game.model;



import com.example.evilslides.library.model.Card;

import java.util.List;

public class GameStateImpl implements GameState {
    private List<Player> players;
    private List<Card> gameDeck;
    private List<Card> playedCards;
    private Card question;

    public GameStateImpl(List<Player> players, List<Card> gameDeck) {
        this.players = players;
        this.gameDeck = gameDeck;
        this.playedCards = null;
        this.question = null;
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public List<Card> getGameDeck() {
        return gameDeck;
    }

    @Override
    public List<Card> getPlayedCards() {
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
