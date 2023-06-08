package com.kaldev.vereinsmanager.tools.tournament.repository;

import com.kaldev.vereinsmanager.tools.tournament.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Integer> {
}
