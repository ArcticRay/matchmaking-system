package com.arcticray.matchmaking_system.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankManagerTest {

    @Test
    void testGetRankForMMR() {
        assertEquals("Bronze", RankManager.getRankForMMR(900));
        assertEquals("Silver", RankManager.getRankForMMR(1200));
        assertEquals("Gold", RankManager.getRankForMMR(1700));
        assertEquals("Platinum", RankManager.getRankForMMR(2200));
        assertEquals("Diamond", RankManager.getRankForMMR(2600));
        assertEquals("Master", RankManager.getRankForMMR(3100));
    }

    @Test
    void testGetRankForMMR_Unranked() {
        assertEquals("Unranked", RankManager.getRankForMMR(-1));
    }
}