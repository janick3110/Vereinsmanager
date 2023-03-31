package com.kaldev.vereinsmanager.repository;

import com.kaldev.vereinsmanager.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player,Long> {
}
