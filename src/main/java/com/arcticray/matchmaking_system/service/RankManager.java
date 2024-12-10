package com.arcticray.matchmaking_system.service;

import java.util.*;

public class RankManager {

    private static final TreeMap<Integer, String> rankMap = new TreeMap<>();

    static {
        // Define MMR thresholds for ranks with 800 MMR per rank
        rankMap.put(0, "Iron");
        rankMap.put(400, "Bronze");
        rankMap.put(800, "Silver");
        rankMap.put(1200, "Gold");
        rankMap.put(1600, "Platinum");
        rankMap.put(2000, "Emerald");
        rankMap.put(2400, "Diamond");
        rankMap.put(2800, "Master");
    }

    public static String getRankForMMR(int mmr) {
        Map.Entry<Integer, String> entry = rankMap.floorEntry(mmr);
        if (entry == null) return "Unranked";

        String rank = entry.getValue();
        int rankStartMMR = entry.getKey();
        int division = calculateDivision(mmr - rankStartMMR);

        return rank + " " + division;
    }

    private static int calculateDivision(int mmrDifference) {
        // Each rank covers 400 MMR, and each division spans 100 MMR
        if (mmrDifference < 0) return 4; // Lowest division
        return 4 - (mmrDifference / 100); // Division I is highest
    }
}
