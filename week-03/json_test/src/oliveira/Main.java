package oliveira;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Nephi", 100, 80, 1000);
        Game game = new Game(player1);

        String jsonContent = game.saveGame();

        Game gameFromJson = Game.loadGame(jsonContent);

        System.out.println("Player:");
        System.out.println(game.getPlayer().toString());

        System.out.println("\nPlayer for Json File:\n");
        System.out.println(gameFromJson.getPlayer().toString());

    }
}
