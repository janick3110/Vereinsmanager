package com.kaldev.vereinsmanager.data.repository;

import com.kaldev.vereinsmanager.data.entity.SportsActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsActivityRepository extends JpaRepository <SportsActivity,Integer> {
}
