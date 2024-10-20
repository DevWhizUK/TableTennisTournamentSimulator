import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tournament {
    private final List<Player> players = new ArrayList<>();
    private final List<MatchResult> matchResults = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startTournament() {
        System.out.println("Tournament starting with " + players.size() + " players.");
        List<Player> currentPlayers = new ArrayList<>(players);

        while (currentPlayers.size() > 1) {
            currentPlayers = playRound(currentPlayers);
        }

        System.out.println("The champion is: " + currentPlayers.get(0).getName() + "!");
        displayResultsTable();
    }

    private List<Player> playRound(List<Player> currentPlayers) {
        List<Player> winners = new ArrayList<>();
        System.out.println("\nStarting a new round...");

        for (int i = 0; i < currentPlayers.size(); i += 2) {
            Player player1 = currentPlayers.get(i);
            Player player2 = currentPlayers.get(i + 1);

            Match match = new Match(player1, player2);
            MatchResult result = match.playMatch();
            matchResults.add(result);

            winners.add((result.getFormattedResult().contains(player1.getName())) ? player1 : player2);
        }
        return winners;
    }

    private void displayResultsTable() {
        System.out.println("\nTournament Results:");
        System.out.println("==============================================");
        System.out.println("Player 1        Score  Player 2        Winner");
        System.out.println("==============================================");

        for (MatchResult result : matchResults) {
            System.out.println(result.getFormattedResult());
        }
    }

    public static int getNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;

        while (numberOfPlayers < 2 || (numberOfPlayers & (numberOfPlayers - 1)) != 0) {
            System.out.print("Enter number of players (power of 2): ");
            try {
                numberOfPlayers = scanner.nextInt();
                if (numberOfPlayers < 2) {
                    System.out.println("Please enter a number greater than or equal to 2.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return numberOfPlayers;
    }
}
