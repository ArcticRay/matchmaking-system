package com.arcticray.matchmaking_system.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MMRServiceTest {

    private final MMRService mmrService = new MMRService();

    @Test
    public void testCalculateMMR() {
        int newMMRWin = mmrService.calculateMMR(1200, true, 1250);
        int newMMRLoss = mmrService.calculateMMR(1200, false, 1250);

        assertEquals(1216, newMMRWin);
        assertEquals(1184, newMMRLoss);
    }
}