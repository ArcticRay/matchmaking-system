package com.arcticray.matchmaking_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int mmr;
    private String rank;
    private String region;
    private String primaryRole;
    private String secondaryRole;
    private int wins;
    private int losses;
    private int gamesPlayed;

    @Transient
    private double winrate;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoleStats> roleStats = new ArrayList<>();

    // Constructors, Getters, and Setters
    public Player() {}

    public Player(String name, int mmr, String rank, String region, String primaryRole, String secondaryRole) {
        this.name = name;
        this.mmr = mmr;
        this.rank = rank;
        this.region = region;
        this.primaryRole = primaryRole;
        this.secondaryRole = secondaryRole;
        this.wins = 0;
        this.losses = 0;
        this.gamesPlayed = 0;
    }

    public void addRoleStats(RoleStats stats) {
        this.roleStats.add(stats);
        stats.setPlayer(this);
    }

    public void removeRoleStats(RoleStats stats) {
        this.roleStats.remove(stats);
        stats.setPlayer(null);
    }




    // Getter and Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMmr() {
        return mmr;
    }

    public String getRank() {
        return rank;
    }

    public String getRegion() {
        return region;
    }

    public String getPrimaryRole() {
        return primaryRole;
    }

    public String getSecondaryRole() {
        return secondaryRole;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public double getWinrate() {
        return winrate;
    }

    public List<RoleStats> getRoleStats() {
        return roleStats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPrimaryRole(String primaryRole) {
        this.primaryRole = primaryRole;
    }

    public void setSecondaryRole(String secondaryRole) {
        this.secondaryRole = secondaryRole;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setWinrate(double winrate) {
        this.winrate = winrate;
    }

    public void setRoleStats(List<RoleStats> roleStats) {
        this.roleStats = roleStats;
    }
}
