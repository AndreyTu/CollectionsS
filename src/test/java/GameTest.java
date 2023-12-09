import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    Player player1 = new Player(1, "Олег", 60);
    Player player2 = new Player(2, "Иван", 88);
    Player player3 = new Player(3, "Сергей", 60);
    Player player4 = new Player(4, "Егор", 40);
    Player player5 = new Player(5, "Александр", 60);
    Player player6 = new Player(6, "Михаил", 40);


    @Test
    public void testNotRegistered() {
        Game game = new Game();
        game.register(player4);
        game.register(player2);
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Олег", "Сергей");
        });
    }

    @Test
    public void testNotRegisteredFirst() {
        Game game = new Game();
        game.register(player4);
        game.register(player2);
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Олег", "Егор");
        });
    }

    @Test
    public void testNotRegisteredSecond() {
        Game game = new Game();
        game.register(player1);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Егор", "Иван");
        });
    }

    @Test
    public void testRegisteredFirstWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player4);

        int expected = 1;
        int actual = game.round("Олег", "Егор");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRegisteredSecondWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Олег", "Иван");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRegisteredNobodyWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Олег", "Сергей");

        Assertions.assertEquals(expected, actual);
    }
}