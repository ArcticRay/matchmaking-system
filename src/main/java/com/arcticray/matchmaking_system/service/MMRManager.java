package com.arcticray.matchmaking_system.service;

import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.repository.PlayerRepository;
import com.arcticray.matchmaking_system.util.RankManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MMRManager {

    private final MMRService mmrService;
    private final PlayerRepository playerRepository;

    @Autowired
    public MMRManager(MMRService mmrService, PlayerRepository playerRepository) {
        this.mmrService = mmrService;
        this.playerRepository = playerRepository;
    }

    public void updatePlayerMMR(Player player, boolean isWin, int opponentMMR) {
        // Use MMRService to calculate new MMR
        int newMMR = mmrService.calculateMMR(player.getMmr(), isWin, opponentMMR);
        player.setMmr(newMMR);

        // Update wins/losses
        if (isWin) {
            player.setWins(player.getWins() + 1);
        } else {
            player.setLosses(player.getLosses() + 1);
        }

        // Update rank
        updatePlayerRank(player);

        // Save changes to the repository
        playerRepository.save(player);
    }

    public void updatePlayerRank(Player player) {
        String newRank = RankManager.getRankForMMR(player.getMmr());

        if (!newRank.equals(player.getRank())) {
            player.setRank(newRank);
        }
    }
}
