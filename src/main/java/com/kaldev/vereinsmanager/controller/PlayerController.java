package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Player;
import com.kaldev.vereinsmanager.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/player")
public class PlayerController {

    private PlayerRepository playerRepository;

    public PlayerController(PlayerRepository controller) {
        this.playerRepository = controller;
    }

    @GetMapping("")
    public List<Player> playerList(){
        return playerRepository.findAll();
    }
}
