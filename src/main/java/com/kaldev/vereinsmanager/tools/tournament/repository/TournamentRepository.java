package com.kaldev.vereinsmanager.tools.tournament.repository;

import com.kaldev.vereinsmanager.tools.tournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament,Integer> {
}
