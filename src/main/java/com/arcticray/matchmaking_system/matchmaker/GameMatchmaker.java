package com.arcticray.matchmaking_system.matchmaker;

import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.queue.PlayerQueue;

import java.util.*;

public class GameMatchmaker {

    public Game createBalancedGame(PlayerQueue queue) {
        // Step 1: Initialize role counters
        Map<String, Integer> roleCounts = initRoleCountMap();
        List<Player> selectedPlayers = new ArrayList<>();

        // Step 2: Select 10 players ensuring 2 from each role
        while (!queue.isEmpty() && selectedPlayers.size() < 10) {
            Player player = queue.getNextPlayer();
            String primaryRole = player.getPrimaryRole();
            String secondaryRole = player.getSecondaryRole();

            // Check if primary role can still be filled
            if (roleCounts.get(primaryRole) < 2) {
                selectedPlayers.add(player);
                roleCounts.put(primaryRole, roleCounts.get(primaryRole) + 1);
            }
            // Check secondary role as a fallback
            else if (roleCounts.get(secondaryRole) < 2) {
                selectedPlayers.add(player);
                roleCounts.put(secondaryRole, roleCounts.get(secondaryRole) + 1);
            }
        }

        // Step 3: Verify role distribution
        if (selectedPlayers.size() < 10) {
            throw new IllegalStateException("Not enough players to satisfy role requirements.");
        }

        // Step 4: Initialize teams and roles
        List<Player> team1 = new ArrayList<>();
        List<Player> team2 = new ArrayList<>();
        Map<String, Boolean> team1Roles = initRoleMap();
        Map<String, Boolean> team2Roles = initRoleMap();

        // Step 5: Assign players to teams
        for (Player player : selectedPlayers) {
            String assignedRole = null;

            // Prefer primary role
            if (!team1Roles.get(player.getPrimaryRole()) && team1.size() < 5) {
                assignedRole = player.getPrimaryRole();
                team1.add(player);
                team1Roles.put(assignedRole, true);
            } else if (!team2Roles.get(player.getPrimaryRole()) && team2.size() < 5) {
                assignedRole = player.getPrimaryRole();
                team2.add(player);
                team2Roles.put(assignedRole, true);
            } else if (!team1Roles.get(player.getSecondaryRole()) && team1.size() < 5) {
                assignedRole = player.getSecondaryRole();
                team1.add(player);
                team1Roles.put(assignedRole, true);
            } else if (!team2Roles.get(player.getSecondaryRole()) && team2.size() < 5) {
                assignedRole = player.getSecondaryRole();
                team2.add(player);
                team2Roles.put(assignedRole, true);
            }

            // Log assigned roles
            System.out.printf("Player: %s, Primary: %s, Secondary: %s, Assigned: %s%n",
                    player.getName(), player.getPrimaryRole(), player.getSecondaryRole(), assignedRole);
        }

        // Step 6: Balance teams by MMR
        balanceTeamsByMMR(team1, team2);

        return new Game(team1, team2);
    }

    private Map<String, Integer> initRoleCountMap() {
        Map<String, Integer> roleCounts = new HashMap<>();
        roleCounts.put("Top", 0);
        roleCounts.put("Mid", 0);
        roleCounts.put("Jungle", 0);
        roleCounts.put("ADC", 0);
        roleCounts.put("Support", 0);
        return roleCounts;
    }


    private Map<String, Boolean> initRoleMap() {
        Map<String, Boolean> roles = new HashMap<>();
        roles.put("Top", false);
        roles.put("Mid", false);
        roles.put("Jungle", false);
        roles.put("ADC", false);
        roles.put("Support", false);
        return roles;
    }

    private void balanceTeamsByMMR(List<Player> team1, List<Player> team2) {
        // Step 1: Calculate initial MMR difference
        int mmrTeam1 = calculateTotalMMR(team1);
        int mmrTeam2 = calculateTotalMMR(team2);
        int initialDifference = Math.abs(mmrTeam1 - mmrTeam2);

        boolean balanced = false;

        // Step 2: Attempt to swap players to balance teams
        while (!balanced) {
            Player bestSwap1 = null;
            Player bestSwap2 = null;
            int bestImprovement = initialDifference;

            for (Player p1 : team1) {
                for (Player p2 : team2) {
                    // Swap the players virtually
                    int newTeam1MMR = mmrTeam1 - p1.getMmr() + p2.getMmr();
                    int newTeam2MMR = mmrTeam2 - p2.getMmr() + p1.getMmr();
                    int newDifference = Math.abs(newTeam1MMR - newTeam2MMR);

                    // Check if the new difference is better
                    if (newDifference < bestImprovement && isRoleCompatible(team1, team2, p1, p2)) {
                        bestSwap1 = p1;
                        bestSwap2 = p2;
                        bestImprovement = newDifference;
                    }
                }
            }

            // If no better swap is found, the teams are balanced
            if (bestSwap1 == null || bestSwap2 == null) {
                balanced = true;
            } else {
                // Perform the best swap
                team1.remove(bestSwap1);
                team2.remove(bestSwap2);
                team1.add(bestSwap2);
                team2.add(bestSwap1);

                // Update MMR totals
                mmrTeam1 = calculateTotalMMR(team1);
                mmrTeam2 = calculateTotalMMR(team2);
            }
        }

        System.out.println("Final MMR Difference: " + Math.abs(mmrTeam1 - mmrTeam2));
    }

    private boolean isRoleCompatible(List<Player> team1, List<Player> team2, Player p1, Player p2) {
        // Ensure that swapping p1 and p2 does not violate role constraints
        return hasRole(team1, p2.getPrimaryRole()) && hasRole(team2, p1.getPrimaryRole());
    }

    private boolean hasRole(List<Player> team, String role) {
        return team.stream().noneMatch(player -> player.getPrimaryRole().equals(role));
    }

    private int calculateTotalMMR(List<Player> team) {
        return team.stream().mapToInt(Player::getMmr).sum();
    }

    public Game createGame(PlayerQueue queue) {
        List<Player> team1 = new ArrayList<>();
        List<Player> team2 = new ArrayList<>();

        while (!queue.isEmpty()) {
            if (team1.size() < 5) {
                team1.add(queue.getNextPlayer());
            } else if (team2.size() < 5) {
                team2.add(queue.getNextPlayer());
            } else {
                break;
            }
        }
        return new Game(team1, team2);
    }
}
