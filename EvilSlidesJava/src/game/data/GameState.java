package game.data;

import library.data.Slide;

import java.util.List;

/**
 * Interface providing methods to get game state data
 */
public interface GameState {
    /**
     * Get the score that is required to win game
     * @return int scoreToWin
     */
    int getScoreToWin();

    /**
     * Get a list of all players in the game
     * @return List<Player> players
     */
    List<Player> getPlayers();

    /**
     * Get a list of all slides that have been selected by the players
     * @return List<Slide> playedCards
     */
    List<Slide> getPlayedCards();

    /**
     * Gets a boolean whether the game is in judge phase or not
     * @return true if it's judge phase, else if it's not
     */
    boolean isJudgePhase();

    /**
     * Gets the current question that has to be answered by the players
     * @return Slide question
     */
    Slide getQuestion();
}
