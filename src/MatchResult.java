public class MatchResult {
    private final String player1Name;
    private final String player2Name;
    private final int player1Score;
    private final int player2Score;
    private final String winnerName;

    public MatchResult(String player1Name, String player2Name, int player1Score, int player2Score, String winnerName) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.winnerName = winnerName;
    }

    public String getFormattedResult() {
        return String.format("%-15s %d - %d %-15s Winner: %s",
                player1Name, player1Score, player2Score, player2Name, winnerName);
    }
}
