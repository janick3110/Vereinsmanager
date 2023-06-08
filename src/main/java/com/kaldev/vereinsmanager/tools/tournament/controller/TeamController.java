package com.kaldev.vereinsmanager.tools.tournament.controller;

import com.kaldev.vereinsmanager.tools.tournament.entity.Playfield;
import com.kaldev.vereinsmanager.tools.tournament.entity.Team;
import com.kaldev.vereinsmanager.tools.tournament.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/new")
    public @ResponseBody HttpStatus addNewTeam (
            @RequestParam String name,
            @RequestParam int idOfTournament
    ) {

        try {
            Team team = new Team();

            team.setIdOfTournament(idOfTournament);
            team.setName(name);

            teamRepository.save(team);

            return HttpStatus.OK;

        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }

    public List<Team> getAllTeamsFromTournament (int idOfTournament) {

        try {
            List<Team> allTeams = teams();
            List<Team> participatingTeams = new ArrayList<>();

            for (Team team:allTeams
                 ) {
                if (team.getIdOfTournament() == idOfTournament){
                    participatingTeams.add(team);
                }
            }
            return participatingTeams;

        } catch (Exception e){
            return new ArrayList<>();
        }
    }
}
