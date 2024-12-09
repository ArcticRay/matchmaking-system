package com.arcticray.matchmaking_system.matchmaker;

import com.arcticray.matchmaking_system.model.Player;
import java.util.List;
import java.util.Map;

public class Game {

    private List<Player> team1;
    private List<Player> team2;

    private static final Map<String, Integer> rankValues = Map.of(
            "Bronze", 1,
            "Silver", 2,
            "Gold", 3,
            "Platinum", 4,
            "Diamond", 5,
            "Master", 6
    );

    public Game(List<Player> team1, List<Player> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public int calculateTotalMMR(List<Player> team) {
        return team.stream().mapToInt(Player::getMmr).sum();
    }

    public double calculateAverageRank(List<Player> team) {
        return team.stream()
                .mapToDouble(player -> rankValues.getOrDefault(getBaseRank(player.getRank()), 0))
                .average()
                .orElse(0.0);
    }

    public String getBaseRank(String rank) {
        return rank.split(" ")[0]; // Extract base rank (e.g., "Silver" from "Silver 3")
    }

    public List<Player> getTeam1() {
        return team1;
    }

    public List<Player> getTeam2() {
        return team2;
    }

    public void printTeamDetails(List<Player> team, String teamName) {
        System.out.println(teamName + " Details:");
        team.forEach(player -> System.out.println(player.getName() + " - MMR: " + player.getMmr() + ", Rank: " + player.getRank()));
        System.out.println("Total Team MMR: " + calculateTotalMMR(team));
        System.out.printf("Average Team Rank: %.2f%n", calculateAverageRank(team));
        System.out.println();
    }

    public void printGameDetails() {
        printTeamDetails(team1, "Team 1");
        printTeamDetails(team2, "Team 2");
    }
}
