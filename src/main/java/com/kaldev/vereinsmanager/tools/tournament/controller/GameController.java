package com.kaldev.vereinsmanager.tools.tournament.controller;


import com.kaldev.vereinsmanager.data.entity.Roles;
import com.kaldev.vereinsmanager.tools.tournament.entity.Game;
import com.kaldev.vereinsmanager.tools.tournament.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tournament/games")
public class GameController {
    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("")
    public List<Game> games(){
        return gameRepository.findAll();
    }
}
