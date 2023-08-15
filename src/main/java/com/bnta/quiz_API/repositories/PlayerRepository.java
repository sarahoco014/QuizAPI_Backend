package com.bnta.quiz_API.repositories;

import com.bnta.quiz_API.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player, Integer> {
}
