package com.arcticray.matchmaking_system.model;

import jakarta.persistence.*;

@Entity
public class RoleStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role; // e.g., "Top", "Mid", "Jungle", "ADC", "Support"
    private int kills;
    private int deaths;
    private int assists;

    @Transient // Calculated field
    private double kda;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    // Constructors
    public RoleStats() {}

    public RoleStats(String role, int kills, int deaths, int assists, Player player) {
        this.role = role;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.player = player;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public double getKda() {
        return deaths > 0 ? (double) (kills + assists) / deaths : (kills + assists);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
