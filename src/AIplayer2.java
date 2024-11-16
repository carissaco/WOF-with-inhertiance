import java.util.Random;

public class AIplayer2 implements WheelOfFortunePlayer{
    // AI player 2 will guess vowels first, then guess the most used consonants in the english language
    private final char[] letters = {'A', 'E', 'I', 'O', 'U', 'T', 'N', 'S', 'H', 'R', 'D', 'L', 'C', 'M', 'W', 'F'}; // contains 16 chars total for 16 max guesses
        // these are vowels, followed by the most common consonants
    private int letterIndex = 0;

    @Override
    public char nextGuess() {
        char guess = letters[letterIndex];
        letterIndex++;
        return guess;
    }

    @Override
    public String playerId(){
        return "AI player #2";

    }

    @Override
    public void reset(){
        letterIndex = 0;
    }

}
