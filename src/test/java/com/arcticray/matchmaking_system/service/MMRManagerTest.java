package com.arcticray.matchmaking_system.service;

import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MMRManagerTest {

    @Mock
    private MMRService mmrService;

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private MMRManager mmrManager;

    private Player player;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock player data
        player = new Player("TestPlayer", 1200, "Silver", "EUW", "Mid", "Support");
        player.setWins(10);
        player.setLosses(5);
    }

    @Test
    void testUpdatePlayerMMR_Win() {
        // Arrange
        int opponentMMRSum = 6250; // Summe der MMR von 5 Gegnern (z. B. 1250 x 5)
        when(mmrService.calculateMMR(1200, true, opponentMMRSum)).thenReturn(1220);

        // Act
        mmrManager.updatePlayerMMR(player, true, opponentMMRSum);

        // Assert
        assertEquals(1220, player.getMmr());
        assertEquals(11, player.getWins());
        assertEquals(5, player.getLosses());
        verify(playerRepository, times(1)).save(player);

        // Console output
        System.out.println("Test Passed: Player MMR updated correctly after a win.");
        System.out.printf("New MMR: %d, Wins: %d, Losses: %d%n", player.getMmr(), player.getWins(), player.getLosses());
    }

    @Test
    void testUpdatePlayerMMR_Loss() {
        // Arrange
        int opponentMMRSum = 6250; // Summe der MMR von 5 Gegnern
        when(mmrService.calculateMMR(1200, false, opponentMMRSum)).thenReturn(1180);

        // Act
        mmrManager.updatePlayerMMR(player, false, opponentMMRSum);

        // Assert
        assertEquals(1180, player.getMmr());
        assertEquals(10, player.getWins());
        assertEquals(6, player.getLosses());
        verify(playerRepository, times(1)).save(player);

        // Console output
        System.out.println("Test Passed: Player MMR updated correctly after a loss.");
        System.out.printf("New MMR: %d, Wins: %d, Losses: %d%n", player.getMmr(), player.getWins(), player.getLosses());
    }

    @Test
    void testUpdatePlayerRank() {
        // Arrange
        player.setMmr(2000);

        // Act
        mmrManager.updatePlayerRank(player);

        // Assert
        assertEquals("Platinum", player.getRank());

        // Console output
        System.out.println("Test Passed: Player rank updated correctly.");
        System.out.printf("Player MMR: %d, New Rank: %s%n", player.getMmr(), player.getRank());
    }

    @Test
    void testUpdatePlayerRank_NoChange() {
        // Arrange
        player.setMmr(1200);
        player.setRank("Silver");

        // Act
        mmrManager.updatePlayerRank(player);

        // Assert
        assertEquals("Silver", player.getRank());
        System.out.println("Test Passed: No rank change for the player.");
        System.out.printf("Player MMR: %d, Rank: %s%n", player.getMmr(), player.getRank());
    }
}
