import java.util.random.RandomGenerator;

public class Dice {
    public static int rollDice() {
        return RandomGenerator.getDefault().nextInt(1, 7);
    }
}
