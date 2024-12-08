package com.arcticray.matchmaking_system.service;

import org.springframework.stereotype.Service;

@Service
public class MMRService {

    public int calculateMMR(int currentMMR, boolean isWin, int opponentMMR) {
        int kFactor = 32; // influence factor
        double expectedScore = 1 / (1 + Math.pow(10, (opponentMMR - currentMMR) / 400.0));
        return isWin ? (int) (currentMMR + kFactor * (1 - expectedScore))
                : (int) (currentMMR - kFactor * expectedScore);
    }
}
