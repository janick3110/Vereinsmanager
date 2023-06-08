package com.kaldev.vereinsmanager.data.service;

import com.kaldev.vereinsmanager.data.entity.Player;
import com.kaldev.vereinsmanager.data.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> listAllUser() {
        return playerRepository.findAll();
    }

    public void saveUser(Player player) {
        playerRepository.save(player);
    }

    public Player getUser(Integer id) {
        return playerRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        playerRepository.deleteById(id);
    }
}
