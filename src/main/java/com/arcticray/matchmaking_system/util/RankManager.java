package com.arcticray.matchmaking_system.util;

import java.util.Map;
import java.util.TreeMap;

public class RankManager {

    private static final TreeMap<Integer, String> rankMap = new TreeMap<>();

    static {
        // Define MMR thresholds for ranks with 800 MMR per rank
        rankMap.put(0, "Bronze");
        rankMap.put(800, "Silver");
        rankMap.put(1600, "Gold");
        rankMap.put(2400, "Platinum");
        rankMap.put(3200, "Diamond");
        rankMap.put(4000, "Master");
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
        // Each rank covers 800 MMR, and each division spans 200 MMR
        if (mmrDifference < 0) return 4; // Lowest division
        return 4 - (mmrDifference / 200); // Division I is highest
    }
}
