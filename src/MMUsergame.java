import java.util.Scanner;

public class MMUsergame extends Mastermind{
    @Override
    protected String getGuess(String previousGuesses) {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase(); // convert the input to uppercase
    }

    @Override
    public String getID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your player ID: ");
        return scanner.nextLine();
    }

    @Override
    protected Boolean playNext() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play another game? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes"); // if player enters "yes", it returns true;
    }

    public static void main(String [] args) {
        MMUsergame wofUserGame = new MMUsergame();
        AllGamesRecord record2 = wofUserGame.playAll();
        System.out.println(record2);  // or call specific functions of record
    }
}
