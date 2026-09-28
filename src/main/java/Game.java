import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Game {
    private final Player p1;
    private final Player p2;


    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    private static int rollDice() {
        return RandomGenerator.getDefault().nextInt(1, 7);
    }

    private void playTurn(Player player) {
        System.out.println();
        System.out.println(player.getFullName() + "'s turn:");

        for (var i = 0; i < 2; i++) {
            var roll = rollDice();
            player.addToScore(roll);
            System.out.println("   Roll " + (i + 1) + ": " + roll);
        }

        System.out.println("   Total so far: " + player.getScore());
        System.out.println("\n");
    }

    public void playRound() {
        playTurn(p1);
        playTurn(p2);
        System.out.println(p1.getFullName() + " scored: " + p1.getScore());
        System.out.println(p2.getFullName() + " scored: " + p2.getScore());

    }
    public void announceWinner() {
        switch (Integer.compare(p1.getScore(), p2.getScore())) {
            case 1  -> System.out.println("Winner: " + p1.getFullName());
            case -1 -> System.out.println("Winner: " + p2.getFullName());
            default -> System.out.println("It's a draw!");
        }
    }
}
