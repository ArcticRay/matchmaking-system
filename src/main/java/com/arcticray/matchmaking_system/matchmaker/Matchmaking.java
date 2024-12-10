package com.arcticray.matchmaking_system.matchmaker;

import com.arcticray.matchmaking_system.queue.PlayerQueue;

public class Matchmaking {

    public PlayerQueue playerQueue;

    public Matchmaking() {
        playerQueue = new PlayerQueue();
    }
    

    public Game createGame() {
        Game game = new Game();




        return game;
    }
}
