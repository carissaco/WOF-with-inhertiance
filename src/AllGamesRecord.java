import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AllGamesRecord {
    public ArrayList<GameRecord> gameRecordList; // make a list of GameRecord objects

    public AllGamesRecord(){ // constructor
        this.gameRecordList = new ArrayList<>(); // create an empty list for GameRecord objects to be stored
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

    public double average(String playerID){ // returns the average score for all games of a particular player
        double sum = 0;
        int size = 0;
        if (gameRecordList.isEmpty()) {
            return 0; // returns 0 if the gameRecordList is empty
        }
        for (int i = 0; i<gameRecordList.size(); i++){
            if (gameRecordList.get(i).playerID.equals(playerID)){
                sum += gameRecordList.get(i).score;
                size++;
                }
            }
        double average = sum/size;
        return average;
    }


    public ArrayList<GameRecord> highGameList(int n) { //returns a sorted list of the top n scores including player and score
        ArrayList<GameRecord> sortedList = new ArrayList<>(gameRecordList);
        sortedList.sort(Collections.reverseOrder()); // Sort in descending order
        return new ArrayList<>(sortedList.subList(0, Math.min(n, sortedList.size()))); // Create a new ArrayList from the sublist
    }

    public ArrayList<GameRecord> highGameList(String playerID, int n){ //returns a sorted list of the top n scores for the specified player.
        ArrayList<GameRecord> playerList = new ArrayList<>();
        for (int i = 0; i< gameRecordList.size(); i++ ){ // first get all the gamerecords with the specified playerID and add them to the playerList
            if (gameRecordList.get(i).playerID.equals(playerID)){
                playerList.add(gameRecordList.get(i));
            }
        }
        playerList.sort(Collections.reverseOrder());
        return (ArrayList<GameRecord>) playerList.subList(0, n);
    }

    @Override
    public String toString() {
        // Get the average score
        double avgScore = average();

        // Get the top 2 games
        ArrayList<GameRecord> topGames = highGameList(2);

        // Build a string representation
        StringBuilder result = new StringBuilder("AllGamesRecord:\n");
        // result.append("gameRecordList=" + gameRecordList + "}");
        result.append("Average Score: ").append(avgScore).append("\n");
        result.append("Top 2 Games:\n");

        for (GameRecord record : topGames) {
            result.append(record).append("\n"); // Assuming GameRecord has a meaningful toString() method
        }

        return result.toString();
    }

}
