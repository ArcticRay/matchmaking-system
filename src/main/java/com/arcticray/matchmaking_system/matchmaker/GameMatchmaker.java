package com.arcticray.matchmaking_system.matchmaker;

import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.queue.PlayerQueue;
import java.util.ArrayList;
import java.util.List;

public class GameMatchmaker {

    public Game createGame(PlayerQueue queue) {
        List<Player> team1 = new ArrayList<>();
        List<Player> team2 = new ArrayList<>();

        while (!queue.isEmpty()) {
            if (team1.size() < 5) {
                team1.add(queue.getNextPlayer());
            } else if (team2.size() < 5) {
                team2.add(queue.getNextPlayer());
            } else {
                break;
            }
        }

        return new Game(team1, team2);
    }
}
