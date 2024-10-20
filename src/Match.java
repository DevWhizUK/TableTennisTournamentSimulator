import java.util.Random;

public class Match {
    private final Player player1;
    private final Player player2;
    private final Random random = new Random();

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public MatchResult playMatch() {
        int player1Score = 0;
        int player2Score = 0;

        System.out.println("\nMatch between " + player1.getName() + " and " + player2.getName());

        while (!isWinningScore(player1Score, player2Score)) {
            player1Score += random.nextInt(2);
            player2Score += random.nextInt(2);

            System.out.println(player1.getName() + " scored: " + player1Score);
            System.out.println(player2.getName() + " scored: " + player2Score);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Player winner = (player1Score > player2Score) ? player1 : player2;
        System.out.println("Winner: " + winner.getName());

        return new MatchResult(player1.getName(), player2.getName(), player1Score, player2Score, winner.getName());
    }

    private boolean isWinningScore(int score1, int score2) {
        return (score1 >= 11 || score2 >= 11) && Math.abs(score1 - score2) >= 2;
    }
}
