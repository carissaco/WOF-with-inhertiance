import java.util.Scanner;

public class WheelOfFortuneUserGame extends WheelOfFortune{

    // Override the abstract getGuess method to get the user's guess via Scanner input
    @Override
    protected char getGuess(String previousGuesses){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character guess: ");
        String input = scanner.nextLine().toLowerCase().trim();
        return input.charAt(0); // convert the input to a char and return it
    }
    public static void main(String [] args) {
        WheelOfFortuneUserGame wofUserGame = new WheelOfFortuneUserGame();
        AllGamesRecord record = wofUserGame.playAll();
        System.out.println(record);  // or call specific functions of record
    }
}


