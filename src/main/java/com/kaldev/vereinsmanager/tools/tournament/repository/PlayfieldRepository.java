package com.kaldev.vereinsmanager.tools.tournament.repository;

import com.kaldev.vereinsmanager.tools.tournament.entity.Playfield;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayfieldRepository extends JpaRepository<Playfield,Integer> {
}
