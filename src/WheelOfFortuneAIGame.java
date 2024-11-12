public class WheelOfFortuneAIGame extends WheelOfFortune{

//    public WheelOfFortuneAIGame(){ // constructor to set the WOFPlayer to a default player
//
//    }
//
//    public WheelOfFortuneAIGame(){ // constructor to allow the client to specify a single concrete WOFPlayer
//
//    }
//    public WheelOfFortuneAIGame(){ // constructor to accept a list of WOF players
//
//    }


    @Override
    protected char getGuess(String previousGuesses){ //
        return 0;

    }

    @Override
    protected Boolean playNext(){ // need a different method to just play the games automatically instead of prompting the user
        return true;
    }
// in the main, should create at least 3 different players, then call playAll() to run through all the phrases for each player
}
