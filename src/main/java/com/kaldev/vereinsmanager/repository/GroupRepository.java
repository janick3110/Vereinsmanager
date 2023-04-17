package com.kaldev.vereinsmanager.repository;

import com.kaldev.vereinsmanager.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository <Group,Integer> {
}
