package com.arcticray.matchmaking_system.queue;

import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.service.RoleManager;

import java.util.*;

public class PlayerQueue {


    private ArrayList<Queue> queues;
    private Queue<Player> topQueue;
    private Queue<Player> jungleQueue;
    private Queue<Player> midQueue;
    private Queue<Player> adcQueue;
    private Queue<Player> supportQueue;


    public PlayerQueue() {
        this.topQueue = new PriorityQueue<>(Comparator.comparingInt(Player::getMmr)); // Sorted by MMR
        this.jungleQueue = new PriorityQueue<>(Comparator.comparingInt(Player::getMmr)); // Sorted by MMR
        this.midQueue = new PriorityQueue<>(Comparator.comparingInt(Player::getMmr)); // Sorted by MMR
        this.adcQueue = new PriorityQueue<>(Comparator.comparingInt(Player::getMmr)); // Sorted by MMR
        this.supportQueue = new PriorityQueue<>(Comparator.comparingInt(Player::getMmr)); // Sorted by MMR

        queues = new ArrayList<>();
        queues.add(topQueue);
        queues.add(jungleQueue);
        queues.add(midQueue);
        queues.add(adcQueue);
        queues.add(supportQueue);
    }

    public void printQueue() {
        for (Queue queue : queues) {
            for (Object p : queue) {
                Player player = (Player) p;
                System.out.println("Spieler " + player.getName() + " mit einer MMR von: " + player.getMmr() + " und dem Rank: " + player.getRank() + " und der Rolle: " + player.getPrimaryRole() );
            }
        }

    }

    public void add(Player p) {

        RoleManager.Role role = p.getPrimaryRole();

        if (role == RoleManager.Role.TOP) {
            topQueue.add(p);
        } else if (role == RoleManager.Role.JUNGLE) {
            jungleQueue.add(p);
        }
        else if (role == RoleManager.Role.MID) {
            midQueue.add(p);
        }
        else if (role == RoleManager.Role.ADC) {
            adcQueue.add(p);
        }
        else if (role == RoleManager.Role.SUPPORT) {
            supportQueue.add(p);
        }

        else {
            System.out.println("Unbekannte Role: " + role);
        }
    }
}
