package ru.netology.javaqa.GameTournament.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestGame {


    @Test

    public void testWinnerPlayer1()  {
        Game game = new Game();
        Player player1 = new Player(5, "Сергей", 50);
        Player player2 = new Player(10, "Иван", 30);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Сергей", "Иван");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testWinnerPlayer2()  {
        Game game = new Game();
        Player player1 = new Player(5, "Сергей", 50);
        Player player2 = new Player(10, "Иван", 100);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Сергей", "Иван");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testDeadHeat()  {
        Game game = new Game();
        Player player1 = new Player(5, "Сергей", 50);
        Player player2 = new Player(10, "Иван", 50);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Сергей", "Иван");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }


    @Test

    public void testPlayer1NotExist()  {
        Game game = new Game();
        Player player1 = new Player(5, "Сергей", 50);
        Player player2 = new Player(10, "Иван", 30);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Света", "Иван");
        });
    }

    @Test

    public void testPlayer2NotExist()  {
        Game game = new Game();
        Player player1 = new Player(5, "Сергей", 50);
        Player player2 = new Player(10, "Иван", 30);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Сергей", "Саша");
        });
    }

    @Test

    public void testPlayersNotExist()  {
        Game game = new Game();
        Player player1 = new Player(5, "Сергей", 50);
        Player player2 = new Player(10, "Иван", 30);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Света", "Саша");
        });
    }


}

