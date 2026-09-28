public class Player {

    private final String firstName;
    private final String lastName;
    private int score;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = 0;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public int getScore() {
        return score;
    }
}
