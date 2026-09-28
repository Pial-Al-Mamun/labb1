import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Game {

    private static int rollDice() {
        return RandomGenerator.getDefault().nextInt(1, 7);
    }

    private static void playTurn(Player player) {
        System.out.println();
        System.out.println(player.getFullName() + "'s turn:");

        for (var i = 0; i < 2; i++) {
            var roll = rollDice();
            player.addToScore(roll);
            System.out.println("   Roll " + (i + 1) + ": " + roll);
        }

        System.out.println("   Total so far: " + player.getScore());
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Player 1 first name: ");
        var first1 = scanner.nextLine();
        System.out.print("Player 1 last name: ");
        var last1 = scanner.nextLine();
        var p1 = new Player(first1, last1);

        System.out.print("Player 2 first name: ");
        var first2 = scanner.nextLine();
        System.out.print("Player 2 last name: ");
        var last2 = scanner.nextLine();
        var p2 = new Player(first2, last2);

        playTurn(p1);
        playTurn(p2);

        System.out.println(p1.getFullName() + " scored: " + p1.getScore());
        System.out.println(p2.getFullName() + " scored: " + p2.getScore());

        switch (Integer.compare(p1.getScore(), p2.getScore())) {
            case 1  -> System.out.println("Winner: " + p1.getFullName());
            case -1 -> System.out.println("Winner: " + p2.getFullName());
            default -> System.out.println("It's a draw!");
        }

        scanner.close();
    }
}
