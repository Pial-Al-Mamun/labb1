import java.util.Scanner;

public class Main {
    private static String readNonBlank(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            var input = scanner.nextLine().trim();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println("Input can't be blank, try again.");
        }
    }

    private static Player readPlayer(Scanner scanner, String label) {
        var first = readNonBlank(scanner, label + " first name: ");
        var last  = readNonBlank(scanner, label + " last name: ");
        return new Player(first, last);
    }

    private static void printScores(Player p1, Player p2) {
        System.out.println(p1.getFullName() + " scored: " + p1.getScore());
        System.out.println(p2.getFullName() + " scored: " + p2.getScore());
    }

    private static void announceWinner(Player p1, Player p2) {
        switch (Integer.compare(p1.getScore(), p2.getScore())) {
            case 1  -> System.out.println("Winner: " + p1.getFullName());
            case -1 -> System.out.println("Winner: " + p2.getFullName());
            default -> System.out.println("It's a draw!");
        }
    }

    private static int readRoundCount(Scanner scanner) {
        while (true) {
            System.out.print("How many rounds? ");
            var input = scanner.nextLine().trim();

            int rounds;
            try {
                rounds = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
                continue;
            }

            if (rounds > 0) {
                return rounds;
            }
            System.out.println("Number of rounds must be greater than 0.");
        }
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var p1 = readPlayer(scanner, "Player 1");
        var p2 = readPlayer(scanner, "Player 2");

        var game = new Game(p1, p2);

        var rounds = readRoundCount(scanner);

        for (var counter = 0; counter < rounds; counter++) {
            game.playRound();
        }

        printScores(p1, p2);
        announceWinner(p1, p2);

        scanner.close();
    }
}
