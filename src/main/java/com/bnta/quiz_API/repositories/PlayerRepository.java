package com.bnta.quiz_API.repositories;

import com.bnta.quiz_API.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Integer> {
}
