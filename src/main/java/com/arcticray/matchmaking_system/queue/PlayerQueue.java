package com.arcticray.matchmaking_system.queue;

import com.arcticray.matchmaking_system.model.Player;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PlayerQueue {

    private PriorityQueue<Player> queue;

    public PlayerQueue() {
        this.queue = new PriorityQueue<>(Comparator.comparingInt(Player::getMmr)); // Sorted by MMR
    }

    public void addPlayer(Player player) {
        queue.offer(player);
    }

    public Player getNextPlayer() {
        return queue.poll();
    }

    public int getSize() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
