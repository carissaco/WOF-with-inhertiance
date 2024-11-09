import java.util.ArrayList;

public class AllGamesRecord {
    private ArrayList<GameRecord> gameRecordList; // make a list of GameRecord objects

    public AllGamesRecord(){ // constructor
        this.gameRecordList = new ArrayList<GameRecord>(); // create an empty list for GameRecord objects to be stored
    }
    public void add(GameRecord gameRecord){ // adds a GameRecord to the AllGamesRecord
        gameRecordList.add(gameRecord);
    }

    public double average(){ // returns average score for all games added to the record
        double sum = 0;
        if (gameRecordList.isEmpty()){
            return 0; // returns 0 if the gameRecordList is empty
        }
        for (int i = 0; i<gameRecordList.size(); i++){
            sum += gameRecordList.get(i).score;
        }
        double average = sum/gameRecordList.size();
        return average;
    }

    public int average(String playerID){ // returns the average score for all games of a particular player

    }
    public List[] highGameList(int n) {

    }

    public highGameList(String playerID, int n)
}
