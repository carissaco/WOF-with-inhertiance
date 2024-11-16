import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Mastermind extends Game{
    int codeLength = 4;
    protected final char[] colors = {'R', 'G', 'B', 'Y', 'O', 'P'}; // Possible colors
    public String secretCode;
    private int maxGuesses;
    private int numGuesses;
    public StringBuilder previousGuesses;


    protected abstract String getID();
    protected abstract String getGuess(String previousGuesses);

    public void generateSecretCode(){ //generates the hidden color code
        Random random = new Random();
        StringBuilder code = new StringBuilder(); // create a stringbuilder called code to store the secret code
        for (int i = 0; i < codeLength; i++) {
            char color = colors[random.nextInt(0,colors.length)];
            code.append(color);
        }
        secretCode = code.toString();

    }
    @Override
    protected GameRecord play() {
        maxGuesses = 16;
        numGuesses = 0;
        previousGuesses = new StringBuilder();
        Boolean found = false; // initialize a boolean for if the player guessed correctly
        String playerIDinput = getID();
        GameRecord aGameRecord = new GameRecord(0, playerIDinput); // enter playerID and initialize the score as 0;
        generateSecretCode();

        // first, prompt the user with the instructions of the game:
        System.out.println("The secret code is a string composed of four colors from the following list: Red, Green, Blue, Yellow, Orange, Purple");
        System.out.println("the goal is to guess the secret code correctly, which will be represented as a string of 4 capital letters representing each color (R, G, B, Y, O, P)");
        // should ask the user to guess a string of 4 colors in the order they think is correct
        // return how many correct and how many partially correct
        // score is the max guesses - the number of tries it took for them to guess correctly

        while (numGuesses<maxGuesses && !found){
            System.out.println("enter a 4 letter guess (R, G, B, Y, O, P): ");
            String guess = getGuess(previousGuesses.toString());
            int partiallyCorrect = 0;
            int correct=0;
            for (int i = 0; i<guess.length(); i++){
                if (secretCode.indexOf(guess.charAt(i)) != -1){ // if the character of the guess is in the secret code
                    partiallyCorrect++;
                }
                if (guess.charAt(i) == secretCode.charAt(i)){
                    correct ++;
                }
                // need to find fully correct and then the partially correct will be partially correct - fully correct
                if(correct == 4){ //if all 4 guesses correct
                    System.out.println("Congrats, you guessed the secret code!");
                    found = true;
                }
            }
            partiallyCorrect = partiallyCorrect-correct;
            numGuesses++;
            System.out.println(correct + " exact, "+ partiallyCorrect +" partial. You have "+ (maxGuesses-numGuesses) + " guesses left.");

        }
        if (numGuesses == maxGuesses){
            System.out.println("the game is over. you have reached the max guesses. The secret code was " +secretCode );
        }
        int score = maxGuesses - numGuesses;
        aGameRecord.score = score;
        return aGameRecord;
    }

}
