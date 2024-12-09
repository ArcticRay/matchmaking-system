package com.arcticray.matchmaking_system;


import com.arcticray.matchmaking_system.matchmaker.Game;
import com.arcticray.matchmaking_system.matchmaker.GameMatchmaker;
import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.queue.PlayerQueue;

public class Main {

    public static void main(String[] args) {
        PlayerQueue queue = new PlayerQueue();

        // Add 20 players
        queue.addPlayer(new Player("Player1", 800, "Bronze 4", "EUW", "Top", "Jungle"));
        queue.addPlayer(new Player("Player2", 1200, "Silver 3", "EUW", "Mid", "ADC"));
        queue.addPlayer(new Player("Player3", 2000, "Platinum 4", "NA", "ADC", "Support"));
        queue.addPlayer(new Player("Player4", 1600, "Gold 4", "EUW", "Jungle", "Top"));
        queue.addPlayer(new Player("Player5", 2400, "Platinum 2", "EUW", "Support", "Mid"));
        queue.addPlayer(new Player("Player6", 1000, "Silver 4", "EUW", "ADC", "Support"));
        queue.addPlayer(new Player("Player7", 1500, "Gold 1", "NA", "Mid", "Jungle"));
        queue.addPlayer(new Player("Player8", 3200, "Diamond 3", "EUW", "Top", "Mid"));
        queue.addPlayer(new Player("Player9", 400, "Bronze 2", "EUW", "Jungle", "ADC"));
        queue.addPlayer(new Player("Player10", 500, "Bronze 3", "EUW", "Top", "Support"));
        queue.addPlayer(new Player("Player11", 900, "Silver 4", "EUW", "Support", "Jungle"));
        queue.addPlayer(new Player("Player12", 2200, "Platinum 1", "EUW", "ADC", "Top"));
        queue.addPlayer(new Player("Player13", 2500, "Diamond 4", "EUW", "Mid", "Support"));
        queue.addPlayer(new Player("Player14", 1300, "Silver 2", "EUW", "Jungle", "ADC"));
        queue.addPlayer(new Player("Player15", 200, "Bronze 1", "EUW", "Top", "Mid"));
        queue.addPlayer(new Player("Player16", 3200, "Diamond 3", "NA", "ADC", "Support"));
        queue.addPlayer(new Player("Player17", 1800, "Gold 2", "EUW", "Mid", "Top"));
        queue.addPlayer(new Player("Player18", 4000, "Master", "EUW", "Jungle", "ADC"));
        queue.addPlayer(new Player("Player19", 1000, "Silver 4", "NA", "Support", "Mid"));
        queue.addPlayer(new Player("Player20", 800, "Bronze 4", "EUW", "ADC", "Jungle"));

        GameMatchmaker matchmaker = new GameMatchmaker();
        Game game = matchmaker.createGame(queue);

        game.printGameDetails();
    }
}
