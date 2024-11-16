import java.util.Random;

public class AIplayer3 implements WheelOfFortunePlayer{
// guesses vowels, then a random consonant

    private final char[] vowels = {'A', 'E', 'I', 'O', 'U'}; // final because we are never changing this list
    private final char[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
    private int vowelIndex = 0;  // Tracks which vowel to guess next
    Random random = new Random();

    @Override
    public char nextGuess(){ // start with just guessing random letters
        char guess;

        if (vowelIndex < vowels.length) {
            guess = vowels[vowelIndex++];
        } else {
            int randomIndex = random.nextInt(0,21); // returns a random integer btwn 0 (inclusive) and 21 (exclusive)
            // after vowels are exhausted, pick a random consonant
            guess = consonants[randomIndex];
        }

        return guess;

    }

    @Override
    public String playerId(){
        return "AI Player #3";

    }

    @Override
    public void reset(){
        vowelIndex = 0;
    }

}
