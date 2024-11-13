import java.util.ArrayList;
import java.util.List;

public class WheelOfFortuneAIGame extends WheelOfFortune{
    private List<WheelOfFortunePlayer> players; // list of ai players
    private int currentPlayerIndex = 0;  // track which player is currently playing

    public WheelOfFortuneAIGame(){ // constructor to set the WOFPlayer to a default player
    // basically I choose what is the default player

        this.players = new ArrayList<>();
        this.players.add(new DefaultAIPlayer());  // DefaultAIPlayer is a subclass of WheelOfFortunePlayer .. the default AI player will have a data member for playerID
        loadPhrases(); // not sure if i have to do this ... maybe i do in this case bc every time we go through a player, we need to load the phrases again?


    }

    public WheelOfFortuneAIGame(WheelOfFortunePlayer player){ // constructor to allow the client to specify a single concrete WOFPlayer
    // client can choose a WOF ai player to play the game
    }
    public WheelOfFortuneAIGame(List<WheelOfFortunePlayer> players){ // constructor to accept a list of WOF players
    // can have multiple players playing the game

    }

    @Override
    public String getID(){
        return players.get(currentPlayerIndex).playerId();
    }

    @Override
    protected char getGuess(String previousGuesses){ //
        return 0;

    }

    @Override
    protected GameRecord play() {
        return super.play();
    }

    @Override
    protected Boolean playNext(){ // need a different method to just play the games automatically instead of prompting the user
        return true; // should always say yes to playing next game
    }
// in the main, should create at least 3 different players, then call playAll() to run through all the phrases for each player
public static void main(String[] args) {
    // Using default constructor
    WheelOfFortuneAIGame aiGame = new WheelOfFortuneAIGame();
    AllGamesRecord record = aiGame.playAll();
    System.out.println(record);
    }
}
