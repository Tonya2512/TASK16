package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player igor = new Player(1, "Игорь", 150);
        Player ivan = new Player(2, "Иван", 140);
        Game game = new Game();

        game.register(ivan);
        game.register(igor);
        int actual = game.round("Игорь", "Иван");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player igor = new Player(1, "Игорь", 150);
        Player ivan = new Player(2, "Иван", 140);
        Game game = new Game();

        game.register(ivan);
        game.register(igor);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Егор", "Иван")
        );
    }

        @Test
        public void testWhenSecondPlayerNotExist() {
            Player igor = new Player(1, "Игорь", 150);
            Player ivan = new Player(2, "Иван", 140);
            Game game = new Game();

            game.register(ivan);
            game.register(igor);

            Assertions.assertThrows(NotRegisteredException.class,
                    () -> game.round("Игорь", "Илья")
            );
    }
    @Test
    public void testWhenSecondPlayerWin() {
        Player igor = new Player(1, "Игорь", 100);
        Player ivan = new Player(2, "Иван", 190);
        Game game = new Game();

        game.register(ivan);
        game.register(igor);
        int actual = game.round("Игорь", "Иван");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenBothPlayersWin() {
        Player igor = new Player(1, "Игорь", 190);
        Player ivan = new Player(2, "Иван", 190);
        Game game = new Game();

        game.register(ivan);
        game.register(igor);
        int actual = game.round("Игорь", "Иван");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}
