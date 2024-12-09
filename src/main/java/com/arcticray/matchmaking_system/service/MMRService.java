package com.arcticray.matchmaking_system.service;

import org.springframework.stereotype.Service;

@Service
public class MMRService {

    public int calculateMMR(int teamMMR, boolean isWin, int opponentMMRSum) {
        int kFactor = 32; // weight
        double expectedScore = 1 / (1 + Math.pow(10, (opponentMMRSum - teamMMR) / 2000.0));
        return isWin
                ? (int) (teamMMR + kFactor * (1 - expectedScore))
                : (int) (teamMMR - kFactor * expectedScore);
    }
}
