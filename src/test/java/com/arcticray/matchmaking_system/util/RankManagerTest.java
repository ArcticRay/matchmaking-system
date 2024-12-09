package com.arcticray.matchmaking_system.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankManagerTest {


    @Test
    void testGetRankForMMR_Unranked() {
        assertEquals("Unranked", RankManager.getRankForMMR(-1));
    }

    @Test
    void testGetRankForMMRWithDivisions() {
        assertEquals("Silver 4", RankManager.getRankForMMR(800));
        assertEquals("Silver 2", RankManager.getRankForMMR(1350));
        assertEquals("Silver 1", RankManager.getRankForMMR(1480));
        assertEquals("Gold 4", RankManager.getRankForMMR(1600));
        assertEquals("Platinum 4", RankManager.getRankForMMR(2400));
    }


}