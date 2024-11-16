import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// need to make it so it gives a different phrase each time?
// end the game properly -- print out the correct phrase at the end

public abstract class WheelOfFortune extends Game{ // should have a lot of code from original WOF project
    // define data members
    public String phrase;
    public StringBuilder hiddenPhrase;
    public StringBuilder previousGuesses;
    public int numGuesses;
    public int maxGuesses;
    public List<String> phraseList;


    // Abstract method to get a guess from user or AI
    // we are making it protected because it is only supposed to be used and overridden by subclasses of WheelOfFortune
    protected abstract char getGuess(String previousGuesses); // when we define the method in the WOFuser and WOF AI, this should return a char

    protected abstract String getID(); // making an abstract method for getID because this will be different for the WOF user game vs the AI game

    // Constructor to load phrases when the game object is created -- this ensures that we start with a certain number of phrases each time we create a new WOF object
    public WheelOfFortune() {
        loadPhrases();
    }

    // load phrases from file into the phrase list
    public void loadPhrases() {
        try {
            phraseList = new ArrayList<>(Files.readAllLines(Paths.get("phrases.txt")));
        } catch (IOException e) {
            System.out.println(e);
            phraseList = new ArrayList<>();  // initialize empty list if loading fails
        }
    }


    public void generatePhrase(){ // gets a random phrase from the phrases.txt file
        // Get a random phrase and remove it from the list
        Random rand = new Random();
        int randomIndex = rand.nextInt(phraseList.size());
        this.phrase = phraseList.get(randomIndex);
        phraseList.remove(randomIndex);

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
        generatePhrase();
        generateHiddenPhrase();
        maxGuesses = 16;
        numGuesses = 0;
        previousGuesses = new StringBuilder();

        // maybe before playing, prompt the user to enter their ID, then store this into the GameRecord?

        String playerIDinput = getID();

        // when we play a game, we should create a GameRecord
        GameRecord aGameRecord = new GameRecord(0, playerIDinput); // enter playerID and initialize the score as 0;

        while (numGuesses < maxGuesses && hiddenPhrase.indexOf("*") != -1){ //need to notify player if they guessed something previously guessed
            System.out.println("Hidden Phrase: " + hiddenPhrase);
            System.out.println("Previous Guesses: " + previousGuesses);

            char guess = getGuess(previousGuesses.toString()); // use getguess to return the char guess // convert the previousGuesses to string because it is initialized as a StringBuilder

            if (previousGuesses.indexOf(String.valueOf(guess)) == -1) { // Check if the guess is already made
                previousGuesses.append(guess); // Append only the lowercase guess

                boolean correctGuess = processGuess(guess);
                if (guess >= 'A' && guess <= 'Z' || guess >= 'a' && guess <= 'z') { // increase numGuesses if the guess was a letter
                    numGuesses++;
                }
                if (correctGuess){
                    System.out.println("Correct guess. you have " + (maxGuesses-numGuesses) + " guesses left");

                } else{
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

    // make a processGuess method to process the player's guess and update the hidden phrase if correct
    private boolean processGuess(char guess) {
        boolean found = false;
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (Character.toLowerCase(c) == Character.toLowerCase(guess)) {
                hiddenPhrase.setCharAt(i, c);
                found = true;
            }
        }
        return found;
    }

    @Override // defining abstract method for Game's playNext()
    protected Boolean playNext() { // maybe prompt the user and ask them if they wanna play another game, then if they say yes return true
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play another game? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes"); // if player enters "yes", it returns true
    }
}
