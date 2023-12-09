import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public List<Player> register(Player player) {
        players.add(player);
        return players;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.name.equals(playerName1)) {
                player1 = player;
            }
            if (player.name.equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Element with name: " + playerName1 + " not registered");
        }

        if (player2 == null) {
            throw new NotRegisteredException("Element with name: " + playerName2 + " not registered");
        }


        if (player1.strength > player2.strength) {
            return 1;
        }
        if (player1.strength < player2.strength) {
            return 2;
        } else {
            return 0;
        }

    }

}