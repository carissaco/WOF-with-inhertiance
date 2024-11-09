public class GameRecord implements Comparable<GameRecord>{ //
    int score;
    public String playerID;
    // each GameRecord object will have a score and a playerID

    public GameRecord(int score, String playerID){ //constructor
        this.score = score;
        this.playerID = playerID;
    }

    @Override
    public int compareTo(GameRecord other) {
        return Integer.compare(this.score, other.score); // Integer.compare is a built-in record that compares two int values.
            // Integer.compare will return a positive integer if this score is higher, negative if it is less, zero if they are equal
    }

    @Override
    public String toString() { // this is what will print out if you print a GameRecord object
        return "GameRecord{playerId='" + playerID + "', score=" + score + "}";
    }
}
