package com.arcticray.matchmaking_system.util;

import com.arcticray.matchmaking_system.matchmaker.Matchmaking;
import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.queue.PlayerQueue;
import com.arcticray.matchmaking_system.service.RoleManager;

public class StartGame {

    Matchmaking matchmaking = new Matchmaking();

    PlayerQueue playerQueue = matchmaking.playerQueue;

    public void startGame() {
        playerQueue.add(new Player("ArcticRay", 1200, "EUW", RoleManager.Role.ADC, RoleManager.Role.MID));
        playerQueue.add(new Player("Player1", 2000, "EUW", RoleManager.Role.TOP, RoleManager.Role.MID));
        playerQueue.add(new Player("Player2", 2100, "EUW", RoleManager.Role.MID, RoleManager.Role.TOP));
        playerQueue.add(new Player("Player3", 1450, "EUW", RoleManager.Role.JUNGLE, RoleManager.Role.SUPPORT));
        playerQueue.add(new Player("Player4", 1200, "EUW", RoleManager.Role.ADC, RoleManager.Role.SUPPORT));
        playerQueue.add(new Player("Player5", 1100, "EUW", RoleManager.Role.SUPPORT, RoleManager.Role.MID));
        playerQueue.add(new Player("Player6", 1300, "EUW", RoleManager.Role.TOP, RoleManager.Role.MID));
        playerQueue.add(new Player("Player7", 1300, "EUW", RoleManager.Role.JUNGLE, RoleManager.Role.TOP));
        playerQueue.add(new Player("Player8", 1500, "EUW", RoleManager.Role.MID, RoleManager.Role.TOP));
        playerQueue.add(new Player("Player9", 1400, "EUW", RoleManager.Role.ADC, RoleManager.Role.TOP));
        playerQueue.add(new Player("Player10", 1450, "EUW", RoleManager.Role.SUPPORT, RoleManager.Role.JUNGLE));
        playerQueue.add(new Player("Player11", 1200, "EUW", RoleManager.Role.TOP, RoleManager.Role.MID));

        playerQueue.printQueue();
    }
}
