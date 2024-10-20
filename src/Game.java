public class Game {
    private final Player player1;
    private final Player player2;
    private int player1Score;
    private int player2Score;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setScores(int score1, int score2) {
        this.player1Score = score1;
        this.player2Score = score2;
    }

    public String getScore() {
        return player1.getName() + ": " + player1Score + " vs " +
                player2.getName() + ": " + player2Score;
    }
}
