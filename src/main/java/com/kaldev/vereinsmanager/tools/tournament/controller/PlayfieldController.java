package com.kaldev.vereinsmanager.tools.tournament.controller;

import com.kaldev.vereinsmanager.tools.tournament.entity.Game;
import com.kaldev.vereinsmanager.tools.tournament.entity.Playfield;
import com.kaldev.vereinsmanager.tools.tournament.repository.GameRepository;
import com.kaldev.vereinsmanager.tools.tournament.repository.PlayfieldRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tournament/playfields")
public class PlayfieldController {
    private PlayfieldRepository playfieldRepository;

    public PlayfieldController(PlayfieldRepository playfieldRepository) {
        this.playfieldRepository = playfieldRepository;
    }

    @GetMapping("")
    public List<Playfield> playfields(){
        return playfieldRepository.findAll();
    }
}
