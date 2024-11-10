import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class WheelOfFortune extends Game{ // should have a lot of code from original WOF project
    // define data members
    public String phrase;
    public StringBuilder hiddenPhrase;
    public StringBuilder previousGuesses;
    public int numGuesses;
    public int maxGuesses;

    public void generatePhrase(){ // gets a random phrase from the phrases.txt file
        List<String> phraseList=null;
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Get a random phrase from the list
        Random rand = new Random();
        int r= rand.nextInt(3); // gets 0, 1, or 2
        this.phrase = phraseList.get(r);

    }

    public void generateHiddenPhrase(){
        this.hiddenPhrase = new StringBuilder(phrase);
        for (int i = 0; i<phrase.length(); i++){
            char c = phrase.charAt(i);
            if (c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A' ) // if c is a letter
            {
                hiddenPhrase.setCharAt(i, '*');
            }
            if (c == ' ')
            {
                hiddenPhrase.setCharAt(i, ' ');
            }

        }

    }

    // will have abstract method getGuess(String previousGuesses), which returns a char based on whether we are implementing the user game or AI game


    @Override // defining abstract method for Game's play()
    protected GameRecord play() {

        maxGuesses = 16;
        numGuesses = 0;
        previousGuesses = new StringBuilder();
        // maybe before playing, prompt the user to enter their ID, then store this into the GameRecord?
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your player ID: ");
        String playerIDinput = scanner.nextLine();

        // when we play a game, we should create a GameRecord
        GameRecord aGameRecord = new GameRecord(0, playerIDinput); // enter playerID and initialize the score as 0;

        while (numGuesses < maxGuesses && hiddenPhrase.indexOf("*") != -1){ //need to notify player if they guessed something previously guessed
            System.out.println("enter a character guess: ");
            String input = scanner.nextLine().toLowerCase(); //scanner.nextLine takes the next line as a string

            char guess = input.charAt(0); // convert the string input into a char called guess

            if (previousGuesses.indexOf(String.valueOf(guess)) == -1) { // Check if the guess is already made
                previousGuesses.append(guess); // Append only the lowercase guess

                // Convert the phrase to lowercase for the check
                String lowercasePhrase = phrase.toLowerCase();

                // check if guess is in the hiddenPhrase
                if (lowercasePhrase.indexOf(guess) != -1){ // if the guess is in the phrase
                    for (int i = 0; i<phrase.length(); i++){ // for each character in the phrase
                        char c = phrase.charAt(i);
                        if (Character.toLowerCase(c) == guess){
                            hiddenPhrase.setCharAt(i, c);
                        }
                    }
                    numGuesses ++;
                    System.out.println("Hidden Phrase: " + hiddenPhrase);
                    System.out.println("Correct guess. you have " + (maxGuesses-numGuesses) + " guesses left");

                } else { // if guess is not in the phase
                    if (guess >= 'A' && guess <= 'Z' || guess >= 'a' && guess <= 'z') { // if the guess was a letter
                        numGuesses++;
                    }
                    System.out.println("wrong guess. you have " + (maxGuesses-numGuesses) + " guesses left");
                }


            } else {
                System.out.println("You already guessed that letter. Try a different one.");
            }

            if (numGuesses == maxGuesses && hiddenPhrase.indexOf("*") != -1 ){ // if the max guesses have been reached and * is still in the hiddenPhrase
                System.out.println("the game is over. you have reached the max guesses");
            }



        }
        int score = maxGuesses - numGuesses; // if the player guesses the word in less guesses, the score will be higher since numguesses increases every time you guess smth

        // update the gamerecord after the game is over to contain the score at the end of the game
        aGameRecord.score = score;
        return aGameRecord;


    }

    @Override // defining abstract method for Game's playNext()
    protected Boolean playNext() { // maybe prompt the user and ask them if they wanna play another game, then if they say yes return true
        return null;
    }
}
