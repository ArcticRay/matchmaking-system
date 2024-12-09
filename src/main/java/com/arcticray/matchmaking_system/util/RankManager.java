package com.arcticray.matchmaking_system.util;

import java.util.Map;
import java.util.TreeMap;

public class RankManager {

    private static final TreeMap<Integer, String> rankMap = new TreeMap<>();

    static {
        // Define MMR thresholds for ranks
        rankMap.put(0, "Bronze");
        rankMap.put(1000, "Silver");
        rankMap.put(1500, "Gold");
        rankMap.put(2000, "Platinum");
        rankMap.put(2500, "Diamond");
        rankMap.put(3000, "Master");
    }

    public static String getRankForMMR(int mmr) {
        // Finds the floor entry (highest MMR less than or equal to the given MMR)
        Map.Entry<Integer, String> entry = rankMap.floorEntry(mmr);
        return entry != null ? entry.getValue() : "Unranked";
    }
}
