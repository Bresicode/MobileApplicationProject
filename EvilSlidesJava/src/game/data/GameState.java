package game.data;

import library.data.Slide;

import java.util.List;

/**
 * Interface providing methods to get and set game state data
 */
public interface GameState {
    /**
     * Gets the score that is required to win game
     *
     * @return int scoreToWin
     */
    int getScoreToWin();

    /**
     * Gets a list of all players in the game
     *
     * @return List<Player> players
     */
    List<Player> getPlayers();

    /**
     * Gets a list of all slides that have been selected by the players
     *
     * @return List<Slide> playedCards
     */
    List<Slide> getPlayedCards();

    /**
     * Gets a boolean whether the game is in judge phase or not
     *
     * @return true if it's judge phase, else if it's not
     */
    boolean isJudgePhase();

    /**
     * Sets a boolean whether the game is in judge phase or not
     *
     * @param judgePhase boolean
     */
    void setJudgePhase(boolean judgePhase);

    /**
     * Gets the current question that has to be answered by the players
     *
     * @return Slide question
     */
    Slide getQuestion();

    /**
     * Sets the current question that has to be answered by the players
     *
     * @param question Slide
     */
    void setQuestion(Slide question);
}
