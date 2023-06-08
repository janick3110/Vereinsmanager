package com.kaldev.vereinsmanager.tools.tournament.controller;


import com.kaldev.vereinsmanager.tools.tournament.entity.Tournament;
import com.kaldev.vereinsmanager.tools.tournament.repository.TournamentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tournament/tournaments")
public class TournamentController {
    private TournamentRepository tournamentRepository;

    public TournamentController(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping("")
    public List<Tournament> tournaments(){
        return tournamentRepository.findAll();
    }
}
