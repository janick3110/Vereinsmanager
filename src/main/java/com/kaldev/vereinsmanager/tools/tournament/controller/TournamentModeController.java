package com.kaldev.vereinsmanager.tools.tournament.controller;

import com.kaldev.vereinsmanager.tools.tournament.entity.TournamentModes;
import com.kaldev.vereinsmanager.tools.tournament.repository.TournamentModesRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tournament/modes")
public class TournamentModeController {
    private TournamentModesRepository modesRepository;

    public TournamentModeController(TournamentModesRepository modesRepository) {
        this.modesRepository = modesRepository;
    }

    @GetMapping("")
    public List<TournamentModes> playfields(){
        return modesRepository.findAll();
    }
}
