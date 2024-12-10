package com.arcticray.matchmaking_system;


import com.arcticray.matchmaking_system.matchmaker.Game;
import com.arcticray.matchmaking_system.matchmaker.GameMatchmaker;
import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.queue.PlayerQueue;

public class Main {

    public static void main(String[] args) {
        PlayerQueue queue = new PlayerQueue();

        queue.addPlayer(new Player("Player1", 2450, "Platinum 4", "EUW", "Top", "Jungle"));

        // Add 5 Gold Player
        for (int i = 1; i <= 6; i++) {
            queue.addPlayer(new Player(
                    "GoldPlayer" + i,
                    1800 + i * 5, // Variierende MMR im Bereich Gold
                    "Gold " + (i % 4 + 1), // Division rotierend (Gold 1 bis Gold 4)
                    "EUW",
                    i % 5 == 0 ? "Support" : i % 5 == 1 ? "Top" : i % 5 == 2 ? "Mid" : i % 5 == 3 ? "Jungle" : "ADC", // Rotierende Primärrollen
                    i % 5 == 1 ? "Jungle" : i % 5 == 2 ? "ADC" : i % 5 == 3 ? "Top" : i % 5 == 4 ? "Mid" : "Support" // Rotierende Sekundärrollen
            ));
        }

        for (int i = 1; i <= 10; i++) {
            queue.addPlayer(new Player(
                    "PlatinumPlayer" + i,
                    2600 + i * 5, // Variierende MMR im Bereich Platin
                    "Platinum " + (i % 4 + 1), // Division rotierend
                    "EUW",
                    i % 5 == 0 ? "Support" : i % 5 == 1 ? "Top" : i % 5 == 2 ? "Mid" : i % 5 == 3 ? "Jungle" : "ADC", // Rotierende Primärrollen
                    i % 5 == 1 ? "Jungle" : i % 5 == 2 ? "ADC" : i % 5 == 3 ? "Top" : i % 5 == 4 ? "Mid" : "Support" // Rotierende Sekundärrollen
            ));
        }


        GameMatchmaker matchmaker = new GameMatchmaker();
        Game game = matchmaker.createBalancedGame(queue);

        game.printGameDetails();
    }
}
