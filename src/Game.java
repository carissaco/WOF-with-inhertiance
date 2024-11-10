// class Game will encapsulate the code for looping through a set of games and recording the results.
public abstract class Game { // since Game is abstract, any class that extends it will be able to use all its methods
    public AllGamesRecord playAll(){ // plays a set of games and records and returns an AllGamesRecord object
        // should continue to call play() as long as playNext() returns true
        // after a game is played, a Gamerecord should be stored in AllGamesRecord, and AllGamesRecord should be returned at the end
     AllGamesRecord allGamesRecord = new AllGamesRecord(); // when you want to play all games, you need to create an allGamesRecord first
        while (playNext()){
            GameRecord aGameRecord = play(); // create a single gameRecord and set the result to what you'd get if you play a single game
                    // why are you allowed to do this if you don't know what you're gonna put in play() yet?
                    // maybe because we made the type for play a GameRecord, so we already know that play() will return a GameRecord
            allGamesRecord.add(aGameRecord); // add the game record to all games record every time you play a game

        }
        return allGamesRecord;
    }

    protected abstract GameRecord play(); // plays a game and returns a GameRecord
        // we will define what happens/what gets added to the game record when we define play() in other classes that extend Game

    protected abstract Boolean playNext(); // asks if the next game should be played. returns true or false


}