package com.kaldev.vereinsmanager.tools.tournament.repository;

import com.kaldev.vereinsmanager.tools.tournament.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {
}
