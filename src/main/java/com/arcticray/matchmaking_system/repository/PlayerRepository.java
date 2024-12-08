package com.arcticray.matchmaking_system.repository;

import com.arcticray.matchmaking_system.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {}
