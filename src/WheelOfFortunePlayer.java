public interface WheelOfFortunePlayer {
    char nextGuess(); // get the next guess from the player
    String playerId(); // an ID for the player
    void reset(); // reset the player to start a new game

}
