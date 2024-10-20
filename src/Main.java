public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        int numPlayers = Tournament.getNumberOfPlayers();
        for (int i = 1; i <= numPlayers; i++) {
            Player player = new Player("Player " + i, (int) (Math.random() * 10), (int) (Math.random() * 10));
            tournament.addPlayer(player);
        }

        tournament.startTournament();
    }
}
