package com.kaldev.vereinsmanager.tools.tournament.controller;

import com.kaldev.vereinsmanager.tools.tournament.entity.Playfield;
import com.kaldev.vereinsmanager.tools.tournament.entity.Team;
import com.kaldev.vereinsmanager.tools.tournament.repository.TeamRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tournament/teams")
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("")
    public List<Team> teams(){
        return teamRepository.findAll();
    }
}
