package oliveira;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//GSON Serialize and Deserialize article
//source: https://howtodoinjava.com/gson/gson-serialize-deserialize-json/
//
//Reading and Writing to a File using java.nio.file.Files/Path
//source: https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//source: https://howtodoinjava.com/java/io/java-write-to-file/
//

public class Game {

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    Player player;

    public Game(Player player)
    {
        this.player = player;
    }

    //pass the error to who is calling the function
    public String saveGame() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(this.player);

        String pathToSave = "player1.json";

        try {
            Files.write(Paths.get(pathToSave), jsonString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    public static Game loadGame(String fileName)
    {
        String jsonString = "";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //handle the exception
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Player playerFromJson = gson.fromJson(jsonString, Player.class);

        return new Game(playerFromJson);
    }
}
