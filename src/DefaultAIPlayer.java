public class DefaultAIPlayer implements WheelOfFortunePlayer{

    @Override
    public char nextGuess(){
        return 'a';
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
