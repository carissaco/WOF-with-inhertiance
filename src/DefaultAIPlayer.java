import java.util.Random;

public class DefaultAIPlayer implements WheelOfFortunePlayer{

    @Override
    public char nextGuess(){ // start with just guessing random letters
        Random random = new Random();
        int randomInt = random.nextInt('z' - 'a' + 1); // generate a random integer correlating to ascii values btwn a and z
        return (char) ('a' + randomInt);

    }

    @Override
    public String playerId(){
        return "Default AI Player";

    }

    @Override
    public void reset(){
        // idk if i need this???
    }

}
