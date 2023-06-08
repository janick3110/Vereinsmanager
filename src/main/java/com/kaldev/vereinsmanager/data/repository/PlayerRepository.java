package com.kaldev.vereinsmanager.data.repository;

import com.kaldev.vereinsmanager.data.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player,Integer> {
}
