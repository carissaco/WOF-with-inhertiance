// the AI player interface
public interface WheelOfFortunePlayer {
    char nextGuess(); // get the next guess from the player
    String playerId(); // an ID for the player
    void reset(); // reset the player to start a new game -- i dont think i need this tho cuz i use loadPhrases()

}
