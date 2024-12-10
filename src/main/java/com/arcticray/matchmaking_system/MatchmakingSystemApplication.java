package com.arcticray.matchmaking_system;

import com.arcticray.matchmaking_system.model.Player;
import com.arcticray.matchmaking_system.queue.PlayerQueue;
import com.arcticray.matchmaking_system.util.StartGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatchmakingSystemApplication {


	public static void main(String[] args) {

		SpringApplication.run(MatchmakingSystemApplication.class, args);

		StartGame startGame = new StartGame();
		startGame.startGame();


	}

}
