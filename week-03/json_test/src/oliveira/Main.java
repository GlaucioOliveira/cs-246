package oliveira;

public class Main {

    public static void main(String[] args)
    {

        Player player1 = new Player("Nephi", 100, 80, 1000);

        player1.addEquipment("Sword", 1000);
        player1.addEquipment("Shield", 500);

        Game game = new Game(player1);

        String jsonContent = game.saveGame();

        Game gameFromJson = Game.loadGame("player1.json");

        printPlayers(game, gameFromJson);
    }

    public static void printPlayers(Game game1, Game game2)
    {
        System.out.println("Player:");
        System.out.println(game1.getPlayer().toString());

        System.out.println("\nPlayer for Json File:\n");
        System.out.println(game2.getPlayer().toString());
    }
}
